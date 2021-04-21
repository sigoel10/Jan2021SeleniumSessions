package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choice = By.cssSelector(".comboTreeItemTitle");
		
		//tc1: single selection
//		selectChoice(choice, "choice 3");
		//if i want to select multiple dropdown values then i need to call this method multiple times
		//so instead of calling multiple times will maintain the an array in function to provide the values which need to be selected
		//to do this string... (string 3 dot parameter) can also be used as below
		//tc2: multi selection
		
		
//		List<WebElement>choiceList = 
//				driver.findElements(By.cssSelector(".comboTreeItemTitle"));
		/**
		 * below method is clicking on desired choice using for each loop
		 */
//		for (WebElement e : choiceList) {
//			String text = e.getText();
//			if (text.equals("choice 3")) {
//				e.click();
//				break;
//			}
//		}
		/**
		 * below method is used to click on the desired dropdown value using for loop
		 */
//		for (int i=0;i<=choiceList.size();i++) {
//			String text = choiceList.get(i).getText();
//			if (text.equals("choice 3")) {
//				choiceList.get(i).click();
//				break;
//			}
//		}
		//tc2: multi selection
//		selectChoice (choice,"choice 1","choice 2","choice 3");
		selectChoice (choice,"choice 7","choice 6 2 2","choice 6 2 1","choice 4","choice 2 3");
		
		//tc3: all selection
//		selectChoice (choice,"all");
		//if all is present in dropdown list then we need to change the identifier
		//we can use selectAll here in that case-just a unique identifier
	}
	
	public static List<WebElement> getElements (By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectChoice(By locator, String... value) { //here value will become an array list
		List<WebElement>choiceList = getElements(locator);
		
		if(!value[0].equalsIgnoreCase("all")) {
		for (int i=0;i<=choiceList.size();i++) {
			String text = choiceList.get(i).getText();
			System.out.println(text);
//			if (text.equals(value)) {
//				choiceList.get(i).click();
//				break;
//			}
			for (int j=0;j<value.length;j++) {
				if (text.equals(value[j])) {
					choiceList.get(i).click();//counter of choice list is i
					break;
				}
			}
		}
	}
		//select all the values
		//here we are getting exception because the size of choiceList is 45 but we have only 15 choices available in this dropdown
		//we will get element not intractable exception that's why using try catch
		else {
			try {
			for (WebElement e: choiceList) {
				e.click();
			}
			}catch (Exception e) {
			}
		}
	}
	

}
