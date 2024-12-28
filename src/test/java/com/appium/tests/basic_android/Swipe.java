package com.appium.tests.basic_android;

import com.appium.utilities.BaseTest;
import com.appium.utilities.CommonLibrary;
import io.appium.java_client.AppiumBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Swipe extends BaseTest {
    public Logger LOG = LogManager.getLogger();

    @Test
    public void swipe() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement image = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        LOG.info("value of focusable attribute " + image.getAttribute("focusable"));
        //before swipe
        Assert.assertEquals("true", image.getAttribute("focusable"));

        //perform swipe on image
        CommonLibrary.swipe(image,"left");

        //after swipe focusable attribute value changes to false
        //to prevent StaleElementReferenceException
        image = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        LOG.info("value of focusable attribute " + image.getAttribute("focusable"));
        Assert.assertEquals("false", image.getAttribute("focusable"));

    }

}
