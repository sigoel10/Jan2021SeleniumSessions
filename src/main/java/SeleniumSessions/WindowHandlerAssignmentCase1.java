package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerAssignmentCase1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		By twitterLink = By.xpath("//img[@alt='OrangeHRM on twitter']");
		By linkedInLink = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By facebookLink = By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By youtubeLink = By.xpath("//img[@alt='OrangeHRM on youtube']");

		driver.get("https://opensource-demo.orangehrmlive.com");// Parent window
		Thread.sleep(3000);
		getElement(twitterLink).click();// twitter window
		getElement(linkedInLink).click();// linkedIn window
		getElement(facebookLink).click();// facebook window
		getElement(youtubeLink).click();// youtube window

		Set<String> windowIds = driver.getWindowHandles();
		List<String> windowIdsList = new ArrayList<String>(windowIds);
		String parentWindowId = windowIdsList.get(0);
		String twitterWindowId = windowIdsList.get(1);
		String linkedInWindowId = windowIdsList.get(2);
		String facebookWindowId = windowIdsList.get(3);
		String youtubeWindowId = windowIdsList.get(4);

		switchWindow(twitterWindowId);// switching to twitter
		switchWindow(linkedInWindowId);// switching to linkedIn
		switchWindow(facebookWindowId);// switching to Facebook
		switchWindow(youtubeWindowId);// switching to youtube
		switchWindow(parentWindowId);//switching to mainWindow
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void switchWindow(String WindowId) {
		driver.switchTo().window(WindowId);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
}
