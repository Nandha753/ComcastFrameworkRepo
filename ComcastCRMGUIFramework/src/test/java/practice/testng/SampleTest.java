package practice.testng;

import org.testng.annotations.Test;

public class SampleTest {
	@Test ( invocationCount = 10)
	public void createcontactTest() {
		System.out.println("execute createContactTest");
	}
	@Test( enabled = false)
	public void modifycontactTest() {
		System.out.println("execute modifycontactTest");
	}
	@Test( enabled = false)
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest");
	}
	
}
