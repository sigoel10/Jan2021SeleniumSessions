package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxSelectUsingStreams {

	public static void main(String[] args) throws InterruptedException {
		
		
//	select all the checkboxes in a webtable with the help of streams
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ElementUtil eutil = new ElementUtil(driver);
		driver.get("https://classic.crmpro.com/index.html");
		By username = By.name("username");
		By password = By.name("password");
		By login = By.xpath("//input[@value='Login']");
		By contactlink = By.xpath("//a[text()='Contacts']");
		By checkbox = By.xpath("//input[@type='checkbox']");
		

		eutil.getElement(username).sendKeys("groupautomation");
		eutil.getElement(password).sendKeys("Test@12345");
		eutil.getElement(login).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		eutil.getElement(contactlink).click();
		eutil.getElements(checkbox).stream().forEach(ele -> ele.click());
		
		By filterCheckbox = By.xpath("//a[text()='Chandru Selvam']/../preceding-sibling::td/input[@type='checkbox']");
//		
//		driver.findElement(username).sendKeys("groupautomation");
//		driver.findElement(password).sendKeys("Test@12345");
//		driver.findElement(login).click();
//		driver.switchTo().frame("mainpanel");
//		driver.findElement(contactlink).click();
////		driver.findElements(checkbox).stream().forEach(ele ->ele.click());
//		driver.findElements(filterCheckbox).stream().forEach(ele -> ele.click());
//		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
//		List<WebElement> checkBoxList = driver.findElements(By.cssSelector("td.select-checkbox"));
//		checkBoxList.stream().forEach(ele -> ele.click());		
	}

}
