package com.appium.tests;

import com.appium.utilities.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AppiumBasics extends BaseTest {


    @Test
    public void setWifiName() {

        //xpath, id, accesibilityID, classname, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //set wifi name
        //click/tap on preference dependencies
        //can use By or AppiumBy
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        //tap on checkbox
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //tap wifi settings, can generate xpath with tagname
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals("Alert title does not match","WiFi settings",alertTitle);

        //send info to wifi input box
        driver.findElement(By.id("android:id/edit")).sendKeys("WifiName");

        //tap OK button, find using class name, recommended to use AppiumBy
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();




    }
}
