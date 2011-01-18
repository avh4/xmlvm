#include "xmlvm.h"
#include "org_xmlvm_iphone_NSXMLParserDelegate.h"
#include "org_xmlvm_iphone_NSData.h"

#include "org_xmlvm_iphone_NSXMLParser.h"

__TIB_DEFINITION_org_xmlvm_iphone_NSXMLParser __TIB_org_xmlvm_iphone_NSXMLParser = {
    0, // classInitialized
    "org.xmlvm.iphone.NSXMLParser", // className
    (__TIB_DEFINITION_TEMPLATE*) &__TIB_org_xmlvm_iphone_NSObject, // extends
    XMLVM_TYPE_CLASS};

JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSXMLParser;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSXMLParser_ARRAYTYPE;

//XMLVM_BEGIN_IMPLEMENTATION
//XMLVM_END_IMPLEMENTATION


#include "xmlvm-reflection.h"

static XMLVM_FIELD_REFLECTION_DATA __field_reflection_data[] = {
};

static JAVA_OBJECT* __constructor0_arg_types[] = {
    &__CLASS_org_xmlvm_iphone_NSData,
};

static XMLVM_CONSTRUCTOR_REFLECTION_DATA __constructor_reflection_data[] = {
    {&__constructor0_arg_types[0],
    sizeof(__constructor0_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
};

static JAVA_OBJECT constructor_dispatcher(JAVA_OBJECT constructor, JAVA_OBJECT arguments)
{
    JAVA_OBJECT obj = __NEW_org_xmlvm_iphone_NSXMLParser();
    java_lang_reflect_Constructor* c = (java_lang_reflect_Constructor*) constructor;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (c->fields.java_lang_reflect_Constructor.slot_) {
    case 0:
        org_xmlvm_iphone_NSXMLParser___INIT____org_xmlvm_iphone_NSData(obj, argsArray[0]);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return obj;
}

void __INIT_org_xmlvm_iphone_NSXMLParser()
{
    __TIB_org_xmlvm_iphone_NSXMLParser.classInitialized = 1;
    // Initialize base class if necessary
    if (!__TIB_org_xmlvm_iphone_NSObject.classInitialized) __INIT_org_xmlvm_iphone_NSObject();
    __TIB_org_xmlvm_iphone_NSXMLParser.newInstanceFunc = __NEW_INSTANCE_org_xmlvm_iphone_NSXMLParser;
    // Copy vtable from base class
    XMLVM_MEMCPY(__TIB_org_xmlvm_iphone_NSXMLParser.vtable, __TIB_org_xmlvm_iphone_NSObject.vtable, sizeof(__TIB_org_xmlvm_iphone_NSObject.vtable));
    // Initialize vtable for this class
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[14] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_setDelegate___org_xmlvm_iphone_NSXMLParserDelegate;
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[15] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_setShouldProcessNamespaces___boolean;
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[16] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_shouldProcessNamespaces__;
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[17] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_setShouldReportNamespacePrefixes___boolean;
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[18] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_shouldReportNamespacePrefixes__;
    __TIB_org_xmlvm_iphone_NSXMLParser.vtable[19] = (VTABLE_PTR) &org_xmlvm_iphone_NSXMLParser_parse__;
    // Initialize vtable for implementing interfaces
    __TIB_org_xmlvm_iphone_NSXMLParser.numImplementedInterfaces = 0;
    __TIB_org_xmlvm_iphone_NSXMLParser.implementedInterfaces = (__TIB_DEFINITION_TEMPLATE* (*)[1]) XMLVM_MALLOC(sizeof(__TIB_DEFINITION_TEMPLATE*) * 0);

    __TIB_org_xmlvm_iphone_NSXMLParser.declaredFields = &__field_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSXMLParser.numDeclaredFields = sizeof(__field_reflection_data) / sizeof(XMLVM_FIELD_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_NSXMLParser.constructorDispatcherFunc = constructor_dispatcher;
    __TIB_org_xmlvm_iphone_NSXMLParser.declaredConstructors = &__constructor_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSXMLParser.numDeclaredConstructors = sizeof(__constructor_reflection_data) / sizeof(XMLVM_CONSTRUCTOR_REFLECTION_DATA);
    __CLASS_org_xmlvm_iphone_NSXMLParser = XMLVM_CREATE_CLASS_OBJECT(&__TIB_org_xmlvm_iphone_NSXMLParser);
    __TIB_org_xmlvm_iphone_NSXMLParser.clazz = __CLASS_org_xmlvm_iphone_NSXMLParser;
    __CLASS_org_xmlvm_iphone_NSXMLParser_ARRAYTYPE = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSXMLParser, 1);

    //XMLVM_BEGIN_WRAPPER[__INIT_org_xmlvm_iphone_NSXMLParser]
    //XMLVM_END_WRAPPER
}

void __DELETE_org_xmlvm_iphone_NSXMLParser(void* me, void* client_data)
{
    //XMLVM_BEGIN_WRAPPER[__DELETE_org_xmlvm_iphone_NSXMLParser]
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT __NEW_org_xmlvm_iphone_NSXMLParser()
{
    if (!__TIB_org_xmlvm_iphone_NSXMLParser.classInitialized) __INIT_org_xmlvm_iphone_NSXMLParser();
    org_xmlvm_iphone_NSXMLParser* me = (org_xmlvm_iphone_NSXMLParser*) XMLVM_MALLOC(sizeof(org_xmlvm_iphone_NSXMLParser));
    me->tib = &__TIB_org_xmlvm_iphone_NSXMLParser;
    //XMLVM_BEGIN_WRAPPER[__NEW_org_xmlvm_iphone_NSXMLParser]
    //XMLVM_END_WRAPPER
    return me;
}

JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_NSXMLParser()
{
    JAVA_OBJECT me = JAVA_NULL;
    return me;
}

void org_xmlvm_iphone_NSXMLParser___INIT____org_xmlvm_iphone_NSData(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser___INIT____org_xmlvm_iphone_NSData]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSXMLParser_setDelegate___org_xmlvm_iphone_NSXMLParserDelegate(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_setDelegate___org_xmlvm_iphone_NSXMLParserDelegate]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSXMLParser_setShouldProcessNamespaces___boolean(JAVA_OBJECT me, JAVA_BOOLEAN n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_setShouldProcessNamespaces___boolean]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

JAVA_BOOLEAN org_xmlvm_iphone_NSXMLParser_shouldProcessNamespaces__(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_shouldProcessNamespaces__]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSXMLParser_setShouldReportNamespacePrefixes___boolean(JAVA_OBJECT me, JAVA_BOOLEAN n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_setShouldReportNamespacePrefixes___boolean]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

JAVA_BOOLEAN org_xmlvm_iphone_NSXMLParser_shouldReportNamespacePrefixes__(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_shouldReportNamespacePrefixes__]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

JAVA_BOOLEAN org_xmlvm_iphone_NSXMLParser_parse__(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSXMLParser_parse__]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

