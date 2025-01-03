package com.appium.tests.basic_IOS;

import com.appium.utilities.IOSTestAppBase;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Sliding extends IOSTestAppBase {
    @Test
    public void sliderTest() {
        WebElement sliderElement = driver.findElement(AppiumBy.className("XCUIElementTypeSlider"));

        Assert.assertEquals("50%",sliderElement.getAttribute("value"));

        sliderElement.sendKeys("0.76");//1 is 100%
        //should be 80%
        Assert.assertEquals("80%",sliderElement.getAttribute("value"));
    }
}
