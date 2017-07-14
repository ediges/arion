package com.thecopia.arion.components;

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
import org.testng.annotations.Configuration;

import com.thecopia.arion.pages.CourseAssessmentsPage;
import com.thecopia.arion.pages.CourseNotebookPage;
import com.thecopia.arion.pages.CoursePage;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.pages.PersonalLibraryPage;
import com.thecopia.arion.utils.Utils;

public class CourseSideMenu extends LoadableComponent<CourseSideMenu> {
	
	static Logger log = Logger.getLogger(CoursePage.class);
	
	@FindBy (id = "side-section")
	@CacheLookup
	WebElement sideSection;

	@FindBy (css = "a[href*='curriculum']") 
	@CacheLookup
	WebElement ssCourseLibrary;

	@FindBy (css = "a[href*='questions']") 
	@CacheLookup
	WebElement ssCourseAssessments;
	
	@FindBy (css = "a[href*='notes']") 
	@CacheLookup
	WebElement ssCourseNotebook;

	@FindBy (css = "a[href*='discussions']") 
	@CacheLookup
	WebElement ssCourseDiscussions;

	@FindBy (css = "a[href*='announcements']") 
	@CacheLookup
	WebElement ssCourseAnnouncements;

	WebDriver driver;
	
	public CourseSideMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			Assert.assertTrue(sideSection.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		Utils.waitForElementVisible(driver, sideSection);
	}
	
	public CourseNotebookPage gotoCourseNotebook() {
		Utils.clickOn(driver, ssCourseNotebook);
		return new CourseNotebookPage(driver);
	}
	
	public CourseAssessmentsPage gotoCourseAssessments() {
		Utils.clickOn(driver, ssCourseAssessments);
		return new CourseAssessmentsPage(driver);
	}
	

}

