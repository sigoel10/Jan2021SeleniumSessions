package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownAllOptionsHandle {
	static WebDriver driver;
	public static void main(String[] args) {
			
				//dropdown having : Select - tag name
				//select class from selenium
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
				
			By industry = By.id("Form_submitForm_Industry");
			By country = By.id("Form_submitForm_Country");
			
//print all the options available in the dropdown and click on the specific option
//			Select sel_indus = new Select(driver.findElement(industry));
//			List<WebElement>indusList = sel_indus.getOptions();
//			System.out.println(indusList.size());
//			for (WebElement e : indusList) {
//				String text = e.getText();
//				if (text.equals("Automotive")) {
//					e.click();
//					break;
//				}
//			}
			
			doSelectDropdown(industry, "Electronics");
			doSelectDropdown(country, "Benin");
	}
//Interview question - select the dropdown value without using select class
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropdown(By locator, String value) {
		Select sel_indus = new Select (getElement(locator));
		
		List<WebElement> optionsList = sel_indus.getOptions();
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	
}
