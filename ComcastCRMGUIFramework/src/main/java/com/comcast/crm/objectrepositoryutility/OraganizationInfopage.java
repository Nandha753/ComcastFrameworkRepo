package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationInfopage {
	
	WebDriver driver;
	public OraganizationInfopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy (className = "dvHeaderText")
private WebElement headerMsg;

@FindBy (id="dtlview_Industry")
private WebElement IndMsg;

@FindBy (id="dtlview_Type")
private WebElement typeMsg;

@FindBy (id="dtlview_Phone")
private WebElement phoneMsg;

public WebElement getHeaderMsg() {
	return headerMsg;
}

public WebElement getIndMsg() {
	return IndMsg;
}

public WebElement getTypeMsg() {
	return typeMsg;
}

public WebElement getPhoneMsg() {
	return phoneMsg;
}


}
