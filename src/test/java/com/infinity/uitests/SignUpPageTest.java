package com.infinity.uitests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.infinity.config.BaseClass;
import com.infinity.keywords.UIKeywords;

public class SignUpPageTest extends BaseClass {
	private static final Logger LOG=Logger.getLogger(SignUpPageTest.class);
	UIKeywords keyword = UIKeywords.getInstance();
	@Test
	public void validateFullNameFieldForCorrectInput() throws InterruptedException {
		String url="https://ijmeet.com";
		keyword.launchUrl(url);	
		LOG.info("URL is launched: "+url);
		keyword.click("css","li:nth-child(5) a.nav-link");
		LOG.info("Clicked on Register Button");
		keyword.enterText("css", "input#name", "Aniket Kharat");
		keyword.enterText("css","input#company_name","Infinity Solutions");
		keyword.enterText("css", "input#email", "infinity@solutions.com");
		keyword.enterText("css", "input#contact", "123456890");
		keyword.enterText("css", "inputpassword", "Aniket@123");
		
		keyword.switchToFrame(0);
		LOG.info("Swithcd inside a frame");
		keyword.click("css", "div.recaptcha-checkbox-border");
		keyword.switchToDefaultContent();
		LOG.info("Jumped back from frame");
		
		keyword.click("css", "button[type='submit']");
		String actualUrl=keyword.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("register"));
		LOG.info("Clicked on Register Page");
		Thread.sleep(5000);
		
	}

}
