package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title;").toString();
//		System.out.println(title);
		
		JavaScriptUtil jsutil = new JavaScriptUtil(driver);
		System.out.println(jsutil.getTitleByJS());
		
		//jsutil.refreshBrowserByJS();
		
		//jsutil.generateAlert("This is my JS");
		//usecase of js alert: while debugging the code, while giving the demo.
		
		//System.out.println(jsutil.getPageInnerText());
		//usecase - we can verify if the text is available on page or not instead of creating webelement and loop we can directly search
		//all the text present on screen.
		
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement loginSection = driver.findElement(By.cssSelector(".input-group"));
		
//		jsutil.drawBorder(login);
//		jsutil.drawBorder(loginSection);
		
		jsutil.flash(login);
		jsutil.flash(loginSection);
		
		jsutil.clickElementByJS(login);
		//usecase - if selenium is not able to click on this login button, selenium throw two types of exception-
		//element not interactable exception - because there could be some hidden element which is hiding the entire element (overlapping issue)
		//or window is minimized and button is shrinking
		//no such element exception
		//java script will directly go to dom and perform the action on dom only
		
//		jsutil.scrollPageUp();
//		jsutil.scrollPageDown();

		
		WebElement forgotPwd = driver.findElement(By.linkText("Forgot Password?"));
		jsutil.scrollIntoView(forgotPwd);
		forgotPwd.click();
		
		//scroll till particular height
		jsutil.scrollPageDown("100");
	}

}
