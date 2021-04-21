package SeleniumSessions;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		String xpath = "//h3[text()='Health care essentials']/parent::div/../following-sibling::div//div[@data-qa='product-name']";
// h3[text()='Health care essentials']/parent::div/../following-sibling::div//div[@data-qa='product-name']

		List<WebElement> recommList = driver.findElements(By.xpath(xpath));
		System.out.println(recommList.size());
		Thread.sleep(2000);
		String next_xpath = "//h3[text()='Health care essentials']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]";

//		List<String> dataList = new ArrayList<String>();
		Set<String> dataSet = new TreeSet<String>();

		while (!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled")) {

			for (WebElement e : recommList) {

//				System.out.println(e.getText()); //here we are getting count as 35 but only 5 elements are printed
				String text = e.getText();
				if (!text.isEmpty()) {
//					dataList.add(text);
					dataSet.add(text);
				}
			}
			// on console because only 5 elements are visible on the screen
			// so we have to keep clicking on next button until the next button is
			// disappeared
			driver.findElement(By.xpath(next_xpath)).click();
		}
		// here we have used stream to print the list
		dataSet.stream().forEach(ele -> System.out.println(ele));

		// now my requirement is - print all the values in sorted order
		// so for this i will have to use TreeSet - data structure
		// properties of tree set are: TreeSet doesn't maintain the order like hash set
		// properties of TreeSet:
		// 1) it takes the unique values ignores duplicates and
		// 2) takes all the values in sorted order, it automatically sort the order of
		// the collection

	}
	/**
	 * learning from this example: 
	 * creating generic xpath
	 * using while loop
	 * data structure - TreeSet
	 */
	
}
