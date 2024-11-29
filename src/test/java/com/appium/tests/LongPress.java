package com.appium.tests;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LongPress extends BaseTest {

    @DisplayName("nkjjhjkkjjopl")
    @Test
    public void longPressGesture() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        CommonLibrary.longPress(element);


    }
}
