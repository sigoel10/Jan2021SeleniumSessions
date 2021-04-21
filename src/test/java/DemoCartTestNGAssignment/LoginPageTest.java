package DemoCartTestNGAssignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	
	//@Test(priority = 1)
	public void demoCartTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}

	@Test(priority = 2)
	public void demoCartYourStoreLableTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Your Store")).isDisplayed());
	}

	@Test(priority = 3)
	public void demoCartLoginTest() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());

	}
}
