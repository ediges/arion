package com.thecopia.arion.pages.homepage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.thecopia.arion.utils.Utils;

public class HomePage extends LoadableComponent<HomePage> {
	
	static Logger log = Logger.getLogger(HomePage.class);

	WebDriver driver;
	
	@FindBy (css = ".dropdown.userMenuItem")
	@CacheLookup
	WebElement mnuUserMenu;
	
	@FindBy (css = "[ng-bind*='home.my.courses']")
	@CacheLookup
	WebElement lblMyCources;
	
	@FindBy (css = "[ng-click*='getCourseInfo']")
	@CacheLookup
	List<WebElement> myCources;
	
	@FindBy (css = ".btn[ng-click='joinCourse()']")
	@CacheLookup
	WebElement btnJoinCourse;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.get();
		log.debug("Home page is loaded");
	}
	

	@Override
	protected void isLoaded() throws Error {
		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(lblMyCources.isDisplayed());
			System.out.println("Home page is loaded");

		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		Utils.waitForElementVisible(driver, lblMyCources);
		System.out.println("Loading Home page");
	}
	
	public boolean isCourseExists(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				return true;
			}
		}
		return false;
	}
	
/*	public CoursePage openCoursePage(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				Utils.clickOn(driver, myCource);//myCource.click();
				return new CoursePage(driver);
			}
		}
		log.debug("Course " + courseTitle + " is not found");
		return null;
	}
*/
}
