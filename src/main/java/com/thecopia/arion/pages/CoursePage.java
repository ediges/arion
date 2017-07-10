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

public class CoursePage extends LoadableComponent<CoursePage> {

	static Logger log = Logger.getLogger(CoursePage.class);

	WebDriver driver;

	NavigationPanel navPanel;

	@FindBy(css = "[key='course.library']")
	@CacheLookup
	WebElement lblCourseLibrary;

	@FindBy(id = "#courseTitle")
	@CacheLookup
	WebElement lblCourceTitle;

	@FindBy(css = ".library-item")
	@CacheLookup
	List<WebElement> elmLibraryItem;

	public CoursePage(WebDriver driver) {
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
			Assert.assertTrue(lblCourseLibrary.isDisplayed());
			log.debug("Course page is loaded");
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lblCourseLibrary));
	}

}
