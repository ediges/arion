package com.thecopia.arion.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thecopia.arion.components.NavigationPanel;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.utils.Utils;

public class LoginTest4 {

	static Logger log = Logger.getLogger(LoginTest4.class);
	
	WebDriver driver;
	NavigationPanel navigationPanel;
	String baseUrl;

	@Parameters({"browserName"})
	@BeforeClass
	public void setUp(String browser) throws MalformedURLException {
//		driver = Utils.setBrowserUnderTest(System.getProperty("test.browser"));
		driver = Utils.setBrowserUnderTest(browser);
		driver.manage().window().setSize(new Dimension(1920, 1080));
//		driver.manage().window().maximize(); // Could be used with later Firefox releases 
		navigationPanel = new NavigationPanel(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginAsStudent() {
		log.info("Test 'loginAsStudent' starting...");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("ms1@mailinator.com", "123456");
		String courseTitle = "Algebra-Algebra - Spring - 2014";
		if (homePage.isCourseExists(courseTitle)) {
			log.info("Course " + courseTitle + " is exists");
		}

		navigationPanel.gotoPersonalLibraryPage();
		navigationPanel.gotoHomePage();
		navigationPanel.logout(driver);
		log.info("Test 'loginAsStudent' completed.");
	}

}
