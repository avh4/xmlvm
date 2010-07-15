/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */

package org.xmlvm.iphone.internal.renderer;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;

import org.xmlvm.iphone.CGRect;
import org.xmlvm.iphone.UIButton;
import org.xmlvm.iphone.UIControlState;

/**
 * 
 * @author teras
 */
public class UIRoundRectButtonRenderer extends UICustomButtonRenderer {

    public UIRoundRectButtonRenderer(UIButton view) {
        super(view);
    }

    @Override
    protected boolean drawBackground(Graphics2D g, CGRect displayRect) {
        if (!super.drawBackground(g, displayRect)) {
            Paint borderColor;
            Paint fillColor;
            int x = (int) displayRect.origin.x;
            int y = (int) displayRect.origin.y;
            int w = (int) displayRect.size.width - 2;
            int h = (int) displayRect.size.height - 2;

            if (view.getBackgroundColor() != null) {
                g.setPaint(view.getBackgroundColor().xmlvmGetPaint());
                g.fillRect(x, y, w + 1, h + 1);
            }
            if (getState() == UIControlState.Normal) {
                borderColor = new Color(0x9f9f9f);
                fillColor = Color.WHITE;
            } else {
                borderColor = new Color(0x9f9f9f);
                fillColor = new GradientPaint(0, y, new Color(5, 140, 245), 0, y
                        + displayRect.size.height - 1, new Color(1, 96, 230));
            }

            g.setPaint(fillColor);
            g.fillRoundRect(x, y, w, h, edgeDiameter, edgeDiameter);
            g.setPaint(borderColor);
            g.drawRoundRect(x, y, w, h, edgeDiameter, edgeDiameter);
        }
        return true;
    }

    @Override
    /**
     * RoundRectButton does not support hghlight
     */
    protected void drawHighlight(Graphics2D g, CGRect displayRect) {
    }
}
