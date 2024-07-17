package Practicetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test (dataProvider = "getData")
	public void getProductInfoTest(String brandname, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String x ="(//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a//span[@class='a-price-whole'])[1]";
	WebElement price = driver.findElement(By.xpath(x));
	String a =price.getText();
	System.out.println(a);
	
	driver.quit();
	}
	@DataProvider
	public Object[][]getData() throws Throwable{
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("product");
		
		Object[][] objArr = new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
		objArr[i][0]=eLib.getDataFromExcel("product", i+1, 0);
		objArr[i][1]=eLib.getDataFromExcel("product", i+1, 1);
		}
		return objArr;
	}
}
