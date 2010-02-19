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

 
#import "java_io_DataInputStream.h"

// java.io.DataInputStream
//----------------------------------------------------------------------------
@implementation java_io_DataInputStream

- (void) __init_java_io_DataInputStream___java_io_InputStream: (java_io_InputStream*) stream
{
	target = [stream retain];
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (int) read__
{
	return [target read__];
}

- (void) close__
{
	[target close__];
}

- (float) readFloat__
{
	// TODO: Implement this
	NSLog(@">>>TODO: readFloat__ has to be implemented ...");
	return 0.0f;
}

- (double) readDouble__
{
	// TODO: Implement this
	NSLog(@">>>TODO: readDouble__ has to be implemented ...");
	return 0.0;
}

@end

