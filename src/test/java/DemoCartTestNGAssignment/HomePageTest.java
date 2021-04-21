package DemoCartTestNGAssignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	@Test (priority = 1)
	public void demoCartHomePageMyAccountLabelTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
	}

	@Test (priority = 2)
	public void demoCartHomepageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
}
