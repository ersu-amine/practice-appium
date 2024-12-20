package com.appium.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class ECommerceUtils extends ECommerceAppBase{
    /**
     * @param elementText scrolls down until element text is in view
     */
    public static void scrollIntoView(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
    }

    public static int getElementIndex(List<WebElement> elements, String elementText){
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().equals(elementText)){
                index = i;
                //xpath index start from 1
                return index + 1 ; //get out of loop if index found
            }
        }
        //TODO throw new RuntimeException("List is empty or element with given text is not in the list");
        return index; //no index 0 in xpath
    }

    public static double formatPrice(WebElement price){
        //remove dollar sign
        String str = price.getText().substring(1);
        //convert str to double
        return Double.parseDouble(str);
    }

    /**
     * @param element, perform long press for 2 seconds on the given element
     */
    public static void longPress(WebElement element) {
        //use javascript executor to perform long press, by typecasting driver into JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

}
