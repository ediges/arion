package com.thecopia.arion.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.thecopia.arion.utils.Utils;

public class CourseAssessmentsPage  extends LoadableComponent<CourseAssessmentsPage>{
	static Logger log = Logger.getLogger(CourseNotebookPage.class);

	WebDriver driver;

	@FindBy(css = "select[ng-options*='sortItem']")
	@CacheLookup
	WebElement selSortItems;
	
	public CourseAssessmentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.get();
		log.debug("Course Assessments page is loaded");
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(selSortItems.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		Utils.waitForElementVisible(driver, selSortItems);
	}

}
