package com.appium.tests;

import com.appium.utilities.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class CopyToClipboard extends BaseTest {

    @Test
    public void inputClipBoradContent() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        //clipboard text
        driver.setClipboardText("wifiSecretName");
        //send info to wifi input box
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
