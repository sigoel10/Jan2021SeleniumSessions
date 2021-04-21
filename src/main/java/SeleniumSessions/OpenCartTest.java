package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		
		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "test");
		eleUtil.doSendKeys(password, "test123");
		
		System.out.println(br.getPageTitle());
		
		By registerLink = By.linkText("Register");
	//	By userName = By.id("input-username");
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By telephone = By.id("input-telephone");
		By pwdConfirm = By.id("input-confirm");
		
		
		
		eleUtil.doClick(registerLink);
		//eleUtil.doSendKeys(userName, "sigoel");
		eleUtil.doSendKeys(firstName, "Shraddha");
		eleUtil.doSendKeys(lastName, "Goel");
		eleUtil.doSendKeys(emailId, "sigoel@gmail.com");
		eleUtil.doSendKeys(telephone, "123456156");
		eleUtil.doSendKeys(password, "test123");
		eleUtil.doSendKeys(pwdConfirm, "test123");
		driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]/input")).click();
		//another xpath for radio button: //label[normalize-space()='Yes']
		
		//br.closeBrowser();
		
	}

}
