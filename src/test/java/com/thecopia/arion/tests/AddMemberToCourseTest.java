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
import com.thecopia.arion.utils.Utils;


public class AddMemberToCourseTest {

	static Logger log = Logger.getLogger(AddMemberToCourseTest.class);
	
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void setUp() {
		driver = Utils.setBrowserUnderTest(System.getenv("ARION_BROWSER"));
		driver.manage().window().maximize();

}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void addCourseMember() throws InterruptedException {
		
		log.info("Test 'addCourseMember1' starting...");
		LoginPage loginPageTeacher = new LoginPage(driver);
		
		HomePage homePageTeacher = loginPageTeacher.login("t1@mailinator.com", "123456");
		String courseTitleTeacher = "2014-Art 2014";
		CoursePage coursePage = homePageTeacher.openCourcePage(courseTitleTeacher);
		coursePage.isBookExistsInCource("Neebo Student Network");
		CourseNotebook courseNotebookPage = coursePage.openCourseNotebook();
		courseNotebookPage.isNoteExistsInCource("teacher 1");
		courseNotebookPage.logout(driver);
		
		log.info("Test 'addCourseMember1' completed.");
	}


}
