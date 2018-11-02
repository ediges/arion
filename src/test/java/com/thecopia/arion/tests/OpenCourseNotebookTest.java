package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.thecopia.arion.pages.homepage.HomePageOpenCoursePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.pages.coursepage.OpenCourseNotebook;
import com.thecopia.arion.pages.coursepage.CheckBookExistanceInCourseLibrary;
import com.thecopia.arion.pages.coursepage.CoursePage;
import com.thecopia.arion.pages.homepage.HomePage;
	
public class OpenCourseNotebookTest extends BaseTestClass {

	static Logger log = Logger.getLogger(OpenCourseNotebookTest.class);
	
/**
 * My login test based on the BaseTestClass
 */
	@Test
	public void openCourseNotebookTest() {
		System.out.println("Test 'openCourseNotebookTest' starting...");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("ms1@mailinator.com", "123456");
		CoursePage coursePage = new HomePageOpenCoursePage().homePageOpenCoursePage(driver, homePage, "Algebra-Algebra - Spring - 2014"); 
		if (new CheckBookExistanceInCourseLibrary().isBookExistsInCourseLibrary(coursePage ,"Java Cryptography")) System.out.println("Book is exists");
		new OpenCourseNotebook().openCourseNotebook(driver, coursePage);
		
		
		System.out.println("Test 'openCourseNotebookTest' ended.");
		
	}

}
