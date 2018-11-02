package com.thecopia.arion.pages.coursepage;

import org.openqa.selenium.WebElement;

public class CheckBookExistanceInCourseLibrary{

	public boolean isBookExistsInCourseLibrary(CoursePage coursePage, String bookTitle) {
		for (WebElement title : coursePage.booksTitles) {
			if (title.getAttribute("title").equalsIgnoreCase(bookTitle)) {
				System.out.println("Title is found");
				return true;
			}
		}
		System.out.println("Title is found");
		return false;
	}
}
