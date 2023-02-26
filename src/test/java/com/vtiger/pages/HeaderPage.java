package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class HeaderPage {
	
	public WebDriver driver;
	public ExtentTest logger;
	public CommonActions ca;
		
		public HeaderPage(WebDriver driver,ExtentTest logger)
		{
			this.driver = driver;
			this.logger=logger;
			PageFactory.initElements(driver, this);
			ca = new CommonActions(driver,logger);
		}
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="New Lead")
	WebElement newlead;
	
	@FindBy(linkText="Leads")
	WebElement leads;
	
	@FindBy(linkText="New Account")
	WebElement newaccount;
	
	public void clicknewaccount()
	{		
		ca.ClickElement(newaccount, "New Account link clicked");
	}
	
	public void clicknewlead()
	{		
		ca.ClickElement(newlead, "New Lead link clicked");
	}
	
	public void clickLeads()
	{		
		ca.ClickElement(leads, "Leads link clicked");
	}
	
	public void clickLogout()
	{		
		ca.ClickElement(logout, "Logout link clicked");
	}
	
	public void verifyLogout()
	{
		ca.ElementExist(logout, "Logout link exist on page");

	}

}
