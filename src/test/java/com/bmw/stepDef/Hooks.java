package com.bmw.stepDef;


import com.bmw.utilities.Driver;
import com.bmw.utilities.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hooks {

    String log4jConfPath = "log4j.properties";


    public Hooks()  {
    }

    @Before
    public void setUp(Scenario scenario){
        PropertyConfigurator.configure(log4jConfPath);
        Log.startLog("Starting testing");

    }

    //after method will take a screenshot and stores in target folder in local.
    @After
    public  void tearDown(Scenario scenario) throws MalformedURLException {
        PropertyConfigurator.configure(log4jConfPath);

        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");
            Log.error("Error detected");
        }
        Log.endLog("Test is ending");

        Driver.closeDriver();

    }
}
