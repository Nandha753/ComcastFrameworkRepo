package com.comcast.crm.orgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.OraganizationInfopage;
import com.comcast.crm.objectrepositoryutility.Organizationspage;
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class CreateOrgtest extends BaseClass {
	@Test(groups = "Smoke Testing")
	public void CreateOrganizationtest() throws Throwable {
		
        //Read the Common data from Excel file
       String OrgName=elib.getDataFromExcel("Org", 1, 2)+jlib.getRandomNumber();
       
            //step 1 : login into App 
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
	}
	@Test(groups = "Regression Testing")
	public void createorgwithind () throws Throwable {
		
        	//Read the Common data from Excel file
			String OrgName=elib.getDataFromExcel("Org", 4, 2)+jlib.getRandomNumber();
			String Industries=elib.getDataFromExcel("Org", 4, 3);
			String type = elib.getDataFromExcel("Org", 4, 4);
		 	//step 1 : login into App 
        	Homepage hp = new Homepage(driver);
        	hp.getOrglink().click();
            Organizationspage cnp = new Organizationspage(driver);
            cnp.getCreateNewOrgBtn().click();
        	//step 2 : Select the Industry from the Dropdown
        	Creating_New_Organization cno = new Creating_New_Organization(driver);
        	cno.createOrg(OrgName, Industries, type);            
            //Verify the Industries and type Expected Result
        	OraganizationInfopage oip = new OraganizationInfopage(driver);
        	String actIndustry = oip.getIndMsg().getText();
            if(actIndustry.equals(Industries)) {
            	System.out.println(Industries + " Dropdown is verified==PASS");
            }else {
            	System.out.println(Industries + " Dropdown is not verified==FAIL");
            }
            
            //Verify drop-down2 Expected Result
            String acttype=oip.getTypeMsg().getText();
            if(acttype.equals(type)) {
            	System.out.println(type + " Dropdown is verified==PASS");
            }else {
            	System.out.println(type + " Dropdown is not verified==PASS");
            }
            
	}
	@Test(groups = "Regression Testing")
	public void createorgwithphone () throws Throwable {
        
        //Read the Common data from Excel file
		String OrgName=elib.getDataFromExcel("Org", 7, 2)+jlib.getRandomNumber();
		String Phone=elib.getDataFromExcel("Org", 7, 3);
		//step 1 : login into App 
    	Homepage hp = new Homepage(driver);
    	hp.getOrglink().click();
        Organizationspage cnp = new Organizationspage(driver);
        cnp.getCreateNewOrgBtn().click();
    	//step 2 : Select the Industry from the Dropdown
    	Creating_New_Organization cno = new Creating_New_Organization(driver);
    	cno.createOrg(OrgName, Phone);
    	OraganizationInfopage oip = new OraganizationInfopage(driver);
    	String actphone =oip.getPhoneMsg().getText();
            //verify Header OrgName info Expected Result
            if(actphone.equals(Phone)) {
            	System.out.println(Phone + " PhoneNumber is Created ==PASS");
            }else {
            	System.out.println(Phone + " PhoneNumber is not Created  ==FAIL");
            }
	}

}
