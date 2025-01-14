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

package android.widget;


import android.content.Context;
import android.internal.UIToggleButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.Set;
import org.xmlvm.iphone.UIEvent;
import org.xmlvm.iphone.UITouch;
import org.xmlvm.iphone.UIView;

public class ToggleButton extends CompoundButton {

    public ToggleButton(Context c) {
        super(c);
        initToggleButton(c, null);
    }

    public ToggleButton(Context c, AttributeSet attrs) {
        super(c, attrs);
        initToggleButton(c, attrs);
    }

    private void initToggleButton(Context c, AttributeSet attrs) {
        if (attrs != null && attrs.getAttributeCount() > 0) {
            parseToggleButtonAttributes(attrs);
        }
    }

    private void parseToggleButtonAttributes(AttributeSet attrs) {
        setIgnoreRequestLayout(true);

        String value = attrs.getAttributeValue(null, "textOn");
        setTextOn(value != null ? value : "");
        value = attrs.getAttributeValue(null, "textOff");
        setTextOff(value != null ? value : "");

        setIgnoreRequestLayout(false);
    }

    @Override
    protected UIView xmlvmNewUIView(AttributeSet attrs) {
        return new UIToggleButton() {

            @Override
            public void touchesBegan(Set<UITouch> touches, UIEvent event) {
                xmlvmTouchesEvent(MotionEvent.ACTION_DOWN, touches, event);
            }

            @Override
            public void touchesMoved(Set<UITouch> touches, UIEvent event) {
                xmlvmTouchesEvent(MotionEvent.ACTION_MOVE, touches, event);
            }

            @Override
            public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
                xmlvmTouchesEvent(MotionEvent.ACTION_CANCEL, touches, event);
            }

            @Override
            public void touchesEnded(Set<UITouch> touches, UIEvent event) {
                xmlvmTouchesEvent(MotionEvent.ACTION_UP, touches, event);
            }
        };
    }

    @Override
    public void setText(String text) {
        this.text = text;
        ((UIToggleButton) xmlvmGetViewHandler().getContentView()).setText(text);
        requestLayout();
    }

    void setTextOff(String textOff) {
        ((UIToggleButton) xmlvmGetViewHandler().getContentView()).setTextOff(textOff);
        requestLayout();
    }

    void setTextOn(String textOn) {
        ((UIToggleButton) xmlvmGetViewHandler().getContentView()).setTextOff(textOn);
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minWidth = getSuggestedMinimumWidth();
        int minHeight = getSuggestedMinimumHeight();

        // TODO: Also consider the button's text size to determine its size
        setMeasuredDimension(minWidth, minHeight);
    }

    @Override
    protected void xmlvmUpdateUIView(boolean checked) {
        ((UIToggleButton) xmlvmGetViewHandler().getContentView()).setSelected(checked);
    }

}
