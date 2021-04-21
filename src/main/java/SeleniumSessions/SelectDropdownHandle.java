package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdownHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
			//dropdown having : Select - tag name
			//select class from selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
//		Select sel_indus = new Select(driver.findElement(industry));
////		sel_indus.selectByIndex(5);
////		sel_indus.selectByVisibleText("Automotive");
////		sel_indus.selectByValue("health");
//		
//		
//		Select sel_country = new Select (driver.findElement(country));
//		sel_country.selectByVisibleText("India");
//		doSelectDropdownByIndex(industry, 2);
//		doSelectDropdownByIndex(country, 3);
		
		doSelectDropdownByValue(industry, "media");
		doSelectDropdownByVisibleText(country, "India");
		Thread.sleep(2000);
		doSelectDropdownByValue(state, "Maharashtra");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select (getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropdownByVisibleText(By locator, String visibletext) {
		Select select = new Select (getElement(locator));
		select.selectByVisibleText(visibletext);
	}
	
	public static void doSelectDropdownByValue(By locator, String value) {
		Select select = new Select (getElement(locator));
		select.selectByValue(value);
	}
}
