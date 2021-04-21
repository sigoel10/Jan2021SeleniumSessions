package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlAndTitle {
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://www.freshworks.com/");
		
		System.out.println(waitForTitleContains(10, "customer"));
		if (waitForUrl(5, "freshworks")) {
			System.out.println("url is correct");
		}
		
		//waitForTitle(10, "Account Login");
		//waitForTitle(10, "Account Login11");
		/**
		 * here we deliberately made title wrong
		 * here we are getting error as - tried for 10 second(s) with 500 milliseconds interval)
		 *  by default - internal polling time is 500 milliseconds in selenium means every .5 secs
		 *  it will try to search the title till 10 secs
		 */
	}
 
	public static String waitForTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle(); 
	}
	
	public static String waitForTitleContains(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle(); 
	}
	
	public static String waitForTitle(int timeOut, String title, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle(); 
	}
	
	public static boolean waitForUrl(int timeOut, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}
}