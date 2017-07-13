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
import com.thecopia.arion.utils.Utils;

public class CoursePage extends LoadableComponent<CoursePage> {

	static Logger log = Logger.getLogger(CoursePage.class);

	WebDriver driver;

	NavigationPanel navPanel;

	@FindBy(css = "[key='course.library']")
	@CacheLookup
	WebElement lblCourseLibrary;

	@FindBy(id = "courseTitle")
	@CacheLookup
	WebElement lblCourceTitle;

	@FindBy(css = ".library-item")
	@CacheLookup
	List<WebElement> elmLibraryItems;

	@FindBy(css = ".library-item")
	@CacheLookup
	WebElement elmLibraryItem;

	@FindBy(css = ".library-item a[class*='title']")
	@CacheLookup
	List<WebElement> booksTitles;

	@FindBy(css = "a[href*='curriculum']")
	@CacheLookup
	WebElement mnuLibrary;

	@FindBy(css = "a[href*='questionsAnswers']")
	@CacheLookup
	WebElement mnuAssessments;

	// @FindB?y(css = "li[ng-show='menuItems.notebook']")
	@FindBy(css = "a[href*='notes']")
	@CacheLookup
	WebElement mnuNotebook;

	public CoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.navPanel = new NavigationPanel(driver);
		// navPanel = PageFactory.initElements(driver, NavigationPanel.class);
		log.debug("Loading Course page...");
		this.get();
		log.debug("Course page is loaded");
	}

	public LoginPage logout() {
		return navPanel.logout();
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(elmLibraryItem.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		Utils.waitForElementVisible(driver, elmLibraryItem);
	}

	public CourseNotebook openCourseNotebook() {
		Utils.clickOn(driver, mnuNotebook);
		return new CourseNotebook(driver);
	}

	public boolean isBookExistsInCource(String bookTitle) {
		for (WebElement title : booksTitles) {
			if (title.getAttribute("title").equalsIgnoreCase(bookTitle)) {
				log.debug("Book '" + bookTitle + "' is exists in cource library");
				return true;
			}
		}
		log.debug("Book '" + bookTitle + "' is NOT exists in cource library");
		return false;
	}

}
