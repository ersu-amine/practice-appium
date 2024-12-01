package com.appium.tests;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Scrolling extends BaseTest {

    @Test
    public void scrollingWithUIAutomator() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        CommonLibrary.scrollIntoView("Visibility");
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));"));
    }

    @Test
    public void scrollingWithJavaScript() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        CommonLibrary.scrollWithJS();
    }
}
