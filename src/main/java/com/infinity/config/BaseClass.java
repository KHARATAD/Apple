package com.infinity.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.infinity.keywords.UIKeywords;

public class BaseClass {
	UIKeywords keyword=UIKeywords.getInstance();
	public RemoteWebDriver driver=null;
	
	@BeforeMethod
	public void setup() {
		keyword.openBrowser("chrome");
		this.driver=keyword.getDriver();
		keyword.maximizeBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		keyword.quitBrowser();
	}

}
