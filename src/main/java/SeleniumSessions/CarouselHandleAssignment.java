package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandleAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
//print all the items in carousel
		String carousel_xpath = "//span[starts-with(normalize-space(),'Today’s Deals')]/../parent::div/following-sibling::div//a[contains(@class,'feed-right')]";
//		driver.findElements(By.xpath(xpath));
	}

}
