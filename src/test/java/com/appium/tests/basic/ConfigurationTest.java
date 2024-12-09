package com.appium.tests.basic;

import com.appium.utilities.ConfigurationReader;
import org.junit.Test;

public class ConfigurationTest {
    @Test
    public void test() {
        System.out.println("ConfigurationReader.getProperty(\"path\") = " + ConfigurationReader.getProperty("path"));
        System.out.println("ConfigurationReader.getProperty(\"sdaf\") = " + ConfigurationReader.getProperty("invalidkey"));
    }
}
