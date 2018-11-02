package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.thecopia.arion.pages.homepage.HomePage;
import com.thecopia.arion.pages.LoginPage;
	
public class LoginTest extends BaseTestClass {

	static Logger log = Logger.getLogger(LoginTest.class);
	
/**
 * My login test based on the BaseTestClass
 */
	@Test
	public void loginAsStudent() {
		log.info("Test 'loginAsStudent' starting...");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("ms1@mailinator.com", "123456");
		String courseTitle = "Algebra-Algebra - Spring - 2014";
		if (homePage.isCourseExists(courseTitle)) {
			log.info("Course " + courseTitle + " is exists");
		}

//		navigationPanel.gotoPersonalLibraryPage(driver);
//		navigationPanel.gotoHomePage(driver);
//		navigationPanel.logout(driver);
		log.info("Test 'loginAsStudent' completed.");
	}

}
