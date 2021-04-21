package SeleniumSessions;

public class AmazonAppTest {

	public static void main(String[] args) {

		BrowserUtil obj = new BrowserUtil();
		obj.init_driver("chrome");
		
		obj.launchUrl("http://www.amazon.com");
		String title = obj.getPageTitle();
		System.out.println("Page title is : "+title);
		
		if(title.contains("Online Shopping")) {
			System.out.println("Correct Title");
		}
		System.out.println(obj.getPageUrl());
		obj.closeBrowser();
		
	}

}
