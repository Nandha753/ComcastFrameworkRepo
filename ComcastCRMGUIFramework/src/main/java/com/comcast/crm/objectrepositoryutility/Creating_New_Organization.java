package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Creating_New_Organization {
	WebDriver driver;
	public Creating_New_Organization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name ="accountname")
	private WebElement orgNameEdt;
	
	@FindBy (name ="accounttype")
	private WebElement typeNameEdt;
	
	@FindBy (xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (name ="industry")
	private WebElement industryDb;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getphoneEdt() {
		return phoneEdt;
	}
	public WebElement getindustryDb() {
		return industryDb;
	}
	public WebElement gettypeNameEdt() {
		return typeNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName,String Industries,String type) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDb);
		sel.selectByVisibleText(Industries);
		Select sel1 = new Select(typeNameEdt);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	public void createOrg(String orgName,String Phone) {
		orgNameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(Phone);
		saveBtn.click();
	}
}

