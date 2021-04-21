package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_2 {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		selectContact("Devisha Sharma");
		System.out.println(getCompName("Devisha Sharma"));
		
		List<String> Info = getContactInfo("Devisha Sharma");
		for(String e: Info) {
			System.out.print(e+" ");
		}
	}
	
	public static void selectContact(String name) {
		String xpath = "//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static String getCompName(String name) {
		String xpath = "//a[text()='"+name+"']/parent::td/following-sibling::td/a";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String getPhoneNumber(String name) {
		String xpath = "(//a[text()='"+name+"']/parent::td/following-sibling::td/span)[1]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String getHomePhoneNumber(String name) {
		String xpath = "(//a[text()='"+name+"']/parent::td/following-sibling::td/span)[2]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String getMobileNumber(String name) {
		String xpath = "(//a[text()='"+name+"']/parent::td/following-sibling::td/span)[3]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String getEmail(String name) {
		String xpath = "(//a[text()='"+name+"']/parent::td/following-sibling::td/a)[2]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	/**
	 * input:name
	 * return : the list of all the information right side: phone email company
	 */
	public static List<String> getContactInfo(String name) {
		String compName = getCompName(name);
		String ph = getPhoneNumber(name);
		String homePh = getHomePhoneNumber(name);
		String mobilePh = getMobileNumber(name);
		String email = getEmail(name);
		
		List<String> contactInfoList = new ArrayList<String>();
		contactInfoList.add(compName);
		contactInfoList.add(ph);
		contactInfoList.add(homePh);
		contactInfoList.add(mobilePh);
		contactInfoList.add(email);
		
		return contactInfoList;
	}
}
