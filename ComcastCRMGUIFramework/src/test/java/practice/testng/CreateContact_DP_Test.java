package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider = "getData")
	public void createcontactTest(String firstname, String lastName,long phoneNumber) {
		System.out.println("firstname : "+firstname+"lastName"+lastName+"phoneNumber"+phoneNumber);
	}
	@DataProvider
	public Object[][]getData(){
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="Nandha";
		objArr[0][1]="Kumar";
		objArr[0][2]=987654321;
		
		objArr[1][0]="John";
		objArr[1][1]="Antony";
		objArr[1][2]=85296374;
		
		objArr[2][0]="Nithish";
		objArr[2][1]="Kumar";
		objArr[2][2]=74185296;
		return objArr;
	}
}
