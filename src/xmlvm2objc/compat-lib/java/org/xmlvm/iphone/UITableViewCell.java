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

package org.xmlvm.iphone;

import org.xmlvm.XMLVMSkeletonOnly;

@XMLVMSkeletonOnly
public class UITableViewCell extends UIView {

    private boolean      selected = false;
    private UIView       accessoryView;
    private final String reuseIdentifier;
    private int          selectionStyle;

    public UITableViewCell() {
        this(UITableViewCellStyle.Default, null);
    }

    public UITableViewCell(int uiTableViewCellStyle, String reuseIdentifier) {
        super(CGRect.Zero());
        setBackgroundColor(UIColor.clearColor);
        accessoryView = null;
        this.reuseIdentifier = reuseIdentifier;
        selectionStyle = UITableViewCellSelectionStyle.Blue;
    }

    public void setSelected(boolean sel) {
        selected = sel;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getEditingStyle() {
        return UITableViewCellEditingStyle.None;
    }

    @Override
    public void layoutSubviews() {
    }

    public UIView getContentView() {
        return this;
    }

    public void setBackgroundView(UIView backgroundView) {
        // TODO : Java implementation
    }

    public UIView getBackgroundView() {
        // TODO : Java implementation
        return null;
    }

    public void setSelectedBackgroundView(UIView selectedBackgroundView) {
        // TODO : Java implementation
    }

    public UIView getSelectedBackgroundView() {
        // TODO : Java implementation
        return null;
    }

    public UILabel getTextLabel() {
        // TODO : Java implementation
        return null;
    }

    public UILabel getDetailTextLabel() {
        // TODO : Java implementation
        return null;
    }

    public UIImageView getImageView() {
        // TODO : Java implementation
        return null;
    }

    public UIView getAccessoryView() {
        return accessoryView;
    }

    public void setAccessoryView(UIView accessoryView) {
        this.accessoryView = accessoryView;
    }

    public String getReuseIdentifier() {
        return reuseIdentifier;
    }

    public int getSelectionStyle() {
        return selectionStyle;
    }

    public void setSelectionStyle(int uiTableViewCellSelectionStyle) {
        this.selectionStyle = uiTableViewCellSelectionStyle;
    }
}
