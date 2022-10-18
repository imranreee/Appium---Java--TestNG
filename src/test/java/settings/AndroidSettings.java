/*
 * *
 *  * Created by Al Imran on 21/09/18 10:18
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 04/09/18 18:15
 *
 *
 */

package settings;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by: Al Imran on 21/09/2018.
 * Email: imranreee@gmail.com
 **/

public class AndroidSettings {
    protected AndroidDriver driver;

    public void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformVersion", Credentials.platformVersion);
        dc.setCapability("deviceName", "Android");
        //dc.setCapability("noReset", "true"); //Make noRest true or false as per needs
        dc.setCapability("autoGrantPermissions", "true");
        //dc.setCapability("app", RunCases.appPath);

        dc.setCapability("appPackage", Credentials.appPackage);
        dc.setCapability("appActivity", Credentials.appActivity);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
    }
}
