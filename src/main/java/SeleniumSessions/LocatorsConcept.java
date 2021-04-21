package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://www.freshworks.com/");
		
		//create the webelement + perform the action(click,sendKeys, getText,isDisplayed)
		//1. id:
//		driver.findElement(By.id("input-email")).sendKeys("test");
//		driver.findElement(By.id("input-password")).sendKeys("test123");
		
		//2nd: reusable code here we dont need to create webelement again if we want to use this again in our project
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test");
//		password.sendKeys("test123");
//		
		//3rd: By locators: better from 2nd because we are not interacting with the servers when we create By locators
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		driver.findElement(emailId).sendKeys("test");
//		driver.findElement(password).sendKeys("test123");
		
		//4th: By LOcators + webElement
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement email_ele = driver.findElement(emailId);
//		WebElement password_ele = driver.findElement(password);
//		
//		email_ele.sendKeys("test");
//		password_ele.sendKeys("test123");
		
		
		//5th: generic method
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId,"test");
//		getElement(password,"test123");
		
		//6th:
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By registerLink = By.linkText("Register");
		
//		doSendKeys(emailId, "test");
//		doSendKeys(password,"test123");
		
		//2nd: name:
		//driver.findElement(By.name("username")).sendKeys("testautomation");
//when id and name both are available use ID locator as ID is unique
		
		//3rd: className: its not a unique element
		//we have to use only we have unique class name for that element
//class means how this particular element will look like on web page
		//driver.findElement(By.className("test")).sendKeys("testing");
		//4th: linktext: only for links
		//driver.findElement(By.linkText("Register")).click();
		//doClick(registerLink);
		
		//5th: Partial link text: only for links
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//6th: xpath: is not an attribute
		//address of the element inside the html DOM
		
//		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input[1]")).click();
		
		By un = By.xpath("//*[@id='input-email']");
//		doSendKeys (un,"test@gmail.com");
		
		//7th: cssSelector: is not an attribute
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
		
		//8th: tagName: 
//	String text = driver.findElement(By.tagName("h2")).getText();
//	System.out.println(text);
		
		By header = By.tagName("h2");
		String text = doGetText(header);
		System.out.println(text);
	
		By customerLink = By.linkText("Customers");
		System.out.println(doGetText(customerLink));
		
		//System.out.println(driver.findElement(By.linkText("Customers")).isDisplayed());
	System.out.println(doIsDisplayed(header));
	
	
	
	}
	
//	public static void getElement (By locator, String value) {
//		driver.findElement(locator).sendKeys(value);
//	}
	
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
}
