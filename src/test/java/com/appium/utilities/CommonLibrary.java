package com.appium.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class CommonLibrary extends BaseTest {

    /**
     * @param element, perform long press for 2 seconds on the given element
     */
    public static void longPress(WebElement element) {
        //use javascript executor to perform long press, by typecasting driver into JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    /**
     * @param elementText scrolls down until element text is in view
     */
    public static void scrollIntoView(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
    }
}
