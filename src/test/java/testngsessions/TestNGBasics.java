package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	/**
	 * BS - createUserInDB
		BT - giveUserPermission
		BC - OPen the browser and launch App
		
			BM - loginto app
				Add To Cart Test --T1
			AM - logout
			
			BM - loginto app
				SearchProductTest --T2
			AM - logout
			
			BM - loginto app
				appLogoTest --T3
			AM - logout
			
		AC - close Browser
		AT - delete the user
		AS - Close DB Connection
	 */
	@BeforeSuite
	public void createUserInDB() {
		System.out.println("BS - createUserInDB");
	}

	@BeforeTest
	public void giveUserPermission() {
		System.out.println("BT - giveUserPermission");
	}

	@BeforeClass
	public void launchApp() {
		System.out.println("BC - OPen the browser and launch App");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM - login to app");
	}

	@Test
	public void appLogoTest() {
		System.out.println("appLogoTest");
	}

	@Test
	public void SearchProductTest() {
		System.out.println("SearchProductTest");
	}

	@Test
	public void AddToCartTest() {
		System.out.println("Add To Cart Test");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM - logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - close Browser");
	}
	
	@AfterTest
	public void deleteTheUser() {
		System.out.println("AT - delete the user");
	}
	
	@AfterSuite
	public void closeDBConnection() {
		System.out.println("AS - Close DB Connection");
	}
}
