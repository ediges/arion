package com.thecopia.arion.pages;

import java.util.List;

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

import com.thecopia.arion.components.NavigationPanel;

public class HomePage extends LoadableComponent<HomePage> {
	
	static Logger log = Logger.getLogger(HomePage.class);

	WebDriver driver;
	
	NavigationPanel navPanel;
	
	@FindBy (css = ".dropdown.userMenuItem")
	@CacheLookup
	WebElement mnuUserMenu;
	
	@FindBy (css = "[ng-bind*='home.my.courses']")
	@CacheLookup
	WebElement lblMyCources;
	
	@FindBy (css = "[ng-click*='getCourseInfo']")
	@CacheLookup
	List<WebElement> myCources;
	
	
	
	
	
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
		try {
			Assert.assertTrue(lblMyCources.isDisplayed());
			log.debug("Home page is loaded");
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lblMyCources));
	}
	

	public boolean isCourseExists(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				return true;
			}
		}
		return false;
	}
	
	public CoursePage openCourcePage(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				myCource.click();
				return new CoursePage(driver);
			}
		}
		log.debug("Course " + courseTitle + " is not found");
		return null;
	}
}
