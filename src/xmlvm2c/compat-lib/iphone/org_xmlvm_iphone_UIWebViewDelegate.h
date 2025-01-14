#ifndef __ORG_XMLVM_IPHONE_UIWEBVIEWDELEGATE__
#define __ORG_XMLVM_IPHONE_UIWEBVIEWDELEGATE__

#include "xmlvm.h"
#include "org_xmlvm_iphone_NSObject.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIWebView
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIWebView
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UIWebView)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSURLRequest
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSURLRequest
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSURLRequest)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSObject
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSObject
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSObject)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSError
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_NSError
XMLVM_FORWARD_DECL(org_xmlvm_iphone_NSError)
#endif
// Class declarations for org.xmlvm.iphone.UIWebViewDelegate
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UIWebViewDelegate, 6, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UIWebViewDelegate)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIWebViewDelegate;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIWebViewDelegate_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIWebViewDelegate_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UIWebViewDelegate_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIWebViewDelegate
//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UIWebViewDelegate \
    __INSTANCE_FIELDS_org_xmlvm_iphone_NSObject; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UIWebViewDelegate \
    } org_xmlvm_iphone_UIWebViewDelegate

struct org_xmlvm_iphone_UIWebViewDelegate {
    __TIB_DEFINITION_org_xmlvm_iphone_UIWebViewDelegate* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UIWebViewDelegate;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIWebViewDelegate
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UIWebViewDelegate
typedef struct org_xmlvm_iphone_UIWebViewDelegate org_xmlvm_iphone_UIWebViewDelegate;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UIWebViewDelegate 6

void __INIT_org_xmlvm_iphone_UIWebViewDelegate();
void __INIT_IMPL_org_xmlvm_iphone_UIWebViewDelegate();
void __DELETE_org_xmlvm_iphone_UIWebViewDelegate(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UIWebViewDelegate(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UIWebViewDelegate();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UIWebViewDelegate();
void org_xmlvm_iphone_UIWebViewDelegate___INIT___(JAVA_OBJECT me);
void org_xmlvm_iphone_UIWebViewDelegate_didFailLoadWithError___org_xmlvm_iphone_UIWebView_org_xmlvm_iphone_NSError(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_OBJECT n2);
JAVA_BOOLEAN org_xmlvm_iphone_UIWebViewDelegate_shouldStartLoadWithRequest___org_xmlvm_iphone_UIWebView_org_xmlvm_iphone_NSURLRequest_int(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_OBJECT n2, JAVA_INT n3);
void org_xmlvm_iphone_UIWebViewDelegate_webViewDidFinishLoad___org_xmlvm_iphone_UIWebView(JAVA_OBJECT me, JAVA_OBJECT n1);
void org_xmlvm_iphone_UIWebViewDelegate_webViewDidStartLoad___org_xmlvm_iphone_UIWebView(JAVA_OBJECT me, JAVA_OBJECT n1);

#endif
