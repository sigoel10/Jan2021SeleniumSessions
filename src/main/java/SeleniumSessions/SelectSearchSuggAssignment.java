package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectSearchSuggAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		By searchBox = By.id("search_query_top");
		By searchList = By.xpath("//div[@class='ac_results']//li");
		By pageTitle = By.xpath("//*[@id='center_column']//h1");
		
		getElement(searchBox).sendKeys("dress");
		Thread.sleep(3000);
		selectSuggFromSearch(searchList, "T-shirts > Faded Short Sleeve T-shirts");
		System.out.println(getElement(pageTitle).getText());
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void selectSuggFromSearch(By locator, String searchText) {
		List<WebElement> dressList = getElements(locator);

		for (WebElement e : dressList) {
			String text = e.getText();
			if (text.equals(searchText)) {
				e.click();
				break;
			}
		}
	}
}
