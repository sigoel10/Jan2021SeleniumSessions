package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name;

	@Test(expectedExceptions = {NullPointerException.class,ArithmeticException.class})
	public void loginTest() {
		System.out.println("login test");
		 int i =9/0;
		
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		obj.name = "loginTest";
		System.out.println(obj.name);
		
		//this feature of testNG can be used while doing negative testing
		//means we are expecting the exception and test case should pass
		//while giving the demo, this feature can also be used.
		//we need to pass all the test cases for demo purpose, then 
		//we can write Exception.class
	}
}
