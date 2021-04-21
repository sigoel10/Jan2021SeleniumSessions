package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) {
		WebDriver driver = null;
		String browser = "firefox";
		
		/*if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indra Goel\\Documents\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Indra Goel\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equals("safari")) {
			//for safari browser we don't need to maintain .exe file selenium will do it intenally
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please pass the correct browser");
		}
		*/
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indra Goel\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Indra Goel\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;	
		default:
			System.out.println("Please pass the correct browser");
			break;
		}
		
		driver.get("https://www.google.com");//enter the url
		
		String title = driver.getTitle();//get the title
		System.out.println("Page title is: " + title);
		
		//verification/checkpoint : actual vs expected
		if (title.equals("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		String url = driver.getCurrentUrl();//get the browser current url
		System.out.println(url);
		
		driver.quit();
	}

}
