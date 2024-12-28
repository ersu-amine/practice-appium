package com.appium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        dryRun = false,
        glue = "com/appium/tests/mobile_browser",
        features = "src/test/resources/features/browsertesting",
        tags = "@wip",
        plugin ={
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty",
        })

public class RoadRunner {

}
