package com.bmw.stepDef;

import com.bmw.pages.AmazonPage;
import com.bmw.utilities.Config;
import com.bmw.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AmazonTitle_steps {

    @When("user goes to amazon application")
    public void user_goes_to_amazon_application() {

        Driver.getDriver().get(Config.getProperty("url"));
    }

    @Then("user should see proper title")
    public void user_should_see_proper_title() {
        String title = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(Driver.getDriver().getTitle(), title);
   //     Driver.closeDriver();
    }

    @Then("user should validate url")
    public void user_should_validate_url() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("amazon.com"));
   //     Driver.closeDriver();

    }

    @Then("user logs in to amazon")
    public void user_logs_in_to_amazon() {
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.helloSignInButton.click();
        String username = Config.getProperty("username");  //email for amazon account
        String password = Config.getProperty("password");

        amazonPage.passCredentials(username,password);
    }

    @Then("user clicks on Orders tab")
    public void user_clicks_on_Orders_tab() {
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.ordersTab.click();
        String titleOrders = "Your Orders";
        Assert.assertEquals(Driver.getDriver().getTitle(),titleOrders);
    }

    @Then("print the order count")
    public void print_the_order_count() {
        AmazonPage amazonPage = new AmazonPage();

        String expectedNumCount = Config.getProperty("expectedNumCount")+" orders";
        String actualNumOfCount =  amazonPage.numberOfOrders.getText();

        System.out.println("Number of orders = "+actualNumOfCount);

        Assert.assertEquals(expectedNumCount,actualNumOfCount);

    }
}
