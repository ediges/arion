package com.thecopia.arion.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thecopia.arion.pages.coursepage.CoursePage;
import com.thecopia.arion.utils.Utils;

/*public class HomePageOpenCoursePage extends HomePage {
	
	public HomePageOpenCoursePage(WebDriver driver) {
		super(driver);
	}
*/
public class HomePageOpenCoursePage {
	public CoursePage homePageOpenCoursePage(WebDriver driver, HomePage homePage, String courseTitle) {
		for (WebElement myCource : homePage.myCources) {
			if (myCource.getAttribute("title").equalsIgnoreCase(courseTitle)) {
				Utils.clickOn(driver, myCource);// myCource.click();
				return new CoursePage(driver);
			}
		}
		return null;
	}

}
