package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
/**
 * Web driver wait is explicit wait
 * WebDriverWait is a ---class in selenium
 * its super class is FluentWait class which implements wait interface--until method
 * until method is implemented on FluentWait class
 * it can be applied for any WebElement and non WEs (alert url title)
 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		By username = By.name("username");
		By password = By.name("password");
		By LoginButton = By.xpath("//input[@value='Login']");
		By Logout = By.xpath("//a[contains(text(),'Logout')]");
		
		//if i want to create wait only for username
		
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		WebElement username_ele = wait.
//				until(ExpectedConditions.presenceOfElementLocated(username));
		
		waitForElementPresent(username, 10).sendKeys("groupautomation");
		driver.findElement(password).sendKeys("Test@12345");
		driver.findElement(LoginButton).click();
		driver.switchTo().frame("mainpanel");
		waitForElementPresent(Logout, 5).click();
		
		/**
		 * webdriver wait is not global wait
		 * it will be applied on that specific element and rest of the script will not wait any more
		 * performace of the script will not be decreased here
		 * so WebDriverWait is applied whenever required here only on 2 elements
		 */
	}
	

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 *  This does not necessarily mean that the element is visible.
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
