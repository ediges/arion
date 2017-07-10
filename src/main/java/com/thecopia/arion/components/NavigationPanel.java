package com.thecopia.arion.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thecopia.arion.pages.CoursePage;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;

public class NavigationPanel extends LoadableComponent<NavigationPanel> {
	
	static Logger log = Logger.getLogger(CoursePage.class);
	
	@FindBy (css = ".topMenuItem [key*='home.my.courses']")
	WebElement mnuMyCources;

	@FindBy (css = "href='#/myLibrary'")
	WebElement mnuPersonalLibrary;

	@FindBy (css = ".topMenuItem [key*='menu.ereaders']")
	WebElement mnuReaders;

	@FindBy (css = ".userMenuItem")
	WebElement mnuUserMenu;
	
	@FindBy (css = ".dropdown-menu a[href*='logout']")
	WebElement mitemSignOut;	
	
	WebDriver driver;
	
	public NavigationPanel(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage logout() {
		mnuUserMenu.click();
		mitemSignOut.click();
		return new LoginPage(driver);
	}
	
	public HomePage goHomePage() {
		mnuMyCources.click();
		return new HomePage(driver);
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			Assert.assertTrue(mnuUserMenu.isDisplayed());
			log.debug("Navigation panel is loaded");
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(mnuUserMenu));
		
	}
	
}
