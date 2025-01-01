package com.appium.tests.basic_IOS;

import com.appium.utilities.IOSBaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void scrollTest() throws InterruptedException {
        RemoteWebElement webViewElement = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Web View"));
        //can use maps
        Map<String, String> map = new HashMap<>();
        map.put("elementId", webViewElement.getId());
        map.put("direction","down");


        driver.executeScript("mobile: scroll", map);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'UIKitCatalog'`]")).click();
        Thread.sleep(3000);
        //TODO  element is clicked without scroll,test pass, must be able to scroll

    }

    @Test
    public void pickerTest() {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        WebElement redComponent = driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Red color component value'"));
        redComponent.sendKeys("95");

        WebElement greenComponent = driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Green color component value'"));
        greenComponent.sendKeys("200");

        WebElement blueComponent = driver.findElement(AppiumBy.accessibilityId("Blue color component value"));
        blueComponent.sendKeys("120");

        Assert.assertEquals("95",redComponent.getText());
        Assert.assertEquals("200",greenComponent.getText());
        Assert.assertEquals("120",blueComponent.getText());

    }
}
