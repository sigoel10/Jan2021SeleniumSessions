package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		//gecko driver - it is provided by mozilla
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Indra Goel\\Documents\\geckodriver.exe");
	
		WebDriver driver = new FirefoxDriver();//launch browser
	
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
