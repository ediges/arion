package com.thecopia.arion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thecopia.arion.components.NavigationPanel;

public class HomePage extends LoadableComponent<HomePage> {
	
	WebDriver driver;
	
	NavigationPanel navPanel;
	
	@FindBy (css = ".dropdown.userMenuItem")
	@CacheLookup
	WebElement mnuUserMenu;
	
	@FindBy (css = "[ng-bind*='home.my.courses']")
	@CacheLookup
	WebElement lblMyCources;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navPanel = PageFactory.initElements(driver, NavigationPanel.class);
		this.get();
	}
	
	public LoginPage logout() {
		return navPanel.logout();
	}

	@Override
	protected void isLoaded() throws Error {
		System.out.println("HomePage isLoaded()");
		try {
			Assert.assertTrue(lblMyCources.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		System.out.println("HomePage load()");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lblMyCources));
	}
	

}
