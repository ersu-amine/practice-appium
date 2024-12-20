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

public class CartTotal extends ECommerceAppBase {


    @Test
    public void test() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //ECommerceUtils.scrollIntoView("Antarctica");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Antarctica']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Cano");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        //scroll down to find "LeBron Soldier 12 "
        ECommerceUtils.scrollIntoView("LeBron Soldier 12 ");
        List<WebElement> elements = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        int index = ECommerceUtils.getElementIndex(elements, "LeBron Soldier 12 ");

        //click on the add to cart for item
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[" + index + "]")).click();

        //scroll down to find "Jordan Lift Off"
        ECommerceUtils.scrollIntoView("Jordan Lift Off");
        int index2 = ECommerceUtils.getElementIndex(driver.findElements(By.id("com.androidsample.generalstore:id/productName")), "Jordan Lift Off");

        //click on the add to cart for item
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[" + index2 + "]")).click();

        //tap on the shopping cart
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //wait until shopping cart loaded, to prevent locating wrong item with same locator in different pages
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));

        //list with all prices of all items in the cart
        List<WebElement> prices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        double actualTotal = 0;
        for (WebElement price : prices) {
            //remove $ sign and convert string to double to add it to the total

            actualTotal+=ECommerceUtils.formatPrice(price);
        }

        System.out.println("actualTotal = " + actualTotal);
        double totalInCart = ECommerceUtils.formatPrice(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")));

        System.out.println("totalInCart = " + totalInCart);

        //delta value set as 0 because the price cannot be deviating, it should be exact
        Assert.assertEquals("Cart total is NOT matching with item price sum.",actualTotal,totalInCart,0);
    }
}
