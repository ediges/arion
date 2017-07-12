package com.thecopia.arion.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	static Logger log = Logger.getLogger(Utils.class);

	public static void waitPageLoading(final WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

/*		Boolean readyStateComplete = false;
		while (!readyStateComplete) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			readyStateComplete = (Boolean) executor.executeScript("return document.readyState").equals("complete");
		}
*/

		// log.debug("waitPageLoad wait started");
		 wait.until(new ExpectedCondition<Boolean>() {
		 public Boolean apply(WebDriver d) {
		 JavascriptExecutor js = (JavascriptExecutor) d;
		 return (Boolean) js.executeScript("return document.readyState").equals("complete");
		 }
		 });
		//
		// log.debug("waitPageLoad wait done");

	}

	public static void elementClick(WebDriver driver, WebElement element) {
//		WebElement element = driver.findElement(By.id("id-home_prevButton");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public static void waitForElementVisible(WebDriver driver, WebElement element) {
		System.out.println("driver: " + driver);
		System.out.println("element: " + element);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickOnElement(WebDriver driver, WebElement element) {
		System.out.println("driver: " + driver);
		System.out.println("element: " + element);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
