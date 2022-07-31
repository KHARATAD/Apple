package com.infinity.util;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinity.keywords.UIKeywords;


public class WaitsFor {
	private static final WebDriverWait wait;
	
	static{
	wait=new WebDriverWait(UIKeywords.getInstance().getDriver(), 10);
	wait.pollingEvery(Duration.ofMillis(500));
	}
	
	public static void visibilityOfElement(WebElement element,int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void stalenessOfElement(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	/**
	 * This method waits for element to be clickable.
	 * Max timeout is of 30 seconds which is not configuration. 
	 * @param Aniket K.
	 */
	public void elementToBeClickable(WebElement element) {
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
