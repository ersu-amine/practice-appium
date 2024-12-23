package com.appium.tests.mobile_browser;

import com.appium.utilities.CommonLibrary;
import com.appium.utilities.MobileBrowserTestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MobileBrowser extends MobileBrowserTestBase {
    //TODO , driver is null when going with steps
    @Given("user is on the google homepage")
    public void user_is_on_the_google_homepage() {
        driver.get("https://www.google.com");
    }

    @Given("user searches for {string}")
    public void user_searches_for(String searchTerm) throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("pigment of reality" + Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("user should see relevant results for {string}")
    public void user_should_see_relevant_results_for(String searchTerm) {
        CommonLibrary.confirmPageTitle(searchTerm);
    }


    @Test //works because each step in one method
    public void test() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("pigment of reality" + Keys.ENTER);
        Thread.sleep(3000);

    }
}
