#ifndef __ORG_XMLVM_IPHONE_UIVIEWANIMATIONTRANSITION__
#define __ORG_XMLVM_IPHONE_UIVIEWANIMATIONTRANSITION__

#include "xmlvm.h"
#include "java_lang_Object.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_lang_Object
#define XMLVM_FORWARD_DECL_java_lang_Object
XMLVM_FORWARD_DECL(java_lang_Object)
#endif
// Class declarations for org.xmlvm.iphone.UIViewAnimationTransition
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIViewAnimationTransition, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIViewAnimationTransition)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIViewAnimationTransition;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIViewAnimationTransition_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIViewAnimationTransition_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIViewAnimationTransition_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIViewAnimationTransition
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIViewAnimationTransition \
    __INSTANCE_FIELDS_java_lang_Object; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIViewAnimationTransition \
    } org_xmlvm_iphone_UIViewAnimationTransition

struct org_xmlvm_iphone_UIViewAnimationTransition {
    __TIB_DEFINITION_org_xmlvm_iphone_UIViewAnimationTransition* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIViewAnimationTransition;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIViewAnimationTransition
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIViewAnimationTransition
typedef struct org_xmlvm_iphone_UIViewAnimationTransition org_xmlvm_iphone_UIViewAnimationTransition;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIViewAnimationTransition 6

void __INIT_org_xmlvm_iphone_UIViewAnimationTransition();
void __INIT_IMPL_org_xmlvm_iphone_UIViewAnimationTransition();
void __DELETE_org_xmlvm_iphone_UIViewAnimationTransition(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIViewAnimationTransition(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIViewAnimationTransition();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIViewAnimationTransition();
JAVA_INT org_xmlvm_iphone_UIViewAnimationTransition_GET_None();
void org_xmlvm_iphone_UIViewAnimationTransition_PUT_None(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIViewAnimationTransition_GET_FlipFromLeft();
void org_xmlvm_iphone_UIViewAnimationTransition_PUT_FlipFromLeft(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIViewAnimationTransition_GET_FlipFromRight();
void org_xmlvm_iphone_UIViewAnimationTransition_PUT_FlipFromRight(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIViewAnimationTransition_GET_CurlUp();
void org_xmlvm_iphone_UIViewAnimationTransition_PUT_CurlUp(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIViewAnimationTransition_GET_CurlDown();
void org_xmlvm_iphone_UIViewAnimationTransition_PUT_CurlDown(JAVA_INT v);

#endif
