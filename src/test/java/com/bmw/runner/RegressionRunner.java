package com.bmw.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/report.json"},
        features = "src/test/resources/features",
        glue = "com.bmw.stepDef",
        tags = "@regression",
        dryRun = false
)
public class RegressionRunner {
}
