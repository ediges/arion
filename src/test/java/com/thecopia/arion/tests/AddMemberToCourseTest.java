package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
		// Firefox settings
//		System.setProperty("webdriver.gecko.driver", "C://automation//drivers//geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
//		options.setBinary("C://Program Files (x86)//Mozilla Firefox//firefox.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("moz:firefoxOptions", options);
//		driver = new FirefoxDriver(capabilities);

		// Chrome seetings
		System.setProperty("webdriver.chrome.driver","C://automation//drivers//chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void addCourseMember1() throws InterruptedException {
		log.info("Test 'addCourseMember1' starting...");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("t1@mailinator.com", "123456");
		String courseTitle = "2014-Art 2014";
		CoursePage coursePage = homePage.openCourcePage(courseTitle);
		coursePage.isBookExistsInCource("Neebo Student Network");
		CourseNotebook courseNotebookPage = coursePage.openCourseNotebook();
		courseNotebookPage.isNoteExistsInCource("teacher 1");
		courseNotebookPage.logout();
		log.info("Test 'addCourseMember1' completed.");
	}


}
