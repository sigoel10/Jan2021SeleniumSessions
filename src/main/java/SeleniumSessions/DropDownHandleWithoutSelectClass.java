package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithoutSelectClass {
	static WebDriver driver;

	public static void main(String[] args) {

//Select the dropdown value without using select class	

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

//				List<WebElement> list = 
//						driver.findElements(By.xpath("//Select[@id = 'Form_submitForm_Industry']/option"));
//				List<WebElement> list = driver.findElements(By.cssSelector("#Form_submitForm_Industry option"));
//				for (WebElement e: list)
//				{
//					if(e.getText().equals("Travel")) {
//						e.click();
//						break;
//					}
//				}
		By industry_options = By.cssSelector("#Form_submitForm_Industry option");
		doSelectDropdownValueWithoutSelect(industry_options, "Travel");
		
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void doSelectDropdownValueWithoutSelect(By locator, String value) {
		List<WebElement> list = getElements(locator);
		for (WebElement e : list) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

}
