package com.appium.tests.ecommerceapp;

import com.appium.utilities.CommonLibrary;
import com.appium.utilities.ECommerceAppBase;
import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationForm extends ECommerceAppBase {

    @Test
    public void validName() {
        //tap on the dropdown to open
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        //TODO implement wait?
        // scroll until seeing target country
        CommonLibrary.scrollIntoView("Canada");
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

    }

    @Test
    public void spaceAsName() {
        // scroll until seeing target country
        CommonLibrary.scrollIntoView("Canada");
        //select country
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Canada']")).click();
        //enter name to input box
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(" ");
        //select gender
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //tap let's shop button
        driver.findElement(By.className("android.widget.Button")).click();

        //assertion of error message

    }


    @Test
    public void numberAsName() {
        // scroll until seeing target country
        CommonLibrary.scrollIntoView("Canada");
        //select country
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Canada']")).click();
        //enter name to input box
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("");
        //select gender
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //tap let's shop button
        driver.findElement(By.className("android.widget.Button")).click();

        //expected error message but logins
        // assertion of error message

    }
}
