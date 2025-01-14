#ifndef __ORG_XMLVM_IPHONE_UIMODALTRANSITIONSTYLE__
#define __ORG_XMLVM_IPHONE_UIMODALTRANSITIONSTYLE__

#include "xmlvm.h"
#include "java_lang_Object.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_lang_Object
#define XMLVM_FORWARD_DECL_java_lang_Object
XMLVM_FORWARD_DECL(java_lang_Object)
#endif
// Class declarations for org.xmlvm.iphone.UIModalTransitionStyle
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIModalTransitionStyle, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIModalTransitionStyle)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIModalTransitionStyle;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIModalTransitionStyle_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIModalTransitionStyle_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIModalTransitionStyle_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIModalTransitionStyle
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIModalTransitionStyle \
    __INSTANCE_FIELDS_java_lang_Object; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIModalTransitionStyle \
    } org_xmlvm_iphone_UIModalTransitionStyle

struct org_xmlvm_iphone_UIModalTransitionStyle {
    __TIB_DEFINITION_org_xmlvm_iphone_UIModalTransitionStyle* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIModalTransitionStyle;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIModalTransitionStyle
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIModalTransitionStyle
typedef struct org_xmlvm_iphone_UIModalTransitionStyle org_xmlvm_iphone_UIModalTransitionStyle;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIModalTransitionStyle 6

void __INIT_org_xmlvm_iphone_UIModalTransitionStyle();
void __INIT_IMPL_org_xmlvm_iphone_UIModalTransitionStyle();
void __DELETE_org_xmlvm_iphone_UIModalTransitionStyle(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIModalTransitionStyle(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIModalTransitionStyle();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIModalTransitionStyle();
JAVA_INT org_xmlvm_iphone_UIModalTransitionStyle_GET_CoverVertical();
void org_xmlvm_iphone_UIModalTransitionStyle_PUT_CoverVertical(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIModalTransitionStyle_GET_FlipHorizontal();
void org_xmlvm_iphone_UIModalTransitionStyle_PUT_FlipHorizontal(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIModalTransitionStyle_GET_CrossDissolve();
void org_xmlvm_iphone_UIModalTransitionStyle_PUT_CrossDissolve(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIModalTransitionStyle_GET_PartialCurl();
void org_xmlvm_iphone_UIModalTransitionStyle_PUT_PartialCurl(JAVA_INT v);

#endif
