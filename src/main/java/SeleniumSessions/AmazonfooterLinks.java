package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonfooterLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> footer1List = driver.findElements(By.cssSelector(".navFooterVerticalRow.navAccessibility a"));
		for (int i=0; i<footer1List.size();i++) {
			String footer1TextValue = footer1List.get(i).getText();
			System.out.println(i +"---->"+footer1TextValue);
		}
		
		
		List<WebElement>footer2List = driver.findElements(By.xpath("//*[@id='navFooter']/div[4]/ul/li/a"));
		for (WebElement e : footer2List) {
			String footer2TextValue = e.getText();
			System.out.println(footer2TextValue+" ");
		}
		
		List<WebElement>footer3List = driver.findElements(By.cssSelector(".navFooterMoreOnAmazon a"));
		for (WebElement e : footer3List) {
			String footer3TextValue = e.getText();
			System.out.println(footer3TextValue + " " );
		}
		
		List<WebElement>footer4List = driver.findElements(By.cssSelector(".navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright a"));
		for (WebElement e : footer4List) {
			String footer4TextValue = e.getText();
			System.out.println(footer4TextValue);
		}
	}

}
