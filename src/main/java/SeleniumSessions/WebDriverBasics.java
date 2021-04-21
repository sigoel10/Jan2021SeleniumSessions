package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indra Goel\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//launch browser
		//driver is reference variable
		//object is --- new ChromeDriver()
		//child class object is referred by parent interface reference variable
		//this is top-casting/ up-casting
	
		driver.get("https://www.google.com");//enter the url
		
		//if remove https:// - invalid argument exception - its compulsory to write
		//if remove www - it will automatically take www
		//but good practice is to write complete url of the application
		
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
		
		System.out.println(driver.getPageSource());
		driver.quit();
	}

}
