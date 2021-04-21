package SeleniumSessions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUserWithHashMap {

	static WebDriver driver;
	public static void main(String[] args) {
		/**
		 * scenarios for HashMap--key value pair scenarios
		 * RBAC - role based access control - user permission based scenarios (customer, distributor, partner
		 * product data - meta data - <name: "macbook"> <price:"10"> <seller:"abc">
		 */
		//RBAC - customer, admin, categoryManager, seller, vendor, distributor
		//different types of login we need to maintain
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		doLogin("seller");
		doLogin("vendor");
		doLogin("customer");
		doLogin("distributor");
		/**
		 * Scenarios : we can test our application using different users.
		 * suppose seller has entered some price value or dispatching information and customer want to see it
		 * we have to login with customer id and need to verify if customer is able to see this or not
		 * we need to login logout and verify
		 */
		
	}
	
	//method to do login on the basis of given role
	public static void doLogin(String role) {
		String creds[] = getCredentialsMap(role).split(":");//splitting username and password
		System.out.println(creds[0]+ " : "+creds[1]);
		By email = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value = 'Login']");
		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(creds[0].trim());//here removing spaces
		
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(creds[1].trim());
		driver.findElement(login).click();
		
	}
	
	//create a HashMap for user data - different users for an application
	public static String getCredentialsMap(String role) {
		Map<String, String> credMap = new HashMap<String, String>();
		credMap.put("admin", "admin@g.com:admin123");
		credMap.put("seller","seller@g.com:seller123");
		credMap.put("vendor","vendor@g.com:vendor123");
		credMap.put("customer","customer@g.com:customer123");
		credMap.put("partner","parner@g.com:partner123");
		credMap.put("distributor","distributor@g.com:distributor123");
		
		if(credMap.containsKey(role)) {
			return credMap.get(role);
		}
		return null;
	}
}
