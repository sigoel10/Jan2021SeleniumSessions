package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndClickConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@type='submit']");
		
//		WebElement emailEle = driver.findElement(emailId);
//		WebElement pwdEle = driver.findElement(password);
//		WebElement LoginEle = driver.findElement(loginButton);
//		
//		Actions act = new Actions(driver);
//		act.sendKeys(emailEle, "shraddha@gmail.com").perform();
//		act.sendKeys(pwdEle, "test123").perform();
//		act.click(LoginEle).perform();
		
		doActionsSendKeys(emailId,"shraddha@gmail.com");
		doActionsSendKeys(password, "test123");
		doActionsClick(loginButton);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick (By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
}
