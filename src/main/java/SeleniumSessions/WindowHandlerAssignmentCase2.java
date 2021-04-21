package SeleniumSessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerAssignmentCase2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
//twitter
		By twitterLink = By.xpath("//img[@alt='OrangeHRM on twitter']");
		List<String> Id_tw = captureWindowsIDsByArrayList(twitterLink);
		String Parent = Id_tw.get(0);
		String twitterID = Id_tw.get(1);
		SwitchingWindows(Parent, twitterID);
//linkedIn
		By linkedInLink = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		List<String> Id_lin = captureWindowsIDsByArrayList(linkedInLink);
		String LinkedInID = Id_lin.get(1);
		SwitchingWindows(Parent, LinkedInID);
//Facebook
		By facebookLink = By.xpath("//img[@alt='OrangeHRM on Facebook']");
		List<String> Id_fb = captureWindowsIDsByArrayList(facebookLink);
		String facebookID = Id_fb.get(1);
		SwitchingWindows(Parent, facebookID);
//youtube
		By youtubeLink = By.xpath("//img[@alt='OrangeHRM on youtube']");
		List<String> Id_yt = captureWindowsIDsByArrayList(youtubeLink);
		String youtubeID = Id_yt.get(1);
		SwitchingWindows(Parent, youtubeID);
	}

	public static List<String> captureWindowsIDsBySet(By childLocator) throws InterruptedException {

		driver.findElement(childLocator).click();
		Thread.sleep(3000);
		// capturing main Window ID
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String mainWndow = it.next();
		System.out.println("Main Window ID: " + mainWndow);

		// capturing child window ID
		String childWindowId = it.next();
		System.out.println("Child window ID: " + childWindowId);

		List<String> WindowIds = new ArrayList<String>();
		WindowIds.add(mainWndow);
		WindowIds.add(childWindowId);
		return WindowIds;
	}

	public static List<String> captureWindowsIDsByArrayList(By childLocator) throws InterruptedException {

		driver.findElement(childLocator).click();
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(handles);

		String parendWindowId = handleList.get(0);
		String childWindowId = handleList.get(1);

		List<String> WindowIds = new ArrayList<String>();
		WindowIds.add(parendWindowId);
		WindowIds.add(childWindowId);
		return WindowIds;
	}

	public static void SwitchingWindows(String parentID, String childID) {
		driver.switchTo().window(childID);
		System.out.println("Child window title: " + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		// switching to main window
		driver.switchTo().window(parentID);
		System.out.println("Main Window title: " + driver.getTitle());
	}
}
