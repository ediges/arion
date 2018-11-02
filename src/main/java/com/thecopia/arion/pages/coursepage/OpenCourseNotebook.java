package com.thecopia.arion.pages.coursepage;

import org.openqa.selenium.WebDriver;

import com.thecopia.arion.utils.Utils;

public class OpenCourseNotebook{

	public void openCourseNotebook(WebDriver driver, CoursePage coursePage) {
	Utils.clickOn(driver, coursePage.mnuNotebook);
	
	System.out.println("Course Notebook opened");
}

}
