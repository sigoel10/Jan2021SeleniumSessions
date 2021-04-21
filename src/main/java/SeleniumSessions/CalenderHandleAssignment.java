package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandleAssignment {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://www.goibibo.com/");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		//selecting current month date
//		driver.findElement(By.id("departureCalendar")).click();
//		selectDate("6", "div");
		
		//selecting future month date
		String currentMonthYear = driver.findElement(By.xpath("//div[text()='April 2021']")).getText();
		String monthYear[] = currentMonthYear.split(" ");
		System.out.println("currentMonth = "+monthYear[0]);
		System.out.println("currentYear = "+monthYear[1]);
		String currentMonth = monthYear[0];
		String currentYear = monthYear[1];
		
		while (!(currentMonth == "June" && currentYear == "2022")) {
			driver.findElement(By.xpath("//span[contains(@class,'DayPicker-NavButton--next')]")).click();
		}
		selectDate("15", "div");
//		pseudo code for selecting future month year date in calendar	
//		currentMonthYear = dispay monthYear text
//				while(!(currentMonth == expMonth && currentYear == expYear))
//					click next icon
//			call selectDate(date) method
		
	}
	public static void selectDate(String day, String htmlTag) {
		driver.findElement(By.xpath("//"+htmlTag+"[text()='" + day + "']")).click();
	}
}
