#include "xmlvm.h"
#include "java_lang_Object.h"
#include "java_lang_String.h"

#include "org_xmlvm_iphone_NSUserDefaults.h"

#define XMLVM_CURRENT_CLASS_NAME NSUserDefaults
#define XMLVM_CURRENT_PKG_CLASS_NAME org_xmlvm_iphone_NSUserDefaults

__TIB_DEFINITION_org_xmlvm_iphone_NSUserDefaults __TIB_org_xmlvm_iphone_NSUserDefaults = {
    0, // classInitializationBegan
    0, // classInitialized
    -1, // initializerThreadId
    __INIT_org_xmlvm_iphone_NSUserDefaults, // classInitializer
    "org.xmlvm.iphone.NSUserDefaults", // className
    (__TIB_DEFINITION_TEMPLATE*) &__TIB_org_xmlvm_iphone_NSObject, // extends
    sizeof(org_xmlvm_iphone_NSUserDefaults), // sizeInstance
    XMLVM_TYPE_CLASS};

JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSUserDefaults;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSUserDefaults_1ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSUserDefaults_2ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSUserDefaults_3ARRAY;
//XMLVM_BEGIN_IMPLEMENTATION

#import <Foundation/NSValue.h>
#import <objc/runtime.h>
#include "org_xmlvm_iphone_NSString.h"


void org_xmlvm_iphone_NSUserDefaults_INTERNAL_CONSTRUCTOR(JAVA_OBJECT me, NSObject* wrappedCObj)
{
    org_xmlvm_iphone_NSObject_INTERNAL_CONSTRUCTOR(me, wrappedCObj);
}

static JAVA_OBJECT __WRAPPER_CREATOR(NSObject* obj)
{
    if ([obj class] == [NSUserDefaults class]) {
        JAVA_OBJECT jobj = __NEW_org_xmlvm_iphone_NSUserDefaults();
        org_xmlvm_iphone_NSUserDefaults_INTERNAL_CONSTRUCTOR(jobj, [obj retain]);
        return jobj;
    }
    return JAVA_NULL;
}

//XMLVM_END_IMPLEMENTATION


#include "xmlvm-reflection.h"

static XMLVM_FIELD_REFLECTION_DATA __field_reflection_data[] = {
};

static JAVA_OBJECT* __constructor0_arg_types[] = {
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
    JAVA_OBJECT obj = __NEW_org_xmlvm_iphone_NSUserDefaults();
    java_lang_reflect_Constructor* c = (java_lang_reflect_Constructor*) constructor;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (c->fields.java_lang_reflect_Constructor.slot_) {
    case 0:
        org_xmlvm_iphone_NSUserDefaults___INIT___(obj);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return obj;
}

static JAVA_OBJECT* __method0_arg_types[] = {
};

static JAVA_OBJECT* __method1_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method2_arg_types[] = {
    &__CLASS_java_lang_Object,
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method3_arg_types[] = {
    &__CLASS_int,
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method4_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method5_arg_types[] = {
};

static JAVA_OBJECT* __method6_arg_types[] = {
    &__CLASS_boolean,
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method7_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method8_arg_types[] = {
    &__CLASS_float,
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method9_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method10_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method11_arg_types[] = {
    &__CLASS_java_lang_String,
};

static JAVA_OBJECT* __method12_arg_types[] = {
    &__CLASS_java_lang_String,
};

static XMLVM_METHOD_REFLECTION_DATA __method_reflection_data[] = {
    {"standardUserDefaults",
    &__method0_arg_types[0],
    sizeof(__method0_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"objectForKey",
    &__method1_arg_types[0],
    sizeof(__method1_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"setObject",
    &__method2_arg_types[0],
    sizeof(__method2_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"setInteger",
    &__method3_arg_types[0],
    sizeof(__method3_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"integerForKey",
    &__method4_arg_types[0],
    sizeof(__method4_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"synchronize",
    &__method5_arg_types[0],
    sizeof(__method5_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"setBool",
    &__method6_arg_types[0],
    sizeof(__method6_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"boolForKey",
    &__method7_arg_types[0],
    sizeof(__method7_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"setFloat",
    &__method8_arg_types[0],
    sizeof(__method8_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"floatForKey",
    &__method9_arg_types[0],
    sizeof(__method9_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"dataForKey",
    &__method10_arg_types[0],
    sizeof(__method10_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"stringForKey",
    &__method11_arg_types[0],
    sizeof(__method11_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"remove",
    &__method12_arg_types[0],
    sizeof(__method12_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
};

static JAVA_OBJECT method_dispatcher(JAVA_OBJECT method, JAVA_OBJECT receiver, JAVA_OBJECT arguments)
{
    JAVA_OBJECT result = JAVA_NULL; //TODO need to set result
    java_lang_Object* obj = receiver;
    java_lang_reflect_Method* m = (java_lang_reflect_Method*) method;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (m->fields.java_lang_reflect_Method.slot_) {
    case 0:
        org_xmlvm_iphone_NSUserDefaults_standardUserDefaults__();
        break;
    case 1:
        org_xmlvm_iphone_NSUserDefaults_objectForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 2:
        org_xmlvm_iphone_NSUserDefaults_setObject___java_lang_Object_java_lang_String(receiver, argsArray[0], argsArray[1]);
        break;
    case 3:
        org_xmlvm_iphone_NSUserDefaults_setInteger___int_java_lang_String(receiver, ((java_lang_Integer*) argsArray[0])->fields.java_lang_Integer.value_, argsArray[1]);
        break;
    case 4:
        org_xmlvm_iphone_NSUserDefaults_integerForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 5:
        org_xmlvm_iphone_NSUserDefaults_synchronize__(receiver);
        break;
    case 6:
        org_xmlvm_iphone_NSUserDefaults_setBool___boolean_java_lang_String(receiver, ((java_lang_Boolean*) argsArray[0])->fields.java_lang_Boolean.value_, argsArray[1]);
        break;
    case 7:
        org_xmlvm_iphone_NSUserDefaults_boolForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 8:
        org_xmlvm_iphone_NSUserDefaults_setFloat___float_java_lang_String(receiver, ((java_lang_Float*) argsArray[0])->fields.java_lang_Float.value_, argsArray[1]);
        break;
    case 9:
        org_xmlvm_iphone_NSUserDefaults_floatForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 10:
        org_xmlvm_iphone_NSUserDefaults_dataForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 11:
        org_xmlvm_iphone_NSUserDefaults_stringForKey___java_lang_String(receiver, argsArray[0]);
        break;
    case 12:
        org_xmlvm_iphone_NSUserDefaults_remove___java_lang_String(receiver, argsArray[0]);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return result;
}

void __INIT_org_xmlvm_iphone_NSUserDefaults()
{
    staticInitializerLock(&__TIB_org_xmlvm_iphone_NSUserDefaults);

    // While the static initializer mutex is locked, locally store the value of
    // whether class initialization began or not
    int initBegan = __TIB_org_xmlvm_iphone_NSUserDefaults.classInitializationBegan;

    // Whether or not class initialization had already began, it has begun now
    __TIB_org_xmlvm_iphone_NSUserDefaults.classInitializationBegan = 1;

    staticInitializerUnlock(&__TIB_org_xmlvm_iphone_NSUserDefaults);

    JAVA_LONG curThreadId = (JAVA_LONG)pthread_self();
    if (initBegan) {
        if (__TIB_org_xmlvm_iphone_NSUserDefaults.initializerThreadId != curThreadId) {
            // Busy wait until the other thread finishes initializing this class
            while (!__TIB_org_xmlvm_iphone_NSUserDefaults.classInitialized) {
                // do nothing
            }
        }
    } else {
        __TIB_org_xmlvm_iphone_NSUserDefaults.initializerThreadId = curThreadId;
        __INIT_IMPL_org_xmlvm_iphone_NSUserDefaults();
    }
}

void __INIT_IMPL_org_xmlvm_iphone_NSUserDefaults()
{
    // Initialize base class if necessary
    if (!__TIB_org_xmlvm_iphone_NSObject.classInitialized) __INIT_org_xmlvm_iphone_NSObject();
    __TIB_org_xmlvm_iphone_NSUserDefaults.newInstanceFunc = __NEW_INSTANCE_org_xmlvm_iphone_NSUserDefaults;
    // Copy vtable from base class
    XMLVM_MEMCPY(__TIB_org_xmlvm_iphone_NSUserDefaults.vtable, __TIB_org_xmlvm_iphone_NSObject.vtable, sizeof(__TIB_org_xmlvm_iphone_NSObject.vtable));
    // Initialize vtable for this class
    // Initialize interface information
    __TIB_org_xmlvm_iphone_NSUserDefaults.numImplementedInterfaces = 0;
    __TIB_org_xmlvm_iphone_NSUserDefaults.implementedInterfaces = (__TIB_DEFINITION_TEMPLATE* (*)[1]) XMLVM_MALLOC(sizeof(__TIB_DEFINITION_TEMPLATE*) * 0);

    // Initialize interfaces if necessary and assign tib to implementedInterfaces

    __TIB_org_xmlvm_iphone_NSUserDefaults.declaredFields = &__field_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSUserDefaults.numDeclaredFields = sizeof(__field_reflection_data) / sizeof(XMLVM_FIELD_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_NSUserDefaults.constructorDispatcherFunc = constructor_dispatcher;
    __TIB_org_xmlvm_iphone_NSUserDefaults.declaredConstructors = &__constructor_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSUserDefaults.numDeclaredConstructors = sizeof(__constructor_reflection_data) / sizeof(XMLVM_CONSTRUCTOR_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_NSUserDefaults.methodDispatcherFunc = method_dispatcher;
    __TIB_org_xmlvm_iphone_NSUserDefaults.declaredMethods = &__method_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSUserDefaults.numDeclaredMethods = sizeof(__method_reflection_data) / sizeof(XMLVM_METHOD_REFLECTION_DATA);
    __CLASS_org_xmlvm_iphone_NSUserDefaults = XMLVM_CREATE_CLASS_OBJECT(&__TIB_org_xmlvm_iphone_NSUserDefaults);
    __TIB_org_xmlvm_iphone_NSUserDefaults.clazz = __CLASS_org_xmlvm_iphone_NSUserDefaults;
    __TIB_org_xmlvm_iphone_NSUserDefaults.baseType = JAVA_NULL;
    __CLASS_org_xmlvm_iphone_NSUserDefaults_1ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSUserDefaults);
    __CLASS_org_xmlvm_iphone_NSUserDefaults_2ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSUserDefaults_1ARRAY);
    __CLASS_org_xmlvm_iphone_NSUserDefaults_3ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSUserDefaults_2ARRAY);
    org_xmlvm_iphone_NSUserDefaults___CLINIT_();
    //XMLVM_BEGIN_WRAPPER[__INIT_org_xmlvm_iphone_NSUserDefaults]
    xmlvm_register_wrapper_creator(__WRAPPER_CREATOR);
    //XMLVM_END_WRAPPER

    __TIB_org_xmlvm_iphone_NSUserDefaults.classInitialized = 1;
}

void __DELETE_org_xmlvm_iphone_NSUserDefaults(void* me, void* client_data)
{
    //XMLVM_BEGIN_WRAPPER[__DELETE_org_xmlvm_iphone_NSUserDefaults]
    //XMLVM_END_WRAPPER
}

void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSUserDefaults(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer)
{
    __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSObject(me, 0 || derivedClassWillRegisterFinalizer);
    //XMLVM_BEGIN_WRAPPER[__INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSUserDefaults]
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT __NEW_org_xmlvm_iphone_NSUserDefaults()
{
    if (!__TIB_org_xmlvm_iphone_NSUserDefaults.classInitialized) __INIT_org_xmlvm_iphone_NSUserDefaults();
    org_xmlvm_iphone_NSUserDefaults* me = (org_xmlvm_iphone_NSUserDefaults*) XMLVM_MALLOC(sizeof(org_xmlvm_iphone_NSUserDefaults));
    me->tib = &__TIB_org_xmlvm_iphone_NSUserDefaults;
    __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSUserDefaults(me, 0);
    //XMLVM_BEGIN_WRAPPER[__NEW_org_xmlvm_iphone_NSUserDefaults]
    //XMLVM_END_WRAPPER
    return me;
}

JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_NSUserDefaults()
{
    JAVA_OBJECT me = JAVA_NULL;
    me = __NEW_org_xmlvm_iphone_NSUserDefaults();
    org_xmlvm_iphone_NSUserDefaults___INIT___(me);
    return me;
}

void org_xmlvm_iphone_NSUserDefaults___INIT___(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults___INIT___]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT org_xmlvm_iphone_NSUserDefaults_standardUserDefaults__()
{
    if (!__TIB_org_xmlvm_iphone_NSUserDefaults.classInitialized) __INIT_org_xmlvm_iphone_NSUserDefaults();
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_standardUserDefaults__]
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSUserDefaults* defaults = [NSUserDefaults standardUserDefaults];
    [defaults retain];
    [pool release];
    JAVA_OBJECT obj = xmlvm_get_associated_c_object(defaults);
    [defaults release];
    return obj;
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT org_xmlvm_iphone_NSUserDefaults_objectForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_objectForKey___java_lang_String]
    XMLVM_VAR_THIZ;
    XMLVM_VAR_NSString(key, n1);
    id value = [thiz objectForKey:key];
    [key release];
    if (value == nil) {
        return JAVA_NULL;
    }
    /*
     * There is an interesting problem here because NSUserDefaults is filled by iOS; not
     * the Java application. So, whatever object we have will not have a corresponding
     * Java object at first, but that Java object needs to be created. The problem here
     * is that the retrieved object can be of different type (we can't just create a java.lang.Object).
     * The assumption is that only a finite number of types are possible here so that we can
     * deal with this via an elaborate switch-statement.
     */
    JAVA_OBJECT jvalue;
    NSString* className = [[NSString alloc] initWithCString: class_getName([value class]) encoding: NSASCIIStringEncoding];
    if ([className isEqualToString:@"NSCFBoolean"]) {
        jvalue = __NEW_java_lang_Boolean();
        java_lang_Boolean___INIT____boolean(jvalue, [value boolValue]);
    } else if ([className isEqualToString:@"NSCFNumber"]) {
        jvalue = __NEW_java_lang_Integer();
        java_lang_Integer___INIT____int(jvalue, [value intValue]);
    }
    else {
        XMLVM_NOT_IMPLEMENTED();
    }
    [className release];
    return jvalue;
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_setObject___java_lang_Object_java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_OBJECT n2)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_setObject___java_lang_Object_java_lang_String]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_setInteger___int_java_lang_String(JAVA_OBJECT me, JAVA_INT n1, JAVA_OBJECT n2)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_setInteger___int_java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n2);
    [thiz setInteger:n1 forKey:key];
    [key release];
    //XMLVM_END_WRAPPER
}

JAVA_INT org_xmlvm_iphone_NSUserDefaults_integerForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_integerForKey___java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n1);
    JAVA_INT v = [thiz integerForKey:key];
    [key release];
    return v;
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_synchronize__(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_synchronize__]
    XMLVM_VAR_THIZ;
    [thiz synchronize];
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_setBool___boolean_java_lang_String(JAVA_OBJECT me, JAVA_BOOLEAN n1, JAVA_OBJECT n2)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_setBool___boolean_java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n2);
    [thiz setBool:n1 forKey:key];
    [key release];
    //XMLVM_END_WRAPPER
}

JAVA_BOOLEAN org_xmlvm_iphone_NSUserDefaults_boolForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_boolForKey___java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n1);
    JAVA_BOOLEAN v = [thiz boolForKey:key];
    [key release];
    return v;
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_setFloat___float_java_lang_String(JAVA_OBJECT me, JAVA_FLOAT n1, JAVA_OBJECT n2)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_setFloat___float_java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n2);
    [thiz setFloat:n1 forKey:key];
    [key release];
    //XMLVM_END_WRAPPER
}

JAVA_FLOAT org_xmlvm_iphone_NSUserDefaults_floatForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_floatForKey___java_lang_String]
    XMLVM_VAR_THIZ;
    NSString* key = toNSString(n1);
    JAVA_FLOAT v = [thiz floatForKey:key];
    [key release];
    return v;
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT org_xmlvm_iphone_NSUserDefaults_dataForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_dataForKey___java_lang_String]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT org_xmlvm_iphone_NSUserDefaults_stringForKey___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_stringForKey___java_lang_String]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults_remove___java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults_remove___java_lang_String]
    XMLVM_NOT_IMPLEMENTED();
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSUserDefaults___CLINIT_()
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSUserDefaults___CLINIT___]
    //XMLVM_END_WRAPPER
}

