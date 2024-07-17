package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
		WebDriver driver;
		public Homepage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(linkText="Products")
		private WebElement productlink;
		
		@FindBy(linkText="Organizations")
		private WebElement Orglink;
		
		@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
		private WebElement contactlink;
		
		@FindBy(linkText="Campaigns")
		private WebElement Campaignlnk;
		
		@FindBy(linkText="More")
		private WebElement morelink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminimg;
		
		@FindBy(linkText="Sign Out")
		private WebElement sigNOutLnk;
		
		public WebElement getproductlink() {
			return productlink;
		}
		
		public WebElement getOrglink() {
			return Orglink;
		}

		public WebElement getContactlink() {
			return contactlink;
		}

		public WebElement getCampaignlnk() {
			return Campaignlnk;
		}

		public WebElement getMorelink() {
			return morelink;
		}

		public void navigateToCampaignPage() {
			Actions act = new Actions(driver);
			act.moveToElement(morelink).perform();
			Campaignlnk.click();
		}
		public void logout() {
			// TODO Auto-generated method stub
			Actions action = new Actions(driver);
			action.moveToElement(adminimg).perform();
			sigNOutLnk.click();
		}
}
