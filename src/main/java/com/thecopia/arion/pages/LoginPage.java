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

public class LoginPage extends LoadableComponent<LoginPage> {

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
	String baseUrl = "https://edu.thecopia.com";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.get();
	}

	public HomePage login(String username, String password) {
		edtUsername.sendKeys(username);
		edtPassword.sendKeys(password);
		btnLogin.click();
		return new HomePage(driver);

	}

	@Override
	protected void isLoaded() {

		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(edtUsername.isDisplayed());
			log.debug("Login page is loaded");
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		driver.get(baseUrl);
//		Utils.waitPageLoading(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		log.debug("Login page load()");
}
	

}
