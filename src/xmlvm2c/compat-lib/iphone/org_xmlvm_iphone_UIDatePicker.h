#ifndef __ORG_XMLVM_IPHONE_UIDATEPICKER__
#define __ORG_XMLVM_IPHONE_UIDATEPICKER__

#include "xmlvm.h"
#include "org_xmlvm_iphone_UIControl.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControl
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIControl
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UIControl)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSTimeZone
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSTimeZone
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSTimeZone)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSLocale
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSLocale
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSLocale)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSDate
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSDate
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSDate)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
XMLVM_FORWARD_DECL(org_xmlvm_iphone_CGRect)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSCalendar
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSCalendar
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSCalendar)
#endif
// Class declarations for org.xmlvm.iphone.UIDatePicker
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIDatePicker, 12, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIDatePicker)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIDatePicker;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIDatePicker_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIDatePicker_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIDatePicker_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIDatePicker
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIDatePicker \
    __INSTANCE_FIELDS_org_xmlvm_iphone_UIControl; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIDatePicker \
    } org_xmlvm_iphone_UIDatePicker

struct org_xmlvm_iphone_UIDatePicker {
    __TIB_DEFINITION_org_xmlvm_iphone_UIDatePicker* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIDatePicker;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIDatePicker
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIDatePicker
typedef struct org_xmlvm_iphone_UIDatePicker org_xmlvm_iphone_UIDatePicker;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIDatePicker 12

void __INIT_org_xmlvm_iphone_UIDatePicker();
void __INIT_IMPL_org_xmlvm_iphone_UIDatePicker();
void __DELETE_org_xmlvm_iphone_UIDatePicker(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIDatePicker(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIDatePicker();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIDatePicker();
void org_xmlvm_iphone_UIDatePicker___INIT___(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker___INIT____org_xmlvm_iphone_CGRect(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getCalendar__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setCalendar___org_xmlvm_iphone_NSCalendar(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_DOUBLE org_xmlvm_iphone_UIDatePicker_getCountDownDuration__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setCountDownDuration___double(JAVA_OBJECT me, JAVA_DOUBLE n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getDate__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setDate___org_xmlvm_iphone_NSDate(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_INT org_xmlvm_iphone_UIDatePicker_getDatePickerMode__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setDatePickerMode___int(JAVA_OBJECT me, JAVA_INT n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getLocale__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setLocale___org_xmlvm_iphone_NSLocale(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getMaximumDate__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setMaximumDate___org_xmlvm_iphone_NSDate(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getMinimumDate__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setMinimumDate___org_xmlvm_iphone_NSDate(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_INT org_xmlvm_iphone_UIDatePicker_getMinuteInterval__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setMinuteInterval___int(JAVA_OBJECT me, JAVA_INT n1);
JAVA_OBJECT org_xmlvm_iphone_UIDatePicker_getTimeZone__(JAVA_OBJECT me);
void org_xmlvm_iphone_UIDatePicker_setTimeZone___org_xmlvm_iphone_NSTimeZone(JAVA_OBJECT me, JAVA_OBJECT n1);
void org_xmlvm_iphone_UIDatePicker_setDate___org_xmlvm_iphone_NSDate_boolean(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_BOOLEAN n2);

#endif
