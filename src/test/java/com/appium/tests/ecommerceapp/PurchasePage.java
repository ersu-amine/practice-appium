package com.appium.tests.ecommerceapp;

import com.appium.utilities.ECommerceAppBase;
import com.appium.utilities.ECommerceUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PurchasePage  extends ECommerceAppBase {
    //Hybrid app
    @Test
    public void test() throws InterruptedException {
        //click dropdown
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //select country
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Antarctica']")).click();
        //enter name
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Cano");
        driver.hideKeyboard();
        //select gender
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        //scroll down to find "LeBron Soldier 12 "
        ECommerceUtils.scrollIntoView("LeBron Soldier 12 ");
        List<WebElement> elements = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        int index = ECommerceUtils.getElementIndex(elements, "LeBron Soldier 12 ");

        //click on the add to cart for item
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[" + index + "]")).click();

        //tap on the shopping cart
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //wait until shopping cart loaded, to prevent locating wrong item with same locator in different pages
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));

        //long press on terms and conditions
        ECommerceUtils.longPress(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton")));
        //assert if terms of conditions alert is opened
        Assert.assertEquals("Terms Of Conditions",driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/alertTitle")).getText());
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        //Thread.sleep(2000);


        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

        //goes to webpage-> hybrid app
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(6000);

        //change context
        ECommerceUtils.displayContextHandle();
        driver.context("WEBVIEW_com.androidsample.generalstore");
        //web automation, google has search bar with attribute name=q
        //must set chromedriver to automate web browser
        driver.findElement(By.name("q")).sendKeys("pigment of reality" + Keys.ENTER);
        Thread.sleep(3000);
        //navigate back to mobile app
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //change context
        driver.context("NATIVE_APP");


    }
}
