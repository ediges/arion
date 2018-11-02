package com.thecopia.arion.pages;

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

public class HomePage2 extends LoadableComponent<HomePage2> {
	
	static Logger log = Logger.getLogger(HomePage2.class);

	WebDriver driver;
	private final LoadableComponent<?> parent;
	private String username;
	private String password;
	
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

	@FindBy (css = ".caption")
	@CacheLookup
	List<WebElement> CoursesTitles;

	
	
	public HomePage2(WebDriver driver, LoadableComponent<?> parent) {
		this.driver = driver;
		this.parent = parent;
		
		PageFactory.initElements(driver, this);
//		this.get();
//		log.debug("Home page is loaded");
	}
	

	@Override
	protected void isLoaded() throws Error {
		try {
			Utils.waitPageLoading(driver);
			Utils.waitForElementVisible(driver, lblMyCources);
			Assert.assertTrue(lblMyCources.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		parent.get();
//		Utils.waitForElementVisible(driver, lblMyCources);
	}
	
	public boolean isCourseExists(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				return true;
			}
		}
		return false;
	}
	
	public CoursePage openCoursePage(String title) {
		for (WebElement courseTitle : CoursesTitles) {
			if (courseTitle.getAttribute("title").contains(title)) {
				Utils.clickOn(driver, courseTitle);//myCource.click();
				return new CoursePage(driver);
			}
		}
		log.debug("Course " + title + " is not found");
		return null;
	}
}
