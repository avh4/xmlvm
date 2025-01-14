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

package org.xmlvm.demo.ifireworks;

import org.xmlvm.iphone.*;

public class Main extends UIApplicationDelegate implements UIAccelerometerDelegate {

    UIWindow        window;
    UIView          mainView;
    UIAccelerometer accel;


    @Override
    public void applicationDidFinishLaunching(UIApplication app) {
        app.setStatusBarHidden(true);

        UIScreen screen = UIScreen.mainScreen();
        window = new UIWindow(screen.getApplicationFrame());

        mainView = new FireworksView(screen.getApplicationFrame());

        window.addSubview(mainView);
        window.makeKeyAndVisible();

        accel = UIAccelerometer.sharedAccelerometer();
        accel.setUpdateInterval(1.0 / 40);
        accel.setDelegate(this);
    }

    public void accelerometerDidAccelerate(UIAccelerometer accelerometer,
            UIAcceleration acceleration) {
        // NSLog(@"X:%f Y:%f Z:%f", xAxis, yAxis, zAxis);
        Gravity.xGV = acceleration.x() * 2;
        Gravity.yGV = -acceleration.y() * 2;
    }

    public static void main(String[] args) {
        UIApplication.main(args, null, Main.class);
    }

}
