/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */

#include "java_lang_Exception.h"
#include "java_lang_Object.h"

__CLASS_DEFINITION_java_lang_Exception __CLASS_java_lang_Exception;

void __INIT_java_lang_Exception()
{
    if (!__CLASS_java_lang_Object.classInitialized) __INIT_java_lang_Object();
	__CLASS_java_lang_Exception.className = "java.lang.Exception";
	__CLASS_java_lang_Exception.extends = (__CLASS_DEFINITION_TEMPLATE*) &__CLASS_java_lang_Object;
	__CLASS_java_lang_Exception.numInterfaces = 0;
	__CLASS_java_lang_Exception.numImplementedInterfaces = 0;
	//	__CLASS_java_lang_Exception.interfaces = (__CLASS_DEFINITION_TEMPLATE*) 0;
	__CLASS_java_lang_Exception.classInitialized = 1;
}

void java_lang_Exception___INIT___(JAVA_OBJECT me)
{
}

JAVA_OBJECT __NEW_java_lang_Exception()
{
	java_lang_Exception* me;
    if (!__CLASS_java_lang_Exception.classInitialized) __INIT_java_lang_Exception();
    me = (java_lang_Exception*) XMLVM_MALLOC(sizeof(java_lang_Exception));
    me->__class = &__CLASS_java_lang_Exception;
    return me;
}