package SeleniumSessions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMapProductMetaDataAssignment {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil eutil = new ElementUtil(driver);
		By email = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		By searchBox = By.xpath("//input[@name='search']");
		By searchBtn = By.cssSelector("span.input-group-btn");
		By product = By.linkText("MacBook Pro");

		// search the product
		eutil.getElement(email).sendKeys("shraddha.goel10@gmail.com");
		eutil.getElement(password).sendKeys("Test@1234");
		eutil.getElement(login).click();
		eutil.getElement(searchBox).sendKeys("macbook");
		eutil.getElement(searchBtn).click();
		eutil.getElement(product).click();

		// product meta-data
		By name = By.xpath("//h1[text()='MacBook Pro']");
		By price = By.xpath("//h2[text()='$2,000.00']");
		By productValues = By.xpath("//h1[text()='MacBook Pro']/..//ul/li");

		String productName = eutil.getElement(name).getText();
		String productPrice = eutil.getElement(price).getText();
		List<WebElement> data = eutil.getElements(productValues);// get list of metadata
		Map<String, String> productMetaData = new HashMap<String, String>();
		for (int i = 0; i < data.size(); i++) { // iterate over data list
			if (data.get(i).getText().contains(":")) {
				String metadata[] = data.get(i).getText().split(":");
				String key = metadata[0].trim();
				String value = metadata[1].trim();
				productMetaData.put(key, value); // put it as key-value pair in hashMap
			}
		}
		productMetaData.put("Name", productName);
		productMetaData.put("Price", productPrice);

		for (Map.Entry<String, String> entry : productMetaData.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
