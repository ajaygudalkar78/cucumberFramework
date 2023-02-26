package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class AccountPage extends HeaderPage {

	public AccountPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name="accountname")
	WebElement accountname;
	
	
	@FindBy(name="button")
	WebElement save;
	
	public void createAccount(String acc)
	{
		ca.EnterValue(accountname, acc, acc+" has been entered into accountname field");
		ca.ClickElement(save, "Save button clicked");
	}
	
}
