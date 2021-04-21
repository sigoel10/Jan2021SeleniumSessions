package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithList {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		//go to the footer link, capture the text and click on it and click on next footer link
		List<WebElement> compList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		for (int i=0 ; i<compList.size(); i++) {
			System.out.println(compList.get(i).getText());
			compList.get(i).click();
			//after clicking on link dom is getting updated so here we again need to update the list
			compList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		}
		

	}

}
