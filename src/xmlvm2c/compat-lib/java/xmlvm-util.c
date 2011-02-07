/*
 * Copyright (c) 2002-2011 by XMLVM.org
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

#include "xmlvm-util.h"
#include "java_util_ArrayList.h"
#include "java_util_HashSet.h"
#include "java_util_HashMap.h"


JAVA_OBJECT XMLVMUtil_NEW_ArrayList()
{
    JAVA_OBJECT obj = __NEW_java_util_ArrayList();
    java_util_ArrayList___INIT___(obj);
    return obj;
}

JAVA_BOOLEAN XMLVMUtil_ArrayList_add(JAVA_OBJECT me, JAVA_OBJECT obj)
{
#ifdef XMLVM_VTABLE_IDX_java_util_ArrayList_add___java_lang_Object
    return (*(JAVA_BOOLEAN (*)(JAVA_OBJECT, JAVA_OBJECT)) ((java_util_ArrayList*) me)->
            tib->vtable[XMLVM_VTABLE_IDX_java_util_ArrayList_add___java_lang_Object])(me, obj);
#else
    return java_util_ArrayList_add___java_lang_Object(me, obj);
#endif
}

JAVA_BOOLEAN XMLVMUtil_ArrayList_remove(JAVA_OBJECT me, JAVA_OBJECT obj)
{
#ifdef XMLVM_VTABLE_IDX_java_util_ArrayList_remove___java_lang_Object
    return (*(JAVA_BOOLEAN (*)(JAVA_OBJECT, JAVA_OBJECT)) ((java_util_ArrayList*) me)->
            tib->vtable[XMLVM_VTABLE_IDX_java_util_ArrayList_remove___java_lang_Object])(me, obj);
#else
    return java_util_ArrayList_remove___java_lang_Object(me, obj);
#endif
}

JAVA_OBJECT XMLVMUtil_NEW_HashSet()
{
    JAVA_OBJECT obj = __NEW_java_util_HashSet();
    java_util_HashSet___INIT___(obj);
    return obj;
}

JAVA_BOOLEAN XMLVMUtil_HashSet_add(JAVA_OBJECT me, JAVA_OBJECT obj)
{
#ifdef XMLVM_VTABLE_IDX_java_util_HashSet_add___java_lang_Object
    return (*(JAVA_BOOLEAN (*)(JAVA_OBJECT, JAVA_OBJECT)) ((java_util_HashSet*) me)->
            tib->vtable[XMLVM_VTABLE_IDX_java_util_HashSet_add___java_lang_Object])(me, obj);
#else
    return java_util_HashSet_add___java_lang_Object(me, obj);
#endif
}

JAVA_OBJECT XMLVMUtil_NEW_HashMap()
{
    JAVA_OBJECT obj = __NEW_java_util_HashMap();
    java_util_HashMap___INIT___(obj);
    return obj;
}

JAVA_OBJECT XMLVMUtil_HashMap_put(JAVA_OBJECT me, JAVA_OBJECT key, JAVA_OBJECT value)
{
#ifdef XMLVM_VTABLE_IDX_java_util_HashMap_put___java_lang_Object_java_lang_Object
    return (*(JAVA_OBJECT (*)(JAVA_OBJECT, JAVA_OBJECT, JAVA_OBJECT)) ((java_util_HashMap*) me)->
            tib->vtable[XMLVM_VTABLE_IDX_java_util_HashMap_put___java_lang_Object_java_lang_Object])(me, key, value);
#else
    return java_util_HashMap_put___java_lang_Object_java_lang_Object(me, key, value);
#endif
}

JAVA_OBJECT XMLVMUtil_HashMap_get(JAVA_OBJECT me, JAVA_OBJECT key)
{
#ifdef XMLVM_VTABLE_IDX_java_util_HashMap_get___java_lang_Object
    return (*(JAVA_OBJECT (*)(JAVA_OBJECT, JAVA_OBJECT)) ((java_util_HashMap*) me)->
            tib->vtable[XMLVM_VTABLE_IDX_java_util_HashMap_get___java_lang_Object])(me, key);
#else
    return java_util_HashMap_get___java_lang_Object(me, key);
#endif
}
