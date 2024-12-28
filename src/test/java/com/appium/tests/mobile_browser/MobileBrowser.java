package com.appium.tests.mobile_browser;

import com.appium.pages.NeetCodeHomePage;
import com.appium.utilities.CommonLibrary;
import com.appium.utilities.MobileBrowserTestBase;
import com.appium.utilities.MobileBrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class MobileBrowser extends MobileBrowserTestBase {
    //TODO , driver is null when going with steps
    @Given("user is on the google homepage")
    public void user_is_on_the_google_homepage() {
        driver.get("https://www.google.com");
    }

    @Given("user searches for {string}")
    public void user_searches_for(String searchTerm) throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("user should see relevant results for {string}")
    public void user_should_see_relevant_results_for(String searchTerm) {
        //MobileBrowserUtils.confirmPageTitle(searchTerm);
    }


    @Test
    public void testGoogle() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("pigment of reality" + Keys.ENTER);
        Thread.sleep(3000);

    }

    @Test
    public void testNeetCode() throws InterruptedException {
        //configuration of driver with appium but interaction with browser is with selenium
        driver.get("https://neetcode.io");
        //scroll, inject javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
        NeetCodeHomePage page = new NeetCodeHomePage();
        String buttonText = page.featureRequestsButton.getText();
        Assert.assertEquals("Text of button is not as expected","Feature Requests",buttonText);
    }
}
