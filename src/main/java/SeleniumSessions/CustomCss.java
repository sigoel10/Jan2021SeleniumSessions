package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCss {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		By loc1 = By.className("form-control private-form__control login-email");
//		By loc2 = By.xpath("form-control private-form__control login-email");
//		By.loc3 = By.cssSelector(".form-control.private-form__control.login-email");
//		By.loc4 = By.className(".login-email");
		driver.get("");
		List<WebElement> formList = driver
				.findElements(By.cssSelector("input#username, input#password, button#loginBtn, input#remember"));
		if (formList.size() == 4) {
			System.out.println("All elements are present on the page...");
			// check if elements are displayed or not
			for (WebElement e : formList) {
				System.out.println(e.isDisplayed());
			}
		}
	}

}
