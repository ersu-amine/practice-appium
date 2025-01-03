package com.appium.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class MobileBrowserTestBase{

    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;
    static {
        service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/michealthonton/.npm-global/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build(); //http not required when giving as IP
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9 API 35");
        options.setChromedriverExecutable("/Users/michealthonton/Documents/chromedriver-mac-x64/chromedriver");
        options.setCapability("browserName", "Chrome");

        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @BeforeClass
//    public static void setUpAppium() throws URISyntaxException, MalformedURLException {
//        service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/michealthonton/.npm-global/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build(); //http not required when giving as IP
//        service.start();
//
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Pixel 9 API 35");
//        options.setChromedriverExecutable("/Users/michealthonton/Documents/chromedriver-mac-x64/chromedriver");
//        options.setCapability("browserName", "Chrome");
//
//        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        service.stop();
    }
}
