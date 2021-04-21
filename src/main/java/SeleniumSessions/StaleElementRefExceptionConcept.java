package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By username = By.name("username");//v1
		
		WebElement user_ele = driver.findElement(username);//v1
		user_ele.sendKeys("batchautomation");//v1
		
		Thread.sleep(3000);
		
		//refreshing the page
		driver.navigate().refresh();
		//again entering the username
		user_ele = driver.findElement(username);
		user_ele.sendKeys("batchautomation");//v2 - here we are getting stale element exception
		
		/*Before refreshing dom version is -v1
		 * reason: html dom got updated after refreshing the page
		 * after refreshing the page we got new version of dom - v2
		 * so here we need to create the element again
		 * when we create a webelement, selenium internally gives one unique webelement ID to each element when we write driver.find element
		 * and this id will be maintained for all the operations throughout the session
		 * when page gets refresh, html dom gets refresh and webelement id gets change and v1 id gets deprecated or expired or staled
		 * thats why we get stale element reference exception
		 * so we again need to  create the webelement
		 * 
		 * which locator strategy we should use - everytime we need to create the by locator
		 * and creayte the webelement everytime
		 * 
		 * what are the chances that html dom gets updated/loaded - on refresh, on back & forward, ajax component
		 */
		
	}

}
