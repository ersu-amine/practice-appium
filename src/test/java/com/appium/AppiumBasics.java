package com.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException, URISyntaxException {
        //AndroidDriver, IOSDriver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9 API 35");
        options.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.quit();
    }
}
