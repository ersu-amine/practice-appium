package com.appium.tests.basic_IOS;

import com.appium.utilities.IOSLoadedAppBase;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Swipe extends IOSLoadedAppBase {
    Logger LOG = LogManager.getLogger();
    @Test
    public void swipeTest() {
        //using apps that come already installed into the phone
        driver.executeScript("mobile:launchApp", ImmutableMap.of(
                "bundleId", "com.apple.mobileslideshow"));

        //store webelement as RemoteWebElement to be used for swiping
        RemoteWebElement allPhotosButton = (RemoteWebElement) driver.findElement(AppiumBy.iOSNsPredicateString("name == 'all_photos_grid'"));

        //scroll up to see 'All' photos button
        Map<String, String> map = new HashMap<>();
        map.put("elementId", allPhotosButton.getId());
        map.put("direction", "down");
        map.put("velocity", "5000");
        driver.executeScript("mobile: swipe", map);

        //get all photos web elements
        List<WebElement> photos = driver.findElements(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeImage' AND name =='PXGGridLayout-Info'"));

        //confirm there's 6 photos
        Assert.assertEquals(6, photos.size());
        LOG.info( "{} is the number of photos",photos.size());
        //click first image
        photos.get(0).click();

        //swipe through each photo, 5 swipes
        for (int i = 0; i < photos.size(); i++) {
            //perform swipe to left
            driver.executeScript("mobile:swipe", ImmutableMap.of(
                    "direction", "left"));

            //date photo taken
            System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText")).getAttribute("value"));
        }

        //close the photo view
        //driver.navigate().back();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Close'")).click();

        //close the bar to reset to default state of app
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Close'")).click();
    }
}
