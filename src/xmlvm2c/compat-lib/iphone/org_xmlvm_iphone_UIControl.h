#ifndef __ORG_XMLVM_IPHONE_UICONTROL__
#define __ORG_XMLVM_IPHONE_UICONTROL__

#include "xmlvm.h"
#include "org_xmlvm_iphone_UIView.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIEvent
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIEvent
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UIEvent)
#endif
#ifndef XMLVM_FORWARD_DECL_java_util_Set
#define XMLVM_FORWARD_DECL_java_util_Set
XMLVM_FORWARD_DECL(java_util_Set)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
XMLVM_FORWARD_DECL(org_xmlvm_iphone_CGRect)
#endif
#ifndef XMLVM_FORWARD_DECL_java_util_Map
#define XMLVM_FORWARD_DECL_java_util_Map
XMLVM_FORWARD_DECL(java_util_Map)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControlDelegate
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControlDelegate
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UIControlDelegate)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIView
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIView
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UIView)
#endif
// Class declarations for org.xmlvm.iphone.UIControl
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIControl, 12, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIControl)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControl;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControl_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControl_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIControl_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIControl \
    NSObject*   delegateWrapper; \
    JAVA_OBJECT jdelegateWrapper;

void org_xmlvm_iphone_UIControl_INTERNAL_CONSTRUCTOR(JAVA_OBJECT me, NSObject* wrappedObjCObj);
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIControl \
    __INSTANCE_FIELDS_org_xmlvm_iphone_UIView; \
    struct { \
        JAVA_OBJECT delegates_; \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIControl \
    } org_xmlvm_iphone_UIControl

struct org_xmlvm_iphone_UIControl {
    __TIB_DEFINITION_org_xmlvm_iphone_UIControl* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIControl;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControl
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControl
typedef struct org_xmlvm_iphone_UIControl org_xmlvm_iphone_UIControl;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIControl 12
#define XMLVM_VTABLE_IDX_org_xmlvm_iphone_UIControl_touchesEnded___java_util_Set_org_xmlvm_iphone_UIEvent 7

void __INIT_org_xmlvm_iphone_UIControl();
void __INIT_IMPL_org_xmlvm_iphone_UIControl();
void __DELETE_org_xmlvm_iphone_UIControl(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIControl(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIControl();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIControl();
void org_xmlvm_iphone_UIControl___INIT___(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl___INIT____org_xmlvm_iphone_CGRect(JAVA_OBJECT me, JAVA_OBJECT n1);
void org_xmlvm_iphone_UIControl_addTarget___org_xmlvm_iphone_UIControlDelegate_int(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_INT n2);
JAVA_OBJECT org_xmlvm_iphone_UIControl_getAllTargets__(JAVA_OBJECT me);
// Vtable index: 7
void org_xmlvm_iphone_UIControl_touchesEnded___java_util_Set_org_xmlvm_iphone_UIEvent(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_OBJECT n2);
JAVA_BOOLEAN org_xmlvm_iphone_UIControl_isEnabled__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl_setEnabled___boolean(JAVA_OBJECT me, JAVA_BOOLEAN n1);
JAVA_BOOLEAN org_xmlvm_iphone_UIControl_isSelected__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl_setSelected___boolean(JAVA_OBJECT me, JAVA_BOOLEAN n1);
JAVA_BOOLEAN org_xmlvm_iphone_UIControl_isHighlighted__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl_setHighlighted___boolean(JAVA_OBJECT me, JAVA_BOOLEAN n1);
JAVA_INT org_xmlvm_iphone_UIControl_getState__(JAVA_OBJECT me);
JAVA_INT org_xmlvm_iphone_UIControl_getContentHorizontalAlignment__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl_setContentHorizontalAlignment___int(JAVA_OBJECT me, JAVA_INT n1);
JAVA_INT org_xmlvm_iphone_UIControl_getContentVerticalAlignment__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIControl_setContentVerticalAlignment___int(JAVA_OBJECT me, JAVA_INT n1);

#endif
