package com.appium.tests.ecommerceapp;


import com.appium.utilities.ECommerceAppBase;
import com.appium.utilities.ECommerceUtils;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegistrationForm extends ECommerceAppBase {

    @Test
    public void validName() {
        //tap on the dropdown to open
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        // scroll until seeing target country
        ECommerceUtils.scrollIntoView("Canada");
        //select country
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Canada']")).click();
        //enter name to input box
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("name");
        //to see gender checkboxes keyboard should be hidden
        driver.hideKeyboard();
        //select gender
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        //tap let's shop button
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        //assertion logining into app
        //Products header is seen after successful login
        Assert.assertEquals("Products",driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText());

    }

    @Test
    public void spaceAsName() {
        //tap on the dropdown to open
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        // scroll until seeing target country
        ECommerceUtils.scrollIntoView("Canada");;
        //select country
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Canada']")).click();
        //enter name to input box
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(" ");
        //select gender
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //tap let's shop button
        driver.findElement(By.className("android.widget.Button")).click();

        //assertion of toast message error
        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals("Toast message is NOT as expected","Please enter your name", toastMessage);

    }


    @Test
    public void numberAsName() {
        //tap on the dropdown to open
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        // scroll until seeing target country
        ECommerceUtils.scrollIntoView("Canada");
        //select country
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Canada']")).click();
        //enter name to input box
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("12345");
        //select gender
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //tap let's shop button
        driver.findElement(By.className("android.widget.Button")).click();

        //expected error message but logins
        // assertion of error message
        Assert.assertEquals("Products",driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText());

    }
}
