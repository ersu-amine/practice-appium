package com.appium.tests.basic_IOS;

import com.appium.utilities.IOSBaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Gestures extends IOSBaseTest {
    @Test
    public void longPress() {

        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        //RemoteWebElement e = driver.findElement(AppiumBy.accessibilityId("target element"));
        //cast element to RemoteWebElement
        RemoteWebElement element = (RemoteWebElement) driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name = 'Increment'`][2]"));

        driver.executeScript("mobile: touchAndHold", ImmutableMap.of(
                "elementId", element.getId(),
                "duration", 2.0
        ));

    }
}
