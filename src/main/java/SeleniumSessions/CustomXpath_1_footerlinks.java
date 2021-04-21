package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath_1_footerlinks {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

//		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
//		System.out.println(footerList.size());
//		
//		for(WebElement e:footerList) {
//			System.out.println(e.getText());
//		}

		int columnCount = driver.findElements(By.xpath("//ul[@class='footer-nav']")).size();
		System.out.println(columnCount);
		List<String> colValList = new ArrayList<String>();
		for (int i = 1; i <= columnCount; i++) {
			List<WebElement> freshWorksColumnLinks = driver
					.findElements(By.xpath("(//ul[@class='footer-nav'])[" + i + "]/li/a"));
			//here we are appending the xpath with the variable part--i if any more column is introduced in between, 
			//then it will capture any column
			for (WebElement e : freshWorksColumnLinks) {
				colValList.add(e.getText());
			}
		}
		System.out.println(colValList);
	}

}
