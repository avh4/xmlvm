#ifndef __ORG_XMLVM_IPHONE_CGLAYER__
#define __ORG_XMLVM_IPHONE_CGLAYER__

#include "xmlvm.h"
#include "java_lang_Object.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_lang_Object
#define XMLVM_FORWARD_DECL_java_lang_Object
XMLVM_FORWARD_DECL(java_lang_Object)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGSize
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGSize
XMLVM_FORWARD_DECL(org_xmlvm_iphone_CGSize)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGContext
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGContext
XMLVM_FORWARD_DECL(org_xmlvm_iphone_CGContext)
#endif
// Class declarations for org.xmlvm.iphone.CGLayer
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_CGLayer, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_CGLayer)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGLayer;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGLayer_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGLayer_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_CGLayer_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_CGLayer
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_CGLayer \
    __INSTANCE_FIELDS_java_lang_Object; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_CGLayer \
    } org_xmlvm_iphone_CGLayer

struct org_xmlvm_iphone_CGLayer {
    __TIB_DEFINITION_org_xmlvm_iphone_CGLayer* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_CGLayer;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGLayer
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGLayer
typedef struct org_xmlvm_iphone_CGLayer org_xmlvm_iphone_CGLayer;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_CGLayer 6

void __INIT_org_xmlvm_iphone_CGLayer();
void __INIT_IMPL_org_xmlvm_iphone_CGLayer();
void __DELETE_org_xmlvm_iphone_CGLayer(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_CGLayer(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_CGLayer();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_CGLayer();
JAVA_OBJECT org_xmlvm_iphone_CGLayer_createWithContext___org_xmlvm_iphone_CGContext_org_xmlvm_iphone_CGSize(JAVA_OBJECT n1, JAVA_OBJECT n2);
JAVA_OBJECT org_xmlvm_iphone_CGLayer_getContext__(JAVA_OBJECT me);
JAVA_OBJECT org_xmlvm_iphone_CGLayer_getSize__(JAVA_OBJECT me);

#endif
