package com.thecopia.arion.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;

public class NavigationPanel {
	
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
	
}
