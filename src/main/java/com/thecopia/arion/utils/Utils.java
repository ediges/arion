package com.thecopia.arion.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Utils {

	static Logger log = Logger.getLogger(Utils.class);

	public static void waitPageLoading(final WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return (document.readyState === 'complete') && (window.jQuery != null) && (jQuery.active === 0);");
			}
		});
	}

	public static void clickOn(WebDriver driver, WebElement element) {
		Utils.waitForElementVisible(driver, element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
