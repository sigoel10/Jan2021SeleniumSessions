package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriWindowHandleAssignment {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Set<String> handle = driver.getWindowHandles();
		Iterator<String>it = handle.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent Window ID : " + parentWindowId);
		
		while(it.hasNext()) {
		String childWindowId = it.next();
		closeChildWindows(childWindowId);
		}
		driver.switchTo().window(parentWindowId);
	}
	
	public static void closeChildWindows(String childWindowId) {
		driver.switchTo().window(childWindowId);
		System.out.println("child window url : " + driver.getCurrentUrl());
		driver.close();
	}

}
