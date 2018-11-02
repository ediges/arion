package com.thecopia.arion.tests;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thecopia.arion.pages.HomePage2;
import com.thecopia.arion.pages.LoginPage2;
	
public class LoginTest2 extends BaseTestClass {

	static Logger log = Logger.getLogger(LoginTest2.class);
	
	LoginPage2 loginPage;
	HomePage2 homePage;
	
	@BeforeMethod
	public void testStart() {
		loginPage = new LoginPage2(driver, "ms1@mailinator.com", "123456");
		homePage = new HomePage2(driver, loginPage);
	}

	

	@Test
	public void test1() {
		homePage.get();
		
	}

}
