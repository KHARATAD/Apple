package com.infinity.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infinity.keywords.UIKeywords;

public class HomePage{
	UIKeywords keyword=UIKeywords.getInstance();
	
	@FindBy(css="div#navbarContent  li:nth-child(1)")
	public WebElement joinMeetingTab;
	
	public HomePage() {
		PageFactory.initElements(keyword.driver, HomePage.class);
	}
	

}
