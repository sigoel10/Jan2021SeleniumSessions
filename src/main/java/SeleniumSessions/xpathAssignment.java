package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathAssignment {
	static WebDriver driver;

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://crmpro.com/index.html");
		
		List<WebElement> langLinks = driver.findElements(By.xpath("//ul[@class='list-unstyled']/li/a"));
		for (WebElement e: langLinks) {
			System.out.println(e.getText());
		}
	}

}
