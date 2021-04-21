package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
//first this will check the browser-browser version
//second it will check the driver.exe for this version
//if it's already available, no need to download just map it
//if its not available, download exe and then map
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
