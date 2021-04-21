package DemoCartTestNGAssignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

	@Test (priority = 2)
	public void demoCartSearchPageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Search - imac");
	}

	@Test (priority = 1)
	public void searchFeatureTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("imac");
		driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//img[@title='iMac']")).isDisplayed());
	}
}
