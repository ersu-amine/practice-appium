package com.appium.tests;

import com.appium.utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;

public class Rotation extends BaseTest {

    /**
     * rotate the app to landscape mode if it is in portrait mode
     * or rotate to portrait mode if it is in the landscape mode
     */
    @Test
    public void rotateToPortraitOrLandScape() {
        ScreenOrientation orientation = driver.getOrientation();

        if (orientation.equals(ScreenOrientation.PORTRAIT)){
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }else{
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    /**
     * rotate to landscape mode using DeviceRotation object
     */
    @Test
    public void rotateToLandscape() {
        DeviceRotation landscape = new DeviceRotation(0,0, 90); //90 for rotational z axis
        driver.rotate(landscape);
    }

    /**
     * rotate to portrait mode using DeviceRotation object
     */
    @Test
    public void rotatePortrait() {
        DeviceRotation portrait = new DeviceRotation(0,0, 0);
        driver.rotate(portrait);
    }
}
