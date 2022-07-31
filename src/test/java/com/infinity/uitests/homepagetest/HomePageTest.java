package com.infinity.uitests.homepagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.infinity.config.BaseClass;
import com.infinity.keywords.UIKeywords;



public class HomePageTest extends BaseClass {
	UIKeywords keyword= UIKeywords.getInstance();
	String expectedTitle="YouTube";
	
	@Test
	public void verifyTitleOfHomePage() {
		keyword.launchUrl("http://youtube.com");
		String title=keyword.getTitleOfPage();
		Assert.assertEquals(title,expectedTitle);
	}
	
	
	
}
