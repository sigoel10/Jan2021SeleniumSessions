package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeqVsParallelStreams {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//REQ: capture all the links available
		
		List<WebElement>linksList = driver.findElements(By.tagName("a"));
		//Sequential Stream:
//		long startTime = System.currentTimeMillis();
//		linksList.stream().filter(ele -> !ele.getText().isEmpty())
//							.forEach(ele -> System.out.println(ele.getText()));
//		long endTime = System.currentTimeMillis();
//		
//		System.out.println("Time taken: "+ (endTime - startTime)); 
		//Seq Stream: Time taken: 8277ms = 8.3 sec
		
		//Parallel Stream:
		
		long startTime = System.currentTimeMillis();
		linksList.parallelStream().filter(ele -> !ele.getText().isEmpty())
									.forEach(ele -> System.out.println(ele.getText()));
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken: "+ (endTime - startTime));
		
		//Parallel Stream: Time Taken: 7755ms - 7.8 sec
		
		//if we have data-more than 10K, then use parallel stream otherwise use seq stream only
		//parallel stream doesn't maintain order and computing on the elements happen together
		
		
		//Ques - how will you improve when you have number of data in your list which is coming in the form of list
		//how will you improve performance
		//If we have 200-300 elements, we can use the concept of streams here and fiter it out on the basis of what we want
		//we can exclude blank text or unnecessary text then we can apply parallel stream on this
		//Ques - Tell the difference between sequential stream and parallel stream?
		//
		
	}

}
