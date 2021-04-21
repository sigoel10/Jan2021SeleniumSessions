package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandleAssignment {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choice = By.cssSelector(".comboTreeItemTitle");
		selectChoice (choice,"choice 7","choice 6 2 2","choice 6 2 1","choice 4","choice 2 3");
//		selectChoice (choice,"all");
//		selectChoice(choice, "all");
	}
	public static List<WebElement> getElements (By locator) {
		return driver.findElements(locator);
	}
	public static void selectChoice(By locator, String... value) { //here value will become an array list
		List<WebElement>choiceList = getElements(locator);
		
		if(!value[0].equalsIgnoreCase("all")) {
		for (int i=0;i<choiceList.size();i++) {
			String text = choiceList.get(i).getText();
			System.out.println(text);
			for (int j=0;j<value.length;j++) {
				if (text.equals(value[j])) {
					choiceList.get(i).click();//counter of choice list is i
					break;
				}
			}
		}
	}
			try {
			for (WebElement e: choiceList) {
				e.click();
			}
			}catch (Exception e) {
			}
		}
	
//	public static void deSelectAll(By locator, String... value) {
//		List<WebElement>choiceList = getElements(locator);
//	}
}
