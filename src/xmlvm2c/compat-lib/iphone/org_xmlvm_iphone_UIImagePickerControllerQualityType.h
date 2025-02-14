#ifndef __ORG_XMLVM_IPHONE_UIIMAGEPICKERCONTROLLERQUALITYTYPE__
#define __ORG_XMLVM_IPHONE_UIIMAGEPICKERCONTROLLERQUALITYTYPE__

#include "xmlvm.h"
#include "java_lang_Object.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_lang_Object
#define XMLVM_FORWARD_DECL_java_lang_Object
XMLVM_FORWARD_DECL(java_lang_Object)
#endif
// Class declarations for org.xmlvm.iphone.UIImagePickerControllerQualityType
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIImagePickerControllerQualityType, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIImagePickerControllerQualityType)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIImagePickerControllerQualityType;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIImagePickerControllerQualityType_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIImagePickerControllerQualityType_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIImagePickerControllerQualityType_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIImagePickerControllerQualityType
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIImagePickerControllerQualityType \
    __INSTANCE_FIELDS_java_lang_Object; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIImagePickerControllerQualityType \
    } org_xmlvm_iphone_UIImagePickerControllerQualityType

struct org_xmlvm_iphone_UIImagePickerControllerQualityType {
    __TIB_DEFINITION_org_xmlvm_iphone_UIImagePickerControllerQualityType* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIImagePickerControllerQualityType;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIImagePickerControllerQualityType
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIImagePickerControllerQualityType
typedef struct org_xmlvm_iphone_UIImagePickerControllerQualityType org_xmlvm_iphone_UIImagePickerControllerQualityType;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIImagePickerControllerQualityType 6

void __INIT_org_xmlvm_iphone_UIImagePickerControllerQualityType();
void __INIT_IMPL_org_xmlvm_iphone_UIImagePickerControllerQualityType();
void __DELETE_org_xmlvm_iphone_UIImagePickerControllerQualityType(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIImagePickerControllerQualityType(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIImagePickerControllerQualityType();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIImagePickerControllerQualityType();
JAVA_INT org_xmlvm_iphone_UIImagePickerControllerQualityType_GET_High();
void org_xmlvm_iphone_UIImagePickerControllerQualityType_PUT_High(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIImagePickerControllerQualityType_GET_D640x480();
void org_xmlvm_iphone_UIImagePickerControllerQualityType_PUT_D640x480(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIImagePickerControllerQualityType_GET_Medium();
void org_xmlvm_iphone_UIImagePickerControllerQualityType_PUT_Medium(JAVA_INT v);
JAVA_INT org_xmlvm_iphone_UIImagePickerControllerQualityType_GET_Low();
void org_xmlvm_iphone_UIImagePickerControllerQualityType_PUT_Low(JAVA_INT v);

#endif
