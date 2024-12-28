package com.appium.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSBaseTest {

    public static AppiumDriverLocalService service;
    public static IOSDriver driver;

    @BeforeClass
    public static void setUpAppium() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/michealthonton/.npm-global/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build(); //http not required when giving as IP
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("FirstPhone");
        options.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/apps/UIKitCatalog.app");
        options.setPlatformVersion("18.2");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20)); //wait for webdriver agent to load

        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        service.stop();
    }
}
