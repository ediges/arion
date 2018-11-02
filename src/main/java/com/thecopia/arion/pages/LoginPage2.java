package com.thecopia.arion.pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thecopia.arion.utils.Utils;

public class LoginPage2 extends LoadableComponent<LoginPage2> {

	static Logger log = Logger.getLogger(CoursePage.class);

	@FindBy(name = "usernameOrEmail")
	@CacheLookup
	WebElement edtUsername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement edtPassword;

	@FindBy(css = ".submit-button")
	@CacheLookup
	WebElement btnLogin;

	WebDriver driver;
	private String username;
	private String password;
	String baseUrl = "https://edu.thecopia.com";
	
	public LoginPage2(WebDriver driver, String username, String password) {
		this.driver = driver;
		this.username = username;
		this.password = password;
		PageFactory.initElements(driver, this);
//		this.get();
//		log.debug("Login page is loaded");
	}

	public void login(String username, String password) {
		edtUsername.sendKeys(username);
		edtPassword.sendKeys(password);
		btnLogin.click();
//		return new HomePage(driver);

	}

	@Override
	protected void isLoaded() throws Error{
		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(edtUsername.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		driver.get(baseUrl);
		Utils.waitForElementVisible(driver, btnLogin);
		edtUsername.sendKeys(username);
		edtPassword.sendKeys(password);
		btnLogin.click();
}
	

}
