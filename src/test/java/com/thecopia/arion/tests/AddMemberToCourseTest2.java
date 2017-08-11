package com.thecopia.arion.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thecopia.arion.components.CourseSideMenu;
import com.thecopia.arion.components.NavigationPanel;
import com.thecopia.arion.pages.CourseAssessmentsPage;
import com.thecopia.arion.pages.CourseNotebookPage;
import com.thecopia.arion.pages.CoursePage;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.utils.Utils;

public class AddMemberToCourseTest2 {

	static Logger log = Logger.getLogger(AddMemberToCourseTest2.class);

	WebDriver driver;
	NavigationPanel navigationPanel;
	CourseSideMenu courseSideMenu;
	String baseUrl;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(String browser) throws MalformedURLException {
//		driver = Utils.setBrowserUnderTest(System.getProperty("test.browser"));
		driver = Utils.setBrowserUnderTest(browser);
		driver.manage().window().setSize(new Dimension(1920, 1080));

//		driver.manage().window().maximize();
		navigationPanel = new NavigationPanel(driver);
		courseSideMenu = new CourseSideMenu(driver);
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
		CoursePage coursePage = homePageTeacher.openCoursePage(courseTitleTeacher);
		coursePage.isBookExistsInCource("Neebo Student Network");

		CourseNotebookPage courseNotebookPage = courseSideMenu.gotoCourseNotebook();
		if (courseNotebookPage.isNoteExistsInCource("teacher 1")) {
			log.info("Note exists");
		}
		
		CourseAssessmentsPage courseAssessmentsPage = courseSideMenu.gotoCourseAssessments();
		courseSideMenu.gotoCourseNotebook();

		navigationPanel.logout(driver);

		log.info("Test 'addCourseMember1' completed.");
	}

}
