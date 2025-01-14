#include "xmlvm.h"

#include "org_xmlvm_iphone_CGPathDrawingMode.h"

#define XMLVM_CURRENT_CLASS_NAME CGPathDrawingMode
#define XMLVM_CURRENT_PKG_CLASS_NAME org_xmlvm_iphone_CGPathDrawingMode

__TIB_DEFINITION_org_xmlvm_iphone_CGPathDrawingMode __TIB_org_xmlvm_iphone_CGPathDrawingMode = {
    0, // classInitializationBegan
    0, // classInitialized
    -1, // initializerThreadId
    __INIT_org_xmlvm_iphone_CGPathDrawingMode, // classInitializer
    "org.xmlvm.iphone.CGPathDrawingMode", // className
    (__TIB_DEFINITION_TEMPLATE*) &__TIB_java_lang_Object, // extends
    sizeof(org_xmlvm_iphone_CGPathDrawingMode), // sizeInstance
    XMLVM_TYPE_CLASS};

JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGPathDrawingMode;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGPathDrawingMode_1ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGPathDrawingMode_2ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGPathDrawingMode_3ARRAY;
//XMLVM_BEGIN_IMPLEMENTATION
//XMLVM_END_IMPLEMENTATION

static JAVA_INT _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFill;
static JAVA_INT _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFill;
static JAVA_INT _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathStroke;
static JAVA_INT _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFillStroke;
static JAVA_INT _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFillStroke;

#include "xmlvm-reflection.h"

static XMLVM_FIELD_REFLECTION_DATA __field_reflection_data[] = {
    {"kCGPathFill",
    &__CLASS_int,
    0 | java_lang_reflect_Modifier_PUBLIC | java_lang_reflect_Modifier_STATIC,
    0,
    &_STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFill,
    "",
    JAVA_NULL},
    {"kCGPathEOFill",
    &__CLASS_int,
    0 | java_lang_reflect_Modifier_PUBLIC | java_lang_reflect_Modifier_STATIC,
    0,
    &_STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFill,
    "",
    JAVA_NULL},
    {"kCGPathStroke",
    &__CLASS_int,
    0 | java_lang_reflect_Modifier_PUBLIC | java_lang_reflect_Modifier_STATIC,
    0,
    &_STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathStroke,
    "",
    JAVA_NULL},
    {"kCGPathFillStroke",
    &__CLASS_int,
    0 | java_lang_reflect_Modifier_PUBLIC | java_lang_reflect_Modifier_STATIC,
    0,
    &_STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFillStroke,
    "",
    JAVA_NULL},
    {"kCGPathEOFillStroke",
    &__CLASS_int,
    0 | java_lang_reflect_Modifier_PUBLIC | java_lang_reflect_Modifier_STATIC,
    0,
    &_STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFillStroke,
    "",
    JAVA_NULL},
};

static XMLVM_CONSTRUCTOR_REFLECTION_DATA __constructor_reflection_data[] = {
};

static JAVA_OBJECT constructor_dispatcher(JAVA_OBJECT constructor, JAVA_OBJECT arguments)
{
    JAVA_OBJECT obj = __NEW_org_xmlvm_iphone_CGPathDrawingMode();
    java_lang_reflect_Constructor* c = (java_lang_reflect_Constructor*) constructor;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (c->fields.java_lang_reflect_Constructor.slot_) {
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return obj;
}

static XMLVM_METHOD_REFLECTION_DATA __method_reflection_data[] = {
};

static JAVA_OBJECT method_dispatcher(JAVA_OBJECT method, JAVA_OBJECT receiver, JAVA_OBJECT arguments)
{
    JAVA_OBJECT result = JAVA_NULL; //TODO need to set result
    java_lang_Object* obj = receiver;
    java_lang_reflect_Method* m = (java_lang_reflect_Method*) method;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (m->fields.java_lang_reflect_Method.slot_) {
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return result;
}

void __INIT_org_xmlvm_iphone_CGPathDrawingMode()
{
    staticInitializerLock(&__TIB_org_xmlvm_iphone_CGPathDrawingMode);

    // While the static initializer mutex is locked, locally store the value of
    // whether class initialization began or not
    int initBegan = __TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitializationBegan;

    // Whether or not class initialization had already began, it has begun now
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitializationBegan = 1;

    staticInitializerUnlock(&__TIB_org_xmlvm_iphone_CGPathDrawingMode);

    JAVA_LONG curThreadId = (JAVA_LONG)pthread_self();
    if (initBegan) {
        if (__TIB_org_xmlvm_iphone_CGPathDrawingMode.initializerThreadId != curThreadId) {
            // Busy wait until the other thread finishes initializing this class
            while (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) {
                // do nothing
            }
        }
    } else {
        __TIB_org_xmlvm_iphone_CGPathDrawingMode.initializerThreadId = curThreadId;
        __INIT_IMPL_org_xmlvm_iphone_CGPathDrawingMode();
    }
}

void __INIT_IMPL_org_xmlvm_iphone_CGPathDrawingMode()
{
    // Initialize base class if necessary
    if (!__TIB_java_lang_Object.classInitialized) __INIT_java_lang_Object();
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.newInstanceFunc = __NEW_INSTANCE_org_xmlvm_iphone_CGPathDrawingMode;
    // Copy vtable from base class
    XMLVM_MEMCPY(__TIB_org_xmlvm_iphone_CGPathDrawingMode.vtable, __TIB_java_lang_Object.vtable, sizeof(__TIB_java_lang_Object.vtable));
    // Initialize vtable for this class
    // Initialize interface information
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.numImplementedInterfaces = 0;
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.implementedInterfaces = (__TIB_DEFINITION_TEMPLATE* (*)[1]) XMLVM_MALLOC(sizeof(__TIB_DEFINITION_TEMPLATE*) * 0);

    // Initialize interfaces if necessary and assign tib to implementedInterfaces
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFill = 0;
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFill = 1;
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathStroke = 2;
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFillStroke = 3;
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFillStroke = 4;

    __TIB_org_xmlvm_iphone_CGPathDrawingMode.declaredFields = &__field_reflection_data[0];
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.numDeclaredFields = sizeof(__field_reflection_data) / sizeof(XMLVM_FIELD_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.constructorDispatcherFunc = constructor_dispatcher;
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.declaredConstructors = &__constructor_reflection_data[0];
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.numDeclaredConstructors = sizeof(__constructor_reflection_data) / sizeof(XMLVM_CONSTRUCTOR_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.methodDispatcherFunc = method_dispatcher;
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.declaredMethods = &__method_reflection_data[0];
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.numDeclaredMethods = sizeof(__method_reflection_data) / sizeof(XMLVM_METHOD_REFLECTION_DATA);
    __CLASS_org_xmlvm_iphone_CGPathDrawingMode = XMLVM_CREATE_CLASS_OBJECT(&__TIB_org_xmlvm_iphone_CGPathDrawingMode);
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.clazz = __CLASS_org_xmlvm_iphone_CGPathDrawingMode;
    __TIB_org_xmlvm_iphone_CGPathDrawingMode.baseType = JAVA_NULL;
    __CLASS_org_xmlvm_iphone_CGPathDrawingMode_1ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_CGPathDrawingMode);
    __CLASS_org_xmlvm_iphone_CGPathDrawingMode_2ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_CGPathDrawingMode_1ARRAY);
    __CLASS_org_xmlvm_iphone_CGPathDrawingMode_3ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_CGPathDrawingMode_2ARRAY);
    //XMLVM_BEGIN_WRAPPER[__INIT_org_xmlvm_iphone_CGPathDrawingMode]
    //XMLVM_END_WRAPPER

    __TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized = 1;
}

void __DELETE_org_xmlvm_iphone_CGPathDrawingMode(void* me, void* client_data)
{
    //XMLVM_BEGIN_WRAPPER[__DELETE_org_xmlvm_iphone_CGPathDrawingMode]
    //XMLVM_END_WRAPPER
}

void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_CGPathDrawingMode(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer)
{
    __INIT_INSTANCE_MEMBERS_java_lang_Object(me, 0 || derivedClassWillRegisterFinalizer);
    //XMLVM_BEGIN_WRAPPER[__INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_CGPathDrawingMode]
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT __NEW_org_xmlvm_iphone_CGPathDrawingMode()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    org_xmlvm_iphone_CGPathDrawingMode* me = (org_xmlvm_iphone_CGPathDrawingMode*) XMLVM_MALLOC(sizeof(org_xmlvm_iphone_CGPathDrawingMode));
    me->tib = &__TIB_org_xmlvm_iphone_CGPathDrawingMode;
    __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_CGPathDrawingMode(me, 0);
    //XMLVM_BEGIN_WRAPPER[__NEW_org_xmlvm_iphone_CGPathDrawingMode]
    //XMLVM_END_WRAPPER
    return me;
}

JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_CGPathDrawingMode()
{
    JAVA_OBJECT me = JAVA_NULL;
    return me;
}

JAVA_INT org_xmlvm_iphone_CGPathDrawingMode_GET_kCGPathFill()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    return _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFill;
}

void org_xmlvm_iphone_CGPathDrawingMode_PUT_kCGPathFill(JAVA_INT v)
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFill = v;
}

JAVA_INT org_xmlvm_iphone_CGPathDrawingMode_GET_kCGPathEOFill()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    return _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFill;
}

void org_xmlvm_iphone_CGPathDrawingMode_PUT_kCGPathEOFill(JAVA_INT v)
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFill = v;
}

JAVA_INT org_xmlvm_iphone_CGPathDrawingMode_GET_kCGPathStroke()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    return _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathStroke;
}

void org_xmlvm_iphone_CGPathDrawingMode_PUT_kCGPathStroke(JAVA_INT v)
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathStroke = v;
}

JAVA_INT org_xmlvm_iphone_CGPathDrawingMode_GET_kCGPathFillStroke()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    return _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFillStroke;
}

void org_xmlvm_iphone_CGPathDrawingMode_PUT_kCGPathFillStroke(JAVA_INT v)
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathFillStroke = v;
}

JAVA_INT org_xmlvm_iphone_CGPathDrawingMode_GET_kCGPathEOFillStroke()
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    return _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFillStroke;
}

void org_xmlvm_iphone_CGPathDrawingMode_PUT_kCGPathEOFillStroke(JAVA_INT v)
{
    if (!__TIB_org_xmlvm_iphone_CGPathDrawingMode.classInitialized) __INIT_org_xmlvm_iphone_CGPathDrawingMode();
    _STATIC_org_xmlvm_iphone_CGPathDrawingMode_kCGPathEOFillStroke = v;
}

