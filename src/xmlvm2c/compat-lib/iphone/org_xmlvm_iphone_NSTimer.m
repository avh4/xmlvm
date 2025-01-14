#include "xmlvm.h"
#include "org_xmlvm_iphone_NSTimerDelegate.h"
#include "java_lang_Object.h"

#include "org_xmlvm_iphone_NSTimer.h"

#define XMLVM_CURRENT_CLASS_NAME NSTimer
#define XMLVM_CURRENT_PKG_CLASS_NAME org_xmlvm_iphone_NSTimer

__TIB_DEFINITION_org_xmlvm_iphone_NSTimer __TIB_org_xmlvm_iphone_NSTimer = {
    0, // classInitializationBegan
    0, // classInitialized
    -1, // initializerThreadId
    __INIT_org_xmlvm_iphone_NSTimer, // classInitializer
    "org.xmlvm.iphone.NSTimer", // className
    (__TIB_DEFINITION_TEMPLATE*) &__TIB_org_xmlvm_iphone_NSObject, // extends
    sizeof(org_xmlvm_iphone_NSTimer), // sizeInstance
    XMLVM_TYPE_CLASS};

JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimer;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimer_1ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimer_2ARRAY;
JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimer_3ARRAY;
//XMLVM_BEGIN_IMPLEMENTATION
#import <CoreFoundation/CoreFoundation.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

#import "org_xmlvm_iphone_NSTimerDelegate.h"


@interface NSTimerWrapper: NSObject
{
	org_xmlvm_iphone_NSTimerDelegate* delegate;
	JAVA_OBJECT                       userInfo;
    NSTimer*                          timer;
}

- (id) initWithDelegate:(org_xmlvm_iphone_NSTimerDelegate*) delegate_
                       :(JAVA_OBJECT) userInfo_
                       :(JAVA_DOUBLE) interval
                       :(JAVA_BOOLEAN) repeat;
- (void) invalidate;
@end


@implementation NSTimerWrapper

- (id) initWithDelegate:(org_xmlvm_iphone_NSTimerDelegate*) delegate_
                       :(JAVA_OBJECT) userInfo_
                       :(JAVA_DOUBLE) interval
                       :(JAVA_BOOLEAN) repeat
{
    [super init];
	self->delegate = delegate_;
	self->userInfo = userInfo_;
	self->timer = [NSTimer scheduledTimerWithTimeInterval:interval target:self selector:@selector(timerEvent:) userInfo:NULL repeats:repeat];	
	return self;
}

- (void) timerEvent:(NSTimer*) param
{
    self->timer = nil;
	Func_VOO toCall = *(((java_lang_Object*)self->delegate)->tib->itableBegin)[XMLVM_ITABLE_IDX_org_xmlvm_iphone_NSTimerDelegate_timerEvent___java_lang_Object];
	toCall(self->delegate, self->userInfo);
}

- (void) invalidate
{
    [self->timer invalidate];
}

@end


//XMLVM_END_IMPLEMENTATION


#include "xmlvm-reflection.h"

static XMLVM_FIELD_REFLECTION_DATA __field_reflection_data[] = {
};

static XMLVM_CONSTRUCTOR_REFLECTION_DATA __constructor_reflection_data[] = {
};

static JAVA_OBJECT constructor_dispatcher(JAVA_OBJECT constructor, JAVA_OBJECT arguments)
{
    JAVA_OBJECT obj = __NEW_org_xmlvm_iphone_NSTimer();
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

static JAVA_OBJECT* __method0_arg_types[] = {
    &__CLASS_double,
    &__CLASS_org_xmlvm_iphone_NSTimerDelegate,
    &__CLASS_java_lang_Object,
    &__CLASS_boolean,
};

static JAVA_OBJECT* __method1_arg_types[] = {
};

static XMLVM_METHOD_REFLECTION_DATA __method_reflection_data[] = {
    {"scheduledTimerWithTimeInterval",
    &__method0_arg_types[0],
    sizeof(__method0_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
    {"invalidate",
    &__method1_arg_types[0],
    sizeof(__method1_arg_types) / sizeof(JAVA_OBJECT*),
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
        org_xmlvm_iphone_NSTimer_scheduledTimerWithTimeInterval___double_org_xmlvm_iphone_NSTimerDelegate_java_lang_Object_boolean(((java_lang_Double*) argsArray[0])->fields.java_lang_Double.value_, argsArray[1], argsArray[2], ((java_lang_Boolean*) argsArray[3])->fields.java_lang_Boolean.value_);
        break;
    case 1:
        org_xmlvm_iphone_NSTimer_invalidate__(receiver);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return result;
}

void __INIT_org_xmlvm_iphone_NSTimer()
{
    staticInitializerLock(&__TIB_org_xmlvm_iphone_NSTimer);

    // While the static initializer mutex is locked, locally store the value of
    // whether class initialization began or not
    int initBegan = __TIB_org_xmlvm_iphone_NSTimer.classInitializationBegan;

    // Whether or not class initialization had already began, it has begun now
    __TIB_org_xmlvm_iphone_NSTimer.classInitializationBegan = 1;

    staticInitializerUnlock(&__TIB_org_xmlvm_iphone_NSTimer);

    JAVA_LONG curThreadId = (JAVA_LONG)pthread_self();
    if (initBegan) {
        if (__TIB_org_xmlvm_iphone_NSTimer.initializerThreadId != curThreadId) {
            // Busy wait until the other thread finishes initializing this class
            while (!__TIB_org_xmlvm_iphone_NSTimer.classInitialized) {
                // do nothing
            }
        }
    } else {
        __TIB_org_xmlvm_iphone_NSTimer.initializerThreadId = curThreadId;
        __INIT_IMPL_org_xmlvm_iphone_NSTimer();
    }
}

void __INIT_IMPL_org_xmlvm_iphone_NSTimer()
{
    // Initialize base class if necessary
    if (!__TIB_org_xmlvm_iphone_NSObject.classInitialized) __INIT_org_xmlvm_iphone_NSObject();
    __TIB_org_xmlvm_iphone_NSTimer.newInstanceFunc = __NEW_INSTANCE_org_xmlvm_iphone_NSTimer;
    // Copy vtable from base class
    XMLVM_MEMCPY(__TIB_org_xmlvm_iphone_NSTimer.vtable, __TIB_org_xmlvm_iphone_NSObject.vtable, sizeof(__TIB_org_xmlvm_iphone_NSObject.vtable));
    // Initialize vtable for this class
    // Initialize interface information
    __TIB_org_xmlvm_iphone_NSTimer.numImplementedInterfaces = 0;
    __TIB_org_xmlvm_iphone_NSTimer.implementedInterfaces = (__TIB_DEFINITION_TEMPLATE* (*)[1]) XMLVM_MALLOC(sizeof(__TIB_DEFINITION_TEMPLATE*) * 0);

    // Initialize interfaces if necessary and assign tib to implementedInterfaces

    __TIB_org_xmlvm_iphone_NSTimer.declaredFields = &__field_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSTimer.numDeclaredFields = sizeof(__field_reflection_data) / sizeof(XMLVM_FIELD_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_NSTimer.constructorDispatcherFunc = constructor_dispatcher;
    __TIB_org_xmlvm_iphone_NSTimer.declaredConstructors = &__constructor_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSTimer.numDeclaredConstructors = sizeof(__constructor_reflection_data) / sizeof(XMLVM_CONSTRUCTOR_REFLECTION_DATA);
    __TIB_org_xmlvm_iphone_NSTimer.methodDispatcherFunc = method_dispatcher;
    __TIB_org_xmlvm_iphone_NSTimer.declaredMethods = &__method_reflection_data[0];
    __TIB_org_xmlvm_iphone_NSTimer.numDeclaredMethods = sizeof(__method_reflection_data) / sizeof(XMLVM_METHOD_REFLECTION_DATA);
    __CLASS_org_xmlvm_iphone_NSTimer = XMLVM_CREATE_CLASS_OBJECT(&__TIB_org_xmlvm_iphone_NSTimer);
    __TIB_org_xmlvm_iphone_NSTimer.clazz = __CLASS_org_xmlvm_iphone_NSTimer;
    __TIB_org_xmlvm_iphone_NSTimer.baseType = JAVA_NULL;
    __CLASS_org_xmlvm_iphone_NSTimer_1ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSTimer);
    __CLASS_org_xmlvm_iphone_NSTimer_2ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSTimer_1ARRAY);
    __CLASS_org_xmlvm_iphone_NSTimer_3ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_org_xmlvm_iphone_NSTimer_2ARRAY);
    //XMLVM_BEGIN_WRAPPER[__INIT_org_xmlvm_iphone_NSTimer]
    //XMLVM_END_WRAPPER

    __TIB_org_xmlvm_iphone_NSTimer.classInitialized = 1;
}

void __DELETE_org_xmlvm_iphone_NSTimer(void* me, void* client_data)
{
    //XMLVM_BEGIN_WRAPPER[__DELETE_org_xmlvm_iphone_NSTimer]
    __DELETE_org_xmlvm_iphone_NSObject(me, client_data);
    //XMLVM_END_WRAPPER
}

void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSTimer(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer)
{
    __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSObject(me, 0 || derivedClassWillRegisterFinalizer);
    //XMLVM_BEGIN_WRAPPER[__INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSTimer]
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT __NEW_org_xmlvm_iphone_NSTimer()
{
    if (!__TIB_org_xmlvm_iphone_NSTimer.classInitialized) __INIT_org_xmlvm_iphone_NSTimer();
    org_xmlvm_iphone_NSTimer* me = (org_xmlvm_iphone_NSTimer*) XMLVM_MALLOC(sizeof(org_xmlvm_iphone_NSTimer));
    me->tib = &__TIB_org_xmlvm_iphone_NSTimer;
    __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSTimer(me, 0);
    //XMLVM_BEGIN_WRAPPER[__NEW_org_xmlvm_iphone_NSTimer]
    //XMLVM_END_WRAPPER
    return me;
}

JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_NSTimer()
{
    JAVA_OBJECT me = JAVA_NULL;
    return me;
}

JAVA_OBJECT org_xmlvm_iphone_NSTimer_scheduledTimerWithTimeInterval___double_org_xmlvm_iphone_NSTimerDelegate_java_lang_Object_boolean(JAVA_DOUBLE n1, JAVA_OBJECT n2, JAVA_OBJECT n3, JAVA_BOOLEAN n4)
{
    if (!__TIB_org_xmlvm_iphone_NSTimer.classInitialized) __INIT_org_xmlvm_iphone_NSTimer();
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSTimer_scheduledTimerWithTimeInterval___double_org_xmlvm_iphone_NSTimerDelegate_java_lang_Object_boolean]
	org_xmlvm_iphone_NSTimer* timer = __NEW_org_xmlvm_iphone_NSTimer();
	// n1 = timerInterval
	// n2 = NSTimerDelegate target
	// n3 = userInfo
	// n4 = repeats 
	NSTimerWrapper* nsTimer = [[NSTimerWrapper alloc] initWithDelegate:n2
                                                                      :n3
                                                                      :n1
                                                                      :n4];
    org_xmlvm_iphone_NSObject_INTERNAL_CONSTRUCTOR(timer, nsTimer);
    //TODO need to save a reference to n3 as well to avoid GC?
    timer->fields.org_xmlvm_iphone_NSTimer.delegate = n2;
	return timer;
    //XMLVM_END_WRAPPER
}

void org_xmlvm_iphone_NSTimer_invalidate__(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[org_xmlvm_iphone_NSTimer_invalidate__]
    org_xmlvm_iphone_NSTimer* thiz = me;
    [((NSTimerWrapper*) (thiz->fields.org_xmlvm_iphone_NSObject.wrappedObjCObj)) invalidate];
    //XMLVM_END_WRAPPER
}

