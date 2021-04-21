package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indra Goel\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//launch browser
	
		driver.get("https://www.google.com");//enter the url
		
		String title = driver.getTitle();//get the title
		System.out.println("Page title is: " + title);
		
		if (title.equals("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		String url = driver.getCurrentUrl();//get the browser current url
		System.out.println(url);
		
		//driver.quit();
		driver.close();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

}
