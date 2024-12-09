package com.appium.tests.basic;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class DragAndDrop extends BaseTest {
    @Test
    public void dragDrop() {
        ScreenOrientation orientation = driver.getOrientation();
        driver.rotate(ScreenOrientation.PORTRAIT);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        CommonLibrary.dragDropByCoordinates(element, 625,625);

        Assert.assertEquals("Dropped!", driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText());

        DeviceRotation landscape = new DeviceRotation(0,0, 90);
        driver.rotate(landscape);



//        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "endX", 100,
//                "endY", 100
//        ));
    }
}
