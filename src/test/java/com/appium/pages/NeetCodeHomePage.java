package com.appium.pages;

import com.appium.utilities.MobileBrowserTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeetCodeHomePage extends MobileBrowserTestBase {
    public NeetCodeHomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//h2/following-sibling::button")
    public WebElement featureRequestsButton;
}
