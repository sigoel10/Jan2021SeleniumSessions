package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		Actions act = new Actions(driver);
		
		WebElement content = driver.findElement(By.className("menulink"));
		act.moveToElement(content).perform();//perform method is used to perform the actual user action
		//what is user action - moveToElement
		//Which method is performing user action - .perform method
		
		Thread.sleep(3000);
		
		//while using linkText method take the text which is visible on UI  not on the HTML DOM
	
		driver.findElement(By.linkText("COURSES")).click();
	}
	

}
