package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name="button123")
	WebElement save;
	
	public void createLead(String lname,String comp)
	{
		ca.EnterValue(lastname, lname, lname+" has been entered into lastname field");
		ca.EnterValue(company, comp, comp+" has been entered into company field");
		ca.ClickElement(save, "Save button clicked");
	}
	

}
