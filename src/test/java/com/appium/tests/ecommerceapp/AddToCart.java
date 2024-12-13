package com.appium.tests.ecommerceapp;

import com.appium.utilities.ECommerceAppBase;
import com.appium.utilities.ECommerceUtils;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddToCart extends ECommerceAppBase {

    @Test
    public void addItemToCart() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        ECommerceUtils.scrollIntoView("Brazil");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Brazil']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("name");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        //scroll down to find "LeBron Soldier 12 "
        ECommerceUtils.scrollIntoView("LeBron Soldier 12 ");
        List<WebElement> elements = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        int index = ECommerceUtils.getElementIndex(elements, "LeBron Soldier 12 ");

        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[" + index + "]")).click();

        //tap on the shopping cart
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //wait until shopping cart loaded, to prevent locating wrong item with same locator in different pages
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));

        //assert correct item is in the cart
        Assert.assertEquals("LeBron Soldier 12 ", driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText());




    }

}
