#ifndef __ORG_XMLVM_IPHONE_UICONTROLSTATE__
#define __ORG_XMLVM_IPHONE_UICONTROLSTATE__

#include "xmlvm.h"
#include "java_lang_Object.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_lang_Object
#define XMLVM_FORWARD_DECL_java_lang_Object
XMLVM_FORWARD_DECL(java_lang_Object)
#endif
// Class declarations for org.xmlvm.iphone.UIControlState
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIControlState, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIControlState)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControlState;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControlState_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControlState_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControlState_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIControlState
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIControlState \
    __INSTANCE_FIELDS_java_lang_Object; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIControlState \
    } org_xmlvm_iphone_UIControlState

struct org_xmlvm_iphone_UIControlState {
    __TIB_DEFINITION_org_xmlvm_iphone_UIControlState* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIControlState;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControlState
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControlState
typedef struct org_xmlvm_iphone_UIControlState org_xmlvm_iphone_UIControlState;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIControlState 6

void __INIT_org_xmlvm_iphone_UIControlState();
void __INIT_IMPL_org_xmlvm_iphone_UIControlState();
void __DELETE_org_xmlvm_iphone_UIControlState(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIControlState(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIControlState();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIControlState();
JAVA_INT org_xmlvm_iphone_UIControlState_GET_Normal();
void org_xmlvm_iphone_UIControlState_PUT_Normal(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIControlState_GET_Highlighted();
void org_xmlvm_iphone_UIControlState_PUT_Highlighted(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIControlState_GET_Disabled();
void org_xmlvm_iphone_UIControlState_PUT_Disabled(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIControlState_GET_Selected();
void org_xmlvm_iphone_UIControlState_PUT_Selected(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIControlState_GET_ApplicationReserved();
void org_xmlvm_iphone_UIControlState_PUT_ApplicationReserved(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIControlState_GET_Reserved();
void org_xmlvm_iphone_UIControlState_PUT_Reserved(JAVA_INT v);

#endif
