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

import com.thecopia.arion.components.CourseSideMenu;
import com.thecopia.arion.components.NavigationPanel;
import com.thecopia.arion.pages.HomePage;
import com.thecopia.arion.pages.LoginPage;
import com.thecopia.arion.utils.Utils;

public class BaseTestClass {

	static Logger log = Logger.getLogger(BaseTestClass.class);

	WebDriver driver;
	NavigationPanel navigationPanel;
	CourseSideMenu courseSideMenu;
	String baseUrl;

//	@Parameters({"browserName"})
//	public void setUp(String browser) throws MalformedURLException {

	@BeforeClass
	public void setUp() throws MalformedURLException {
//		driver = Utils.setBrowserUnderTest(System.getProperty("test.browser"));
		String browser = "chrome";
		driver = Utils.setBrowserUnderTest(browser);
		driver.manage().window().maximize(); // Could be used with later Firefox releases
		navigationPanel = new NavigationPanel(driver);
		courseSideMenu = new CourseSideMenu(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
