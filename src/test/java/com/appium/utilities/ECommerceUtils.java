package com.appium.utilities;

import io.appium.java_client.AppiumBy;

public class ECommerceUtils extends ECommerceAppBase{
    /**
     * @param elementText scrolls down until element text is in view
     */
    public static void scrollIntoView(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
    }

}
