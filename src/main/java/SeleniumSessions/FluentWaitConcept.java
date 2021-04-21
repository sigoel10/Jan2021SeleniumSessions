package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		//WebDriverWait (c) --> FluentWait (c) ---> Wait(I) --->until(M)
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By username = By.name("username");
		
		waitForElementWithFluentWait(username, 10, 500).sendKeys("batchautomation");;
		
		
	}
	
	public static WebElement waitForElementWithFluentWait(By locator , int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait <WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))//interval time freq = 5 times (default polling time = 500 millisec)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
//note - FluentWait works for other type of WebElements also.

	/**
	 * Fluent Wait for Alerts
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */
	public static Alert waitForAlertWithFluentWait(int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait <WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))//interval time freq = 5 times (default polling time = 500 millisec)
				.ignoring(NoAlertPresentException.class);
				
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * Fluent Wait for Frames - An expectation for checking whether the given frame is available to switch to. If the frame is available it switches the given driver to the specified frame.
	 * @param timeOut
	 * @param pollingTime
	 * @return 
	 */
	public static WebDriver waitForFrameWithFluentWait(String frameLocator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait <WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))//interval time freq = 5 times (default polling time = 500 millisec)
				.ignoring(NoSuchFrameException.class);
				
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
}
