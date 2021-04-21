package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickAssignment {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		By rightClickButton = By.xpath("//span[text()='right click me']");
		By optionsList = By.xpath("//ul[contains(@class,'context-menu-list')]/li/span");
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Edit");
		handleAlert();
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Cut");
		handleAlert();
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Copy");
		handleAlert();
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Paste");
		handleAlert();
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Delete");
		handleAlert();
		
		doRightClick(rightClickButton);
		getRightClickOptions(optionsList, "Quit");
		handleAlert();
	}
	public static void doRightClick(By locator) {
		WebElement rightClickButton = driver.findElement(locator);
		Actions act = new Actions(driver);
		act.contextClick(rightClickButton).perform();
	}
	
	public static void getRightClickOptions(By locator, String value){
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e: optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
			e.click();
			break;
			}
		}
	}
	
	public static void handleAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
//		driver.switchTo().defaultContent();
		System.out.println("-----------");
	}
}
