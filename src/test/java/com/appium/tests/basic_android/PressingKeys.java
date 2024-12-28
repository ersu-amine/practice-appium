package com.appium.tests.basic_android;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Test;
import org.openqa.selenium.By;

public class PressingKeys extends BaseTest {

    @Test
    public void pressKey() {
        //provide package + activity
        CommonLibrary.beginActivity("io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies");
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.setClipboardText("wifiSecretName");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //press ok
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        //press back button
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //press home button
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
