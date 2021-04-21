package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementAssignment {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		By Login = By.id("ctl00_HyperLinkLogin");
		By SpiceClubMem = By.linkText("SpiceClub Members");
		By MemberLogin = By.linkText("Member Login");
		By SignUp = By.linkText("Sign up");
		By MemberLoginPageLogin = By.id("Login");
		
		doMoveToElement(Login);
		doMoveToElement(SpiceClubMem);
		Thread.sleep(5000);
		doMoveToElementAndClick(MemberLogin);
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		doMoveToElement(MemberLoginPageLogin);
		doMoveToElement(SpiceClubMem);
		Thread.sleep(5000);
		doMoveToElementAndClick(SignUp);
		System.out.println(driver.getCurrentUrl());
	}
	
	public static WebElement getElement(By locator) {
		return(driver.findElement(locator));
	}
	public static void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		WebElement content = getElement(locator);
		act.moveToElement(content).perform();
	}
	public static void doMoveToElementAndClick(By locator) {
		doMoveToElement(locator);
		getElement(locator).click();
	}
}
