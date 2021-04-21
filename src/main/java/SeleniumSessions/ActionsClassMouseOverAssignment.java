package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassMouseOverAssignment {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		
		By menu = By.className("menulink");
		By Articles = By.linkText("ARTICLES");
		By courses = By.linkText("COURSES");
		By Single_Videos = By.linkText("SINGLE VIDEOS");
		
		mouseOverAndPerformAction(menu,Articles);
		mouseOverAndPerformAction(menu, courses);
		mouseOverAndPerformAction(menu, Single_Videos);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void mouseOverAndPerformAction(By userAction,By locator) throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement content = getElement(userAction);
		act.moveToElement(content).perform();
		Thread.sleep(3000);
		getElement(locator).click();
		System.out.println(driver.getTitle());
	}
}
