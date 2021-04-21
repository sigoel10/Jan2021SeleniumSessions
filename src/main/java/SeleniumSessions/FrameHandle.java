package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);//switching to a frame using index
		//driver.switchTo().frame("main");//switching to frame using frame name
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
		WebElement header = driver.findElement(By.xpath("/html/body/h2"));
		System.out.println(header.getText());
		
		driver.switchTo().defaultContent();//returning to main page
		
		driver.switchTo().parentFrame();
	}

}
