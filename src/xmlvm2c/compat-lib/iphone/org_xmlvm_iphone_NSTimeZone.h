#ifndef __ORG_XMLVM_IPHONE_NSTIMEZONE__
#define __ORG_XMLVM_IPHONE_NSTIMEZONE__

#include "xmlvm.h"
#include "org_xmlvm_iphone_NSObject.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSObject
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSObject
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSObject)
#endif
#ifndef XMLVM_FORWARD_DECL_java_lang_String
#define XMLVM_FORWARD_DECL_java_lang_String
XMLVM_FORWARD_DECL(java_lang_String)
#endif
// Class declarations for org.xmlvm.iphone.NSTimeZone
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_NSTimeZone, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_NSTimeZone)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimeZone;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimeZone_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimeZone_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_NSTimeZone_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_NSTimeZone
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_NSTimeZone \
    __INSTANCE_FIELDS_org_xmlvm_iphone_NSObject; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_NSTimeZone \
    } org_xmlvm_iphone_NSTimeZone

struct org_xmlvm_iphone_NSTimeZone {
    __TIB_DEFINITION_org_xmlvm_iphone_NSTimeZone* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_NSTimeZone;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSTimeZone
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSTimeZone
typedef struct org_xmlvm_iphone_NSTimeZone org_xmlvm_iphone_NSTimeZone;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_NSTimeZone 6
#define XMLVM_VTABLE_IDX_org_xmlvm_iphone_NSTimeZone_toString__ 5

void __INIT_org_xmlvm_iphone_NSTimeZone();
void __INIT_IMPL_org_xmlvm_iphone_NSTimeZone();
void __DELETE_org_xmlvm_iphone_NSTimeZone(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_NSTimeZone(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_NSTimeZone();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_NSTimeZone();
void org_xmlvm_iphone_NSTimeZone___INIT____java_lang_String(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_NSTimeZone_name__(JAVA_OBJECT me);
// Vtable index: 5
JAVA_OBJECT org_xmlvm_iphone_NSTimeZone_toString__(JAVA_OBJECT me);

#endif
