package com.thecopia.arion.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage>{
	
@FindBy (name = "usernameOrEmail")
@CacheLookup
WebElement edtUsername;

@FindBy (name = "password")
@CacheLookup
WebElement edtPassword;

@FindBy (css = ".submit-button")
@CacheLookup
WebElement btnLogin;

WebDriver driver;
String baseUrl = "https://edu.thecopia.com";

public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.get();
}

public HomePage login(String username, String password){
	edtUsername.sendKeys(username);
	edtPassword.sendKeys(password);
	btnLogin.click();
	return new HomePage(driver);
	
}

@Override
protected void isLoaded() {
	System.out.println("LoginPage isLoaded()");
	
	try {
		Assert.assertTrue(edtUsername.isDisplayed());
	} catch (Exception e) {
		throw new AssertionError();
	}
}

@Override
protected void load() {
	System.out.println("LoginPage load()");
	driver.get(baseUrl);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(btnLogin));
}


}
