package SeleniumSessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsPractice {

	public static void main(String[] args) {
		/**
		 * Streams were introduced in JDK 8
		 * Streams is available in the form of Fuctional Interface - It means we can do some functional programmimg
		method of chaining, perform some operation on data, filter the list etc
		streams can be applied on the collections - ArrayLisy, set
		Streams cannot be directly applied on Arrays, arrays need to be converted
		into arrayList then streams can be applied
		 */
		
		//launch amazon ---> get all the links text --> no blank text
		//capture only those links starting with amazon or having amazon text in it
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.amazon.in/");
//		
//		List<WebElement>linksList = driver.findElements(By.tagName("a"));
//		//now iterate the list with the help of streams
//		
//	List<String> amazonLinksList =	linksList
//										.stream()
//											.filter(ele -> !ele.getText().isEmpty())
//												.filter(ele -> ele.getText().contains("Amazon"))
//													.map(ele -> ele.getText())
//														.collect(Collectors.toList());
//	
//	amazonLinksList.stream().forEach(ele -> System.out.println(ele));
	/**
	 * Above applied stream is sequential stream - means it will maintain the order 
	 * order in which we store the values in the list, same order will be maintained in streams as well
	 * Parallel Stream - doesn't maintain order, 
	 * All the values will be stored in parallel
	 * So in terms of performance - parallel stream is faster
	 */
	//create a random list and appy stream on this list --->capture only those names working with IBM
	
	List<String> namesList = new ArrayList<String>();
	namesList.add("Tom IBM");
	namesList.add("Peter CTS");
	namesList.add("Lisa IBM");
	namesList.add("Steve Infosys");
	namesList.add("Naveen abc");
	namesList.add("Amita IBM");
	
	
	namesList.stream().filter(ele -> ele.contains("IBM")).forEach(ele -> System.out.println(ele));
	
	
	//applying streams on array
	int num [] = {10, 2, 3, 4, 78, 55, 18, 19, 21};
	Arrays.stream(num).filter(ele->ele%2==0).forEach(ele->System.out.print("Even numbers: "+ele+" "));
	Arrays.stream(num).filter(ele->ele%2!=0).forEach(ele->System.out.println("Odd numbers: "+ele+" "));
	
	//we cannot apply stream on numbers so we have to convert static array into list
	Arrays.asList(num).stream()
							.forEach(ele -> System.out.println(ele+""));

	//if we dont have any source - random number generation
	IntStream.range(1, 100).filter(ele -> ele%2==0).forEach(ele -> System.out.println(ele));
	IntStream.range(1, 100).filter(ele -> ele%2==1).forEach(ele -> System.out.println(ele));
	
	}

}
