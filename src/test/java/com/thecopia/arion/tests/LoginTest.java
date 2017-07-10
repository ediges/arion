package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;

public class LoginTest {

	static Logger log = Logger.getLogger(LoginTest.class);
	
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void setUp() {
//		baseUrl = "https://edu.thecopia.com";
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginAsTeacher() {
		log.info("Test 'LoginPage' starting...");
//		driver.get(baseUrl);
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("t1@mailinator.com", "123456");
		homePage.logout();
		log.info("Test 'LoginPage' completed.");
	}

}
