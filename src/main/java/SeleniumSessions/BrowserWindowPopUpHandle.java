package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowPopUpHandle {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		driver = br.init_driver("chrome");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com"); //parent page
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();//child page
		
		//window handler API in Selenium:
		Set<String> handles = driver.getWindowHandles();
		//Set cannot store duplicate values but arrayList can store
		//Set is not order based it doesn't maintain indexing whereas arrayList is orderbased
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();//it will move driver to next element means parent window in the iteration
		System.out.println("Parent Window ID : " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child Window ID: " + childWindowId);
		
//		driver.switchTo().window(childWindowId);
//		System.out.println("child window url :" + driver.getCurrentUrl());
//		
//		driver.close();//closing the browser where my driver control is and driver lost here
		switchToWindowAndGetTitle(childWindowId);
		br.closeBrowser();
		switchToWindowAndGetTitle(parentWindowId);
//		driver.switchTo().window(parentWindowId);
//		System.out.println("parent window url: "+driver.getCurrentUrl());
//		System.out.println("parent window Title: "+driver.getTitle());
		
//		driver.quit();
		
	}
	public static String switchToWindowAndGetTitle(String WindowId) {
		driver.switchTo().window(WindowId);
		String title = driver.getTitle();
		return title;
	}
	
}
