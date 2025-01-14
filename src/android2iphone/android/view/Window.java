/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

package android.view;

import org.xmlvm.iphone.CGPoint;
import org.xmlvm.iphone.CGRect;
import org.xmlvm.iphone.UIApplication;
import org.xmlvm.iphone.UIColor;
import org.xmlvm.iphone.UIScreen;
import org.xmlvm.iphone.UIScrollView;
import org.xmlvm.iphone.UITextField;
import org.xmlvm.iphone.UITextFieldDelegate;
import org.xmlvm.iphone.UIView;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.internal.AndroidAppLauncher;
import android.internal.DecorView;
import android.internal.LayoutManager;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * iPhone Implementation of Android's Window class.
 * 
 * @see http://developer.android.com/reference/android/view/Window.html
 */
public class Window {
    public static final int     FEATURE_NO_TITLE = 1;
    private Activity            activity;
    private UIView              iContainerView;
    private UIScrollView        iScrollView;
    private UITextFieldDelegate iTextFieldDelegate;
    private FrameLayout         internalView;
    private DecorView           decorView;
    private FrameLayout         contentParent;
    private boolean             floating         = false;


    public Window(Activity parent) {
        this.activity = parent;
        iTextFieldDelegate = new UITextFieldDelegate() {
            @Override
            public void textFieldDidBeginEditing(UITextField textField) {
                CGRect rect = textField.getSuperview()
                        .convertRectToView(textField.getFrame(), null);
                int height = (int) UIScreen.mainScreen().getBounds().size.height;
                // TODO don't hardcode keyboard height
                if (rect.origin.y > height - 216 - 60) {
                    CGPoint offset = new CGPoint(0, rect.origin.y - 150);
                    iScrollView.setContentOffset(offset, true);
                }
            }

            @Override
            public void textFieldDidEndEditing(UITextField textField) {
                textField.resignFirstResponder();
                CGPoint offset = new CGPoint(0, 0);
                iScrollView.setContentOffset(offset, true);
            }

            @Override
            public boolean textFieldShouldReturn(UITextField textField) {
                textField.resignFirstResponder();
                return false;
            }
        };
    }

    public void setContentView(View view) {
        xmlvmRemoveWindow();

        // Set default FrameLayout.LayoutParams if view does not have layout
        // params
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.FILL_PARENT));
        }

        // Create UIWindow and transparent internal FrameLayout used to layout
        // the content views.
        iContainerView = new UIView();
        iContainerView.setBackgroundColor(UIColor.clearColor);
        iScrollView = new UIScrollView();
        iScrollView.setScrollEnabled(false);
        iContainerView.addSubview(iScrollView);
        internalView = new FrameLayout(activity);
        internalView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        internalView.setBackgroundColor(0x80000000);
        iScrollView.addSubview(internalView.xmlvmGetViewHandler().getMetricsView());

        // Create DecorView used as the window for all content views
        int gravity = ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity;
        decorView = new DecorView(activity);
        // TODO: Set DecorView's LayoutParams based on Window.isFloating()
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                isFloating() ? LayoutParams.WRAP_CONTENT : LayoutParams.FILL_PARENT,
                isFloating() ? LayoutParams.WRAP_CONTENT : LayoutParams.FILL_PARENT, gravity);
        decorView.setLayoutParams(lp);
        internalView.addView(decorView);

        // Wrap the provided view with a FrameLayout as Android it does. Android
        // uses this to layout the window's decoration. We do it the same way to
        // support all FrameLayout.LayoutParams imposed on the content view.
        contentParent = new FrameLayout(activity);
        contentParent.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        contentParent.setBackgroundColor(0x00000000);
        contentParent.addView(view);
        decorView.addView(contentParent);
        setEditTextDelegates(view);
        adjustFrameSize();
        AndroidAppLauncher.getApplication().xmlvmAddActivityView(iContainerView);
        xmlvmSetHidden(false);
    }

    public void setContentView(int id) {
        View v = LayoutManager.getLayout(activity, id, null);
        setContentView(v);
    }

    public void addContentView(View view, ViewGroup.LayoutParams params) {
        contentParent.addView(view, params);
        layoutContentView(view);
    }

    public void setFlags(int flags, int mask) {
        int maskedFlags = (flags & mask);
        if ((maskedFlags & WindowManager.LayoutParams.FLAG_FULLSCREEN) != 0) {
            UIApplication.sharedApplication().setStatusBarHidden(true);
            adjustFrameSize();
        }
    }

    public void setBackgroundDrawableResource(int resId) {
        if (decorView != null) {
            decorView.setBackgroundResource(resId);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (decorView != null) {
            decorView.setBackgroundDrawable(drawable);
        }
    }

    public void xmlvmShowToast(View toast) {
        layoutContentView(toast);
        UIView itoast = toast.xmlvmGetViewHandler().getMetricsView();
        itoast.setUserInteractionEnabled(false);
        iContainerView.addSubview(itoast);
    }

    public void xmlvmSetHidden(boolean flag) {
        if (iContainerView != null) {
            iContainerView.setHidden(flag);
        }
    }

    public void xmlvmRemoveWindow() {
        if (iContainerView != null) {
            xmlvmSetHidden(true);
            internalView.removeAllViews();
            internalView = null;
            decorView.removeAllViews();
            decorView = null;
            contentParent.removeAllViews();
            contentParent = null;
            iScrollView.removeFromSuperview();
            iScrollView = null;
            AndroidAppLauncher.getApplication().xmlvmRemoveActivityView(iContainerView);
            iContainerView = null;
        }
    }

    /**
     * Internal. Not part of Android API. Called whenever the size or
     * orientation of the top-level window has changed (e.g., when the status
     * bar is made invisible).
     */
    private void adjustFrameSize() {
        if (iContainerView == null) {
            return;
        }
        CGRect rect = xmlvmGetCGRect();
        // AndroidAppLauncher.getApplication().xmlvmGetTopLevelWindow().setFrame(rect);
        // iContainerView.setTransform(null);
        iContainerView.setFrame(rect);
        rect.origin.x = 0;
        rect.origin.y = 0;
        iScrollView.setFrame(rect);
        layoutContentView(internalView);
    }

    private void setEditTextDelegates(View view) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            editText.xmlvmSetKeyboardDelegate(iTextFieldDelegate);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setEditTextDelegates(child);
            }
        }
    }

    private void layoutContentView(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.FILL_PARENT));
        }
        int widthMeasureSpec;
        int heightMeasureSpec;
        CGRect rect = xmlvmGetCGRect();
        LayoutParams lp = view.getLayoutParams();

        if (lp == null || lp.width == LayoutParams.FILL_PARENT) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) rect.size.width,
                    MeasureSpec.EXACTLY);
        } else if (lp.width == LayoutParams.WRAP_CONTENT) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) rect.size.width,
                    MeasureSpec.AT_MOST);
        } else {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
        }

        if (lp == null || lp.height == LayoutParams.FILL_PARENT) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) rect.size.height,
                    MeasureSpec.EXACTLY);
        } else if (lp.height == LayoutParams.WRAP_CONTENT) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) rect.size.height,
                    MeasureSpec.AT_MOST);
        } else {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
        }

        view.xmlvmSetMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        view.requestLayout();
    }

    public CGRect xmlvmGetCGRect() {
        UIScreen screen = UIScreen.mainScreen();
        CGRect rect = screen.getApplicationFrame();
        if (activity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            float t = rect.size.height;
            rect.size.height = rect.size.width;
            rect.size.width = t;
        }
        return rect;
    }

    /**
     * @param id
     * @return
     */
    public View findViewById(int id) {
        return internalView.findViewById(id);
    }

    public WindowManager.LayoutParams getAttributes() {
        // TODO return proper attributes
        return new WindowManager.LayoutParams();
    }

    public boolean isFloating() {
        return floating;
    }
}
