package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class LoginPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	public CommonActions ca;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		ca = new CommonActions(driver,logger);
		
	}
	
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//*[contains(text(),'123You must specify a valid username and password.')]")
	WebElement ErrorMsg;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	
	//By username = By.name("user_name123");
	//By password = By.name("user_password");
	//By login = By.name("Login");
	
	public void login(String userid, String pwd)
	{
		ca.EnterValue(username, userid,userid+" has been entered in username field");
		ca.EnterValue(password, pwd,pwd+" has been entered in password field");	
		ca.ClickElement(login,"Login button clicked");		
	}
	
	public void EnterUseridPwd(String userid, String pwd)
	{
		ca.EnterValue(username, userid,userid+" has been entered in username field");
		ca.EnterValue(password, pwd,pwd+" has been entered in password field");	
		
	}
	
	public void ClickLogin()
	{
		ca.ClickElement(login,"Login button clicked");		
	}
	
	
	public void verifyErrorMsg()
	{
		ca.ElementExist(ErrorMsg,"Error message has been validated successfully");
	}
	
	public void verifyLogo()
	{
		ca.ElementExist(logo,"Logo exist on the login page");
	}
	
	
	

}
