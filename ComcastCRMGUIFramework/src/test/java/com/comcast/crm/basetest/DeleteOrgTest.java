package com.comcast.crm.basetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.Loginpage;
import com.comcast.crm.objectrepositoryutility.OraganizationInfopage;
import com.comcast.crm.objectrepositoryutility.Organizationspage;

public class DeleteOrgTest {
	@Test
	public void Deleteorg() throws Throwable {
	FileUtility fLib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
    
    String BROWSER = fLib.getDataFromPropertiesFile("browser");
    String URL = fLib.getDataFromPropertiesFile("url");
    String USERNAME = fLib.getDataFromPropertiesFile("username");
    String PASSWORD = fLib.getDataFromPropertiesFile("password");
    
    //Read the Common data from Excel file
   String OrgName=elib.getDataFromExcel("Org", 10, 2)+jlib.getRandomNumber();
   
    WebDriver driver = null;
        if (BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equals("edge")) {
            driver = new EdgeDriver();
        }
        //step 1 : login into App
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(URL);
        Loginpage lp = new Loginpage(driver);
        lp.loginToapp(USERNAME,PASSWORD, URL);
        //step 2 : navigate to Organization Button 
        Homepage hp = new Homepage(driver);
        hp.getOrglink().click();
        //step 3 : click on "create Organisation" Button
        Organizationspage cnp = new Organizationspage(driver);
        cnp.getCreateNewOrgBtn().click();
        //step 4 : enter all the details & create new Organisation
        Creating_New_Organization cnop = new Creating_New_Organization(driver);
        cnop.createOrg(OrgName);
        //verify Header msg Expected Result
        OraganizationInfopage oip = new OraganizationInfopage(driver);
        String actOrgName = oip.getHeaderMsg().getText();
        //verify Header orgName info Expected Result
        if(actOrgName.contains(OrgName)) {
        	System.out.println(OrgName+"name is Verified ==PASS");
        }else {
        	System.out.println(OrgName+"name is not Verified ==FAIL");
        }
        
        //go back to Organizations Page
        hp.getOrglink().click();
        //Search for Organization
        cnp.getSearchEdt().sendKeys(OrgName);
        wLib.select(cnp.getSearchDD(),"Organization Name");
        cnp.getSearchBtn().click();
        
        //In dynamic Webtable select & delete org
        driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../../td[8]/a[text()='del']")).click();
        wLib.SwitchtoAlertAndAccept(driver);
        //step 5 : logout
       hp.logout();
       driver.quit();
	}

}
