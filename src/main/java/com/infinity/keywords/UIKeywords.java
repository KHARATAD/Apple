package com.infinity.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains UI Keywords which are applicable for WebElement and general actions on Web Page.
 * This is a SingleTon class. To create an object of this class; Use {@code getInstance()} method
 * @author Aniket
 */
public class UIKeywords  {
	public RemoteWebDriver driver=null;
	
	
	private static final UIKeywords uikeywords;
	
	static {
		uikeywords=new UIKeywords();
	}
	public static UIKeywords getInstance() {
		return uikeywords;
	}
	
	private UIKeywords() {
	}
	
	
	/**
	 * This Keyword is used to launch specified browser
	 * 
	 * @author Aniket K.
	 * @param browserName must be one of the following
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>firefox</li>
	 *                    <li>ie</li>
	 *                    <li>edge</li>
	 */
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name: " + browserName);
		}
	}
	


	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void click(WebElement element) {
		element.click();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public RemoteWebDriver getDriver() {
		return driver;
	}
	
	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element=null;
		
		if(locatorType.equalsIgnoreCase("xpath")) {
			element=driver.findElement(By.xpath(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("css")) {
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("id")) {
			element=driver.findElement(By.id(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("name")) {
			element=driver.findElement(By.name(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("class")) {
			element=driver.findElement(By.className(locatorValue));
		}
		if(locatorType.equalsIgnoreCase("tag")) {
			element=driver.findElement(By.tagName(locatorValue));
		}
		return element;
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public void enterText(String locatorType,String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
}
