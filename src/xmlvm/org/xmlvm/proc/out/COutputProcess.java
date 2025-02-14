/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

package org.xmlvm.proc.out;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.xmlvm.Log;
import org.xmlvm.main.Arguments;
import org.xmlvm.main.Targets;
import org.xmlvm.proc.BundlePhase1;
import org.xmlvm.proc.BundlePhase2;
import org.xmlvm.proc.NativeResourceLoader;
import org.xmlvm.proc.XmlvmProcessImpl;
import org.xmlvm.proc.XmlvmResource;
import org.xmlvm.proc.XmlvmResource.Type;
import org.xmlvm.proc.XsltRunner;
import org.xmlvm.util.universalfile.UniversalFile;
import org.xmlvm.util.universalfile.UniversalFileCreator;

/**
 * This process takes XMLVM and generates C source code from it.
 */
public class COutputProcess extends XmlvmProcessImpl {
    private static final String              TAG             = COutputProcess.class.getSimpleName();
    public static final String               TAG_CLASS_NAME  = "CLASS-NAME";
    private static final String              C_SOURCE_SUFFIX = "c";

    private final String                     sourceExtension;
    private final String                     headerExtension = ".h";

    private final Map<String, XmlvmResource> resourcePool    = new HashMap<String, XmlvmResource>();
    private final NativeResourceLoader       nativeResourceLoader;


    /**
     * Initializes the {@link COutputProcess} with the given arguments.
     */
    public COutputProcess(Arguments arguments) {
        super(arguments);
        sourceExtension = "." + arguments.option_c_source_extension();
        addSupportedInput(VtableOutputProcess.class);

        nativeResourceLoader = new NativeResourceLoader(UniversalFileCreator.createDirectory(
                "/lib/native-c-lib.jar", "src/xmlvm2c/lib/native"), C_SOURCE_SUFFIX);
    }

    @Override
    public boolean processPhase1(BundlePhase1 bundle) {
        return true;
    }

    @Override
    public boolean processPhase2(BundlePhase2 bundle) {
        for (XmlvmResource xmlvm : bundle.getResources()) {
            if (xmlvm != null) {
                resourcePool.put(xmlvm.getFullName(), xmlvm);
            }
        }

        List<OutputFile> xmlvmFiles = new ArrayList<OutputFile>();
        for (OutputFile outputFile : bundle.getOutputFiles()) {
            // Pass-through all non-xmlvm files.
            if (outputFile.getFileName().endsWith(".xmlvm")) {
                bundle.removeOutputFile(outputFile);
                xmlvmFiles.add(outputFile);
            }
        }

        if (arguments.option_gen_native_skeletons()) {
            for (XmlvmResource xmlvm : resourcePool.values()) {
                if (xmlvm.getType() == Type.CONST_POOL) {
                    continue;
                }
                OutputFile file = genNativeSkeletons(xmlvm);
                if (file != null) {
                    file.setLocation(arguments.option_out());
                    bundle.addOutputFile(file);
                }
            }
            return true;
        }

        // Process all collected resources.
        for (XmlvmResource xmlvm : resourcePool.values()) {
            OutputFile[] files = new OutputFile[0];
            if (xmlvm.getType() == Type.CONST_POOL) {
                if (arguments.option_target() != Targets.GENCWRAPPERS) {
                    files = genConstantPool(xmlvm);
                }
            } else {
                files = genC(xmlvm);
            }
            for (OutputFile file : files) {
                file.setLocation(arguments.option_out());
                bundle.addOutputFile(file);
            }
        }

        // Makes sure that for each type we create, the native parts, if
        // present, are added to the list of outputFiles.
        bundle.addOutputFiles(loadNativeResources(bundle.getOutputFiles()));
        return true;
    }

    /**
     * For the given set of outputFiles, this methods loads all native parts.
     */
    private Collection<OutputFile> loadNativeResources(Collection<OutputFile> outputFiles) {
        Log.debug(TAG, "Loading native resources");

        List<OutputFile> result = new ArrayList<OutputFile>();
        Set<String> types = new HashSet<String>();
        for (OutputFile outputFile : outputFiles) {
            String fileName = outputFile.getFileName();
            if (fileName.endsWith(sourceExtension)) {
                String typeName = fileName.substring(0,
                        fileName.length() - sourceExtension.length());
                types.add(typeName);
            }
        }
        for (UniversalFile nativeFile : nativeResourceLoader.load(types)) {
            OutputFile outputFile = new OutputFile(nativeFile);
            outputFile.setLocation(arguments.option_out());
            String nativeFileName = nativeFile.getName();
            outputFile.setFileName(nativeFileName.substring(0, nativeFileName.length()
                    - (C_SOURCE_SUFFIX.length() + 1))
                    + sourceExtension);
            result.add(outputFile);
        }
        return result;
    }

    /**
     * From the given XmlvmResource creates a header as well as C-file.
     */
    public OutputFile[] genC(XmlvmResource xmlvm) {
        Document doc = xmlvm.getXmlvmDocument();
        // The filename will be the name of the first class
        String namespaceName = xmlvm.getPackageName();
        String inheritsFrom = xmlvm.getSuperTypeName().replace('.', '_').replace('$', '_');
        String className = xmlvm.getName().replace('$', '_');
        String fileNameStem = (namespaceName + "." + className).replace('.', '_');
        String headerFileName = fileNameStem + headerExtension;
        String mFileName = fileNameStem + sourceExtension;

        String headerProlog = "#ifndef __" + fileNameStem.toUpperCase() + "__\n";
        headerProlog += "#define __" + fileNameStem.toUpperCase() + "__\n\n";

        String headerEpilog = "\n#endif\n";

        StringBuilder headerBuffer = new StringBuilder();
        headerBuffer.append("#include \"xmlvm.h\"\n");
        List<String> typesForHeader = getTypesForHeader(doc.getRootElement());
        for (String i : typesForHeader) {
            if (i.equals(inheritsFrom)) {
                headerBuffer.append("#include \"" + i + ".h\"\n");
            }
        }
        String interfaces = xmlvm.getInterfaces();
        if (interfaces != null) {
            for (String i : interfaces.split(",")) {
                i = i.replace('.', '_').replace('$', '_') + ".h\"\n";
                headerBuffer.append("#include \"" + i);
            }
        }
        headerBuffer.append("\n// Circular references:\n");
        for (String i : typesForHeader) {
            headerBuffer.append("#ifndef XMLVM_FORWARD_DECL_" + i + "\n");
            headerBuffer.append("#define XMLVM_FORWARD_DECL_" + i + "\n");
            headerBuffer.append("XMLVM_FORWARD_DECL(" + i + ")\n");
            headerBuffer.append("#endif\n");
        }
        OutputFile headerFile = XsltRunner.runXSLT("xmlvm2c.xsl", doc, new String[][] {
                { "pass", "emitHeader" }, { "header", headerFileName } });
        headerFile.setData(headerProlog + headerBuffer.toString() + headerFile.getDataAsString()
                + headerEpilog);
        headerFile.setFileName(headerFileName);

        StringBuilder mBuffer = new StringBuilder();
        mBuffer.append("#include \"xmlvm.h\"\n");
        for (String i : typesForHeader) {
            String toIgnore = (namespaceName + "_" + className).replace('.', '_');
            if (!i.equals(inheritsFrom) && !i.equals(toIgnore)) {
                mBuffer.append("#include \"" + i + ".h\"\n");
            }
        }

        OutputFile mFile = XsltRunner.runXSLT("xmlvm2c.xsl", doc, new String[][] {
                { "pass", "emitImplementation" }, { "header", headerFileName } });
        mFile.setData(mBuffer.toString() + mFile.getDataAsString());
        mFile.setFileName(mFileName);

        String clazz = xmlvm.getFullName().replace('.', '_').replace('$', '_');
        mFile.setTag(TAG_CLASS_NAME, clazz);

        return new OutputFile[] { headerFile, mFile };
    }

    /**
     * Generates the string constant pool for this application. The constant
     * pool is also generated by the xmlvm2c.xsl stylesheet. The generated C
     * code is essentially a <code>const char*</code> array of the individual
     * strings that occur in the application. The index of a string into this
     * array represents the constant pool ID.
     * 
     * @param xmlvm
     *            An XmlvmResource of type CONST_POOL.
     * @return An OutputFile containing the constant pool.
     */
    private OutputFile[] genConstantPool(XmlvmResource xmlvm) {
        Document doc = xmlvm.getXmlvmDocument();

        OutputFile constPoolFile = XsltRunner.runXSLT("xmlvm2c.xsl", doc);
        constPoolFile.setFileName("constant_pool" + sourceExtension);

        return new OutputFile[] { constPoolFile };
    }

    private List<String> getTypesForHeader(Element node) {
        HashSet<String> seen = new HashSet<String>();
        for (Object o : node.getChildren()) {
            if (!(o instanceof Element)) {
                continue;
            }
            Element cur = (Element) o;
            String curName = cur.getName();

            // Ignore assertions.
            if (cur.getName().equals("assert-red-class")) {
                continue;
            }

            // Ignore parameter types of invoke instructions
            if (cur.getName().equals("parameters")) {
                continue;
            }

            Attribute a = cur.getAttribute("type");
            if (a != null) {
                if (curName.equals("parameter")) {
                    Attribute redType = cur.getAttribute("isRedType");
                    if (redType == null || !redType.getValue().equals("true")) {
                        seen.add(a.getValue());
                    }
                } else if (!curName.equals("var") && !curName.equals("return")) {
                    seen.add(a.getValue());
                }
            }
            a = cur.getAttribute("extends");
            if (a != null && !a.getValue().equals("")) {
                seen.add(a.getValue());
            }
            a = cur.getAttribute("interfaces");
            if (a != null) {
                for (String iface : a.getValue().split(",")) {
                    seen.add(iface);
                }
            }
            a = cur.getAttribute("class-type");

            // In the C code we don't care about the type in move-exception and
            // throw.
            // We also don't care (yet) about monitor-enter etc.
            if (a != null && !curName.equals("move-exception") && !curName.equals("throw")
                    && !curName.startsWith("monitor-")) {
                seen.add(a.getValue());
            }
            if (cur.getName().equals("const-class")) {
                a = cur.getAttribute("value");
                if (a != null) {
                    seen.add(a.getValue());
                }
            }
            a = cur.getAttribute("kind");
            if (a != null && a.getValue().equals("type")) {
                a = cur.getAttribute("value");
                if (a != null) {
                    seen.add(a.getValue());
                }
            }
            seen.addAll(getTypesForHeader(cur));
        }
        HashSet<String> bad = new HashSet<String>();
        for (String t : new String[] { "char", "float", "double", "int", "void", "boolean",
                "short", "byte", "float", "long", "null" }) {
            bad.add(t);
        }
        List<String> toRet = new ArrayList<String>();
        for (String t : seen) {
            int i = t.indexOf('[');
            String baseType = i == -1 ? t : t.substring(0, i);
            if (!bad.contains(baseType)) {
                toRet.add(baseType.replace('.', '_').replace('$', '_'));
            }
        }
        return toRet;
    }

    /**
     * Generates C-source code skeletons for all native methods of a class. This
     * method will be triggered by the --gen-native-skeletons option. vtable
     * indices are correctly initialized for non-static native methods.
     * 
     * @param resource
     *            Class for which skeletons are to be generated.
     * @return Generated C-source code. If class contains no native methods,
     *         null is returned.
     */
    public OutputFile genNativeSkeletons(XmlvmResource resource) {
        Document doc = resource.getXmlvmDocument();
        // The filename will be the name of the first class
        String namespaceName = resource.getPackageName();
        String className = resource.getName().replace('$', '_');
        String fileNameStem = (namespaceName + "." + className).replace('.', '_');
        String headerFileName = fileNameStem + headerExtension;
        String mFileName = "native_" + fileNameStem + sourceExtension;

        StringBuilder mBuffer = new StringBuilder();
        mBuffer.append("\n#include \"xmlvm.h\"\n");
        mBuffer.append("#include \"" + headerFileName + "\"\n\n");

        OutputFile mFile = XsltRunner.runXSLT("xmlvm2c.xsl", doc, new String[][] {
                { "pass", "emitNativeSkeletons" }, { "header", headerFileName } });

        if (mFile.isEmpty()) {
            return null;
        }

        mFile.setData(mBuffer.toString() + mFile.getDataAsString());
        mFile.setFileName(mFileName);

        return mFile;
    }
}
