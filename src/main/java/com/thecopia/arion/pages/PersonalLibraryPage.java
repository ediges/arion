package com.thecopia.arion.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.thecopia.arion.components.NavigationPanel;
import com.thecopia.arion.utils.Utils;

public class PersonalLibraryPage extends LoadableComponent<PersonalLibraryPage>{

	static Logger log = Logger.getLogger(PersonalLibraryPage.class);

	WebDriver driver;
	
	@FindBy (css = "a[ng-click*='PRODUCTS']")
	@CacheLookup
	WebElement tabBooks;


	public PersonalLibraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.get();
		log.debug("Personal Library Page page is loaded");
	}
	
	@Override
	protected void isLoaded() throws Error {
		try {
			Utils.waitPageLoading(driver);
			Assert.assertTrue(tabBooks.isDisplayed());
		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	@Override
	protected void load() {
		Utils.waitForElementVisible(driver, tabBooks);
	}


}
