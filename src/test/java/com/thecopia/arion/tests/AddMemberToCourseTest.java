package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thecopia.arion.pages.CourseNotebook;
import com.thecopia.arion.pages.CoursePage;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;

public class AddMemberToCourseTest {

	static Logger log = Logger.getLogger(AddMemberToCourseTest.class);
	
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginAsTeacher() throws InterruptedException {
		log.info("Test 'AddMemberToCourseTest' starting...");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("t1@mailinator.com", "123456");
		String courseTitle = "2014-Art 2014";
		CoursePage coursePage = homePage.openCourcePage(courseTitle);
		CourseNotebook courseNotebookPage = coursePage.openCourseNotebook();
//		Thread.sleep(1000);
		courseNotebookPage.logout();
		log.info("Test 'AddMemberToCourseTest' completed.");
	}

}
