package com.appium.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
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

    /**
     * scrolls until the end of page
     */
    public static void scrollWithJS() {
        //TODO implement direction parameter
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0));
        }while(canScrollMore);
    }

    /**
     *
     * @param element Webelement to perform swiper action from
     * @param direction of swipe action -> up, down,left, right
     */
    public static void swipe(WebElement element, String direction){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    /**
     *
     * @param element source element to be dragged
     * @param xCoordinate target x coordinate
     * @param yCoordinate target y coordinate
     */
    public static void dragDropByCoordinates(WebElement element, int xCoordinate, int yCoordinate){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", xCoordinate,
                "endY", yCoordinate
        ));
    }

    public static void beginActivity(String activity){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", activity
        ));
    }


}
