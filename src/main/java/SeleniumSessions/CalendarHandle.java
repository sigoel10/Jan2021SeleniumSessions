package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000);
//		selectDate("25");
		By calender = By.cssSelector("table.ui-datepicker-calendar a");
//		selectDate(calender, "12");
//		selectDate("10", "a");

//	pseudo code for selecting future month year date in calendar	
//		currentMonthYear = dispay monthYear text
//				while(!(currentMonth == expMonth && currentYear == expYear))
//					click next icon
//			call selectDate(date) method
		
//		selectCalendarFutureDate("16", "October", "2023");
		selectCalendarBackDate("10", "January", "2021");
		
	}

//simplest way of handing calendar, if text is available in the form of a
	public static void selectDate(String day, String htmlTag) {
		driver.findElement(By.xpath("//" + htmlTag + "[text()='" + day + "']")).click();
	}

	public static void selectDate(By locator, String day) {
		// 2nd way of handling calender-capture all dates in list and iterate till the
		// desired one
		List<WebElement> daysList = driver.findElements(locator);
		System.out.println(daysList.size());

		for (WebElement e : daysList) {
			if (e.getText().equals(day)) {
				e.click();
				break;
			}
		}

	}

	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	public static void selectCalendarFutureDate(String exDay, String exMonth, String exYear) {
		if (exMonth.equals("February") && Integer.parseInt(exDay) > 29) {
			System.out.println("wrong date: " + exMonth + " : " + exDay);
			return;
		}
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
//		System.out.println(monthYearVal); // April 2021
		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {
			System.out.println(monthYearVal);
			// click on next icon
			driver.findElement(By.xpath("//a[@title='Next']")).click();// current monthyear = May2021
			// update monthYear value
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		selectDate(exDay, "a");
	}
	public static void selectCalendarBackDate(String exDay, String exMonth, String exYear) {
		if (exMonth.equals("February") && Integer.parseInt(exDay) > 29) {
			System.out.println("wrong date: " + exMonth + " : " + exDay);
			return;
		}
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
//		System.out.println(monthYearVal); // April 2021
		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {
			System.out.println(monthYearVal);
			// click on next icon
			driver.findElement(By.xpath("//a[@title='Prev']")).click();// current monthyear = May2021
			// update monthYear value
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		selectDate(exDay, "a");
	}
}
