package com.appium.tests;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import io.appium.java_client.AppiumBy;
import org.junit.Test;

public class Scrolling extends BaseTest {

    @Test
    public void scrollingWithJS() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        CommonLibrary.scrollIntoView("Visibility");
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Visibility\"));"));
        Thread.sleep(2000);
    }
}
