package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	//dependency between multiple test cases is good idea or not? 
	// it's not recommended
	//test cases should be independent - TC should be separate
	// test case should be written for a specific feature
	// test case should have only one or max two assertions
	//multi assertions -- you can have soft assertions - for single features
	//ex - login feature: username , pwd, login button is displayed or not ---3 soft assertions
	//labels name verification is also soft assertion example
	 
	
	@Test
	public void loginTest() {
		System.out.println("login test");
		int i =9/0;
	}

	@Test (dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home test");
	}

	@Test (dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("search test");
	}
	
//if login test will get pass then only homeTest and searchTest will get executed
}
