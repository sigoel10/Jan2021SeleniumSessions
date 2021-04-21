package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableAssignment {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/bangladesh-in-nz-2020-21-1233967/new-zealand-vs-bangladesh-2nd-odi-1233977/full-scorecard");
		
		getbowlerScoreCard("Trent Boult");
		getbowlerScoreCard("Matt Henry");
	}
	
	public static void getbowlerScoreCard(String bowlerName) {
		List<WebElement>bowlerScore = 
				driver.findElements(By.xpath("//a[text()='"+bowlerName+"']/parent::td/following-sibling::td"));
		for (WebElement e: bowlerScore) {
			String score = e.getText();
			System.out.print(score + " ");
		}
		System.out.println(" ");
	}

}
