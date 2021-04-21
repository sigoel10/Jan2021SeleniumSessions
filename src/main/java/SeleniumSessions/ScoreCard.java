package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScoreCard {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/bangladesh-in-nz-2020-21-1233967/new-zealand-vs-bangladesh-2nd-odi-1233977/full-scorecard");
		
		System.out.println(getWicketTakerName("Tamim Iqbal"));
		System.out.println(getWicketTakerName("Liton Das"));
		
		List<String> scoreList = getPlayerScoreCard("Tamim Iqbal");
		System.out.println(scoreList);
		
	}
	
	public static String getWicketTakerName(String playerName) {
		String xpath = "//a[contains(text(),'"+playerName+"')]/parent::td/following-sibling::td/span";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> getPlayerScoreCard(String playerName) {
		List<String> scoreValueList = new ArrayList<String>();
		List<WebElement>scoreList = 
				driver.findElements(By.xpath("//a[text()='"+playerName+"']//parent::td/following-sibling::td"));
		for (int i=1;i<scoreList.size();i++) {
			String score = scoreList.get(i).getText();
			if (!score.isEmpty()) {
				scoreValueList.add(score);
			}
		}
		return scoreValueList;
	}
}
