package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com"); //parent page
			driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();//child page
			
			//window handler API in Selenium:
			Set<String> handles = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<String>(handles);//converting set into arrayList
			//giving set<String> to the constructor of ArrayList
			String parentWindowId = handlesList.get(0);
			String childWindowId = handlesList.get(1);
			
			driver.switchTo().window(childWindowId);
			System.out.println(driver.getCurrentUrl());
			driver.close();
			
			driver.switchTo().window(parentWindowId);
			System.out.println(driver.getTitle());
			driver.quit();
	}
	
	public static void hkjhkj(){
		
	}

}
