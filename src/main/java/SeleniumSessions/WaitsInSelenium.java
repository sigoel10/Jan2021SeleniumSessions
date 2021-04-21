package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsInSelenium {

	public static void main(String[] args) {
/**
 * 1. Static wait - Thread.sleep - 10---wait is constant
 * 2. dynamic wait - timeout is dynamic
 * 		a) Implicitly wait
 * 		b) Explicit wait
 * 			b.1) WebDriverWait
 * 			b.2) FluentWait
 * 				both are classes; WebDriver wait is child of FluentWait and both implement Wait interface
 * 				WebDriverWait extends FluentWait
 * 				implementing Wait interface
 * 
 * 	Implicitly wait:
 * 		is a global wait
 * 		only for web Elements
 * 		not applicable for non web elements (Alert, url, title)
 * 		FE/FEs - by default implicit wait will be applied
 * 		It will be applied after driver initialization
 * 
 * 
 */
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("groupautomat3ion");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		/**
		 * here we have created 3 web elements, 
		 * global wait or implicit wait of 10 secs will be applied to all 3 web elements
		 * Problem with implicit wait - after login we are landing on home page and on home page we have assumed 3 more elements
		 * and then we move on contacts page and here we deal with assume 3 more elements
		 * so implicit wait will be applied for all these web elements till the driver is there.
		 * why are we unnecessary using wait for all the web elements because once the page is loaded, all the elements will be available in 0 secs
		 * 
		 */
		
		//homepage: 5 secs
		//here we can overwrite our imlicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//
		//e3 - 5secs
		//e4 - 0secs
		//e5 - 0sec
		
		//contacts page:here if i dont want any implicit wait - nullify implicit wait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//e6
		//e7
		//e8
		//e9 - logout
		//loginpage: again land on login page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//e1 e2 e3 - will take 5 sec here because we implicit wait is overwritten
		
		/**
		 * so its a tedious job to maintain implicit wait again and again
		 * defining it for login page then nullify it and the overwriting it for another page
		 * or if we don't nullify or overwrite it then it will be applied globally to all the web elements
		 * it will make application slow and script performance will be degraded
		 * in framework we should never use implicit wait
		 * because it is applied globally and after driver initialization
		 * another thing is - it is not applicable for non web elements
		 */
	
	}

}
