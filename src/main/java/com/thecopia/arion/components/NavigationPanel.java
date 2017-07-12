package com.thecopia.arion.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Configuration;

import com.thecopia.arion.pages.CoursePage;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.utils.Utils;

public class NavigationPanel extends LoadableComponent<NavigationPanel> {
	
	static Logger log = Logger.getLogger(CoursePage.class);
	
	@FindBy (css = ".topMenuItem [key*='home.my.courses']")
	@CacheLookup
	WebElement mnuMyCources;

	@FindBy (css = "href='#/myLibrary'")
	@CacheLookup
	WebElement mnuPersonalLibrary;

	@FindBy (css = ".topMenuItem [key*='menu.ereaders']")
	@CacheLookup
	WebElement mnuReaders;

//	@FindBy (css = ".navbar-nav .userMenuItem")
	@FindBy (css = ".userMenuItem .caret")
	@CacheLookup
	WebElement mnuUserMenu;
	
	@FindBy (css = ".dropdown-menu li a[href*='logout']")
	@CacheLookup
	WebElement itemSignOut;	
	
	WebDriver driver;
	
	public NavigationPanel(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage logout() {
		log.debug("Logout started ...");
//		Utils.waitForElementVisible(driver, mnuUserMenu);
//		Utils.elementClick(driver, mnuUserMenu);
//		Utils.waitForElementVisible(driver, itemSignOut);
//		Utils.elementClick(driver, itemSignOut);
		
		Utils.clickOnElement(driver, mnuUserMenu);
		Utils.clickOnElement(driver, itemSignOut);
		
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

