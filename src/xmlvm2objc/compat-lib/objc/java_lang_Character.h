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

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"


// java.lang.Character
//----------------------------------------------------------------------------
@interface java_lang_Character : java_lang_Object {
	char c;
}

- (void) __init_java_lang_Character___char :(char) c;
- (char) charValue__;
+ (void) initialize;
+ (java_lang_Class*) _GET_TYPE;
+ (java_lang_String*) toString___char: (char) c;
+ (java_lang_Character*) valueOf___char: (char) c;

@end
