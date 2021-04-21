package SeleniumSessions;
//we need to add selenium dependency in pom.xml file (selenium-maven-dependency)
//while creating the project select archetype as "maven-archetype-quickstart" 1.4
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//first we need to add dependency for WebDriverManager in pom.xml file
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Indra Goel
 *
 */
public class BrowserUtil {
	
	WebDriver driver; //this is class variable default value of class variable is null
	//so we don't need to write null here java will take default value
	//when we write a method then we need to initialize the variable. for class variables java take default values by itself.
	
	/**
	 * This method is used to initialize the WebDriver on the basis of given BrowserName
	 * @param browserName
	 * @return this method returns the driver
	 */
	
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser name is : " + browserName);
		
		switch (browserName) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indra Goel\\Documents\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Indra Goel\\Documents\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;	
		default:
			System.out.println("Please pass the correct browser "+browserName);
			break;

		}
		return driver;//this method is returning driver, so we need to write WebDriver instead of void
	}
	/**
	 * This method is to launch url
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
