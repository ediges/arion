package com.thecopia.arion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thecopia.arion.utils.Utils;

public class HomePageOpenCoursePage extends HomePage {
	
	WebDriver driver;
	
	public HomePageOpenCoursePage(WebDriver driver) {
		super(driver);
	}
	
	public CoursePage openCoursePage(String courseTitle) {
		for (WebElement myCource : myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				Utils.clickOn(driver, myCource);//myCource.click();
				return new CoursePage(driver);
			}
		}
		log.debug("Course " + courseTitle + " is not found");
		return null;
	}


}
