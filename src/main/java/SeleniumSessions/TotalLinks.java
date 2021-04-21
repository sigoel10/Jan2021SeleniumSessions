package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;
	public static void main(String[] args) {
//		•	Find total links on the page
//		•	get the text of each link
//		•	html tag<a>

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		//list is super interface of Arraylist; behaves like and array list
		//list is dynamic
		
		By links = By.tagName("a");
		List<WebElement> linksList = getElements(links);
		System.out.println("Total links : " +linksList.size());
		//give the text of each link
		
//		for (int i=0;i<linksList.size();i++) {
//			String linkText = linksList.get(i).getText();
//			
//			//there are some blank links available on the page
//			//now remove the blank links print only those links text which are not blank
//			
//			if (!linkText.isEmpty()) {
//			//now print the links with their index value
//			System.out.println(i + "--->" + linkText);}
//			
//			//find total no of images on the page
//			
//			//find the link's navigation url--href value gives the navigation urel link
//			for (WebElement e:linksList) {
//				String hrefValue = e.getAttribute("href");
//				System.out.println(hrefValue);
//			}
//		}
		List<String> linksTextList = getElementsTextList(links);
		for(String e : linksTextList) {
			System.out.println(e);
		}
	}

	public static List<WebElement> getElements (By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getElementsTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		
		List<WebElement>eleList = getElements(locator);
		for(WebElement e : eleList) {
		if (!e.getText().isEmpty()) {
		eleTextList.add(e.getText());}
	}
		return eleTextList;
	}
	
}
