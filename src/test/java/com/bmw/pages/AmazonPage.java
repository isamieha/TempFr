package com.bmw.pages;

import com.bmw.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;

    public AmazonPage(){

        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//a[@id='bcKwText']/span")
    public WebElement amazonSearchResult;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement amazonSearchButton;

    @FindBy(xpath = "//span[.='Hello, Sign in']")
    public WebElement helloSignInButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[.='Orders']")
    public WebElement ordersTab;

    @FindBy(xpath = "//span[@class='num-orders']")
    public WebElement numberOfOrders;

  public void passCredentials(String userName, String password){
      inputEmail.sendKeys(userName);
      inputPassword.sendKeys(password);
      signInButton.click();
  }


}
