package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		// scenario--right click, capture all the text from the list
		// if text is matching to some text available and then click on it
//		WebElement rightClickeEle = driver.findElement(By.xpath("//span[text()='right click me']"));
//		Actions act = new Actions(driver);
//		act.contextClick(rightClickeEle).perform();
		
		By rightClickEle = By.xpath("//span[text()='right click me']");
		By rightClickOptions = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");

		doRightClick(rightClickEle);
		selectRightClickOption(rightClickOptions,"Edit");
		handleAlert();
	}
	
	public static void doRightClick(By locator) {
		WebElement rightClickEle = driver.findElement(locator);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
	}
	
	public static void selectRightClickOption(By locator, String value) throws InterruptedException {

		List<WebElement> rightClickList = driver.findElements(locator);
		 for (WebElement e : rightClickList) {
			String text = e.getText();
			System.out.println(text);
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
	}
}
