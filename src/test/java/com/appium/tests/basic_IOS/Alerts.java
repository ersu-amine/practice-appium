package com.appium.tests.basic_IOS;

import com.appium.utilities.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;

public class Alerts extends IOSBaseTest {

    @Test
    public void test() {
        //IOSClassChain, IOSPredicateString
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Simple'")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        // ` is backtick
        driver.findElement((AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]"))).click();
        driver.findElement(AppiumBy.className("XCUIElementTypeTextField")).sendKeys("Coffee");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        //predicate string with multiple attributes, (AND , OR, NOT, BEGINSWITH, ENDSWITH
        driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND label == 'Confirm / Cancel'")).click();
        String alertMessage = driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH 'A message'")).getText();
        System.out.println("alertMessage is = " + alertMessage);
        Assert.assertEquals("A message should be a short, complete sentence.",alertMessage);
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();

    }
}
