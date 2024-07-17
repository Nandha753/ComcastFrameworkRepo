package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	
	public ContactInfoPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(className ="dvHeaderText")
	private WebElement HeaderMsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement contactTitleText;
	
	@FindBy(xpath="//span[@id='dtlview_Support Start Date']")
	private WebElement supStrtDate;
	
	@FindBy(xpath="//span[@id='dtlview_Support End Date']")
	private WebElement supEndDate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement mouseAreaorg;

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

	public WebElement getMouseAreaorg() {
		return mouseAreaorg;
	}

	public WebElement getContactTitleText() {
		return contactTitleText;
	}

	public WebElement getSupStrtDate() {
		return supStrtDate;
	}

	public WebElement getSupEndDate() {
		return supEndDate;
	}

	
	
}
