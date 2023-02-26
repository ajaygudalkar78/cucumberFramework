package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logindefinitions extends BaseDefinitions {
	public Scenario scenario;
	
	@Before
	public void getScenario(Scenario scenario)
	{
		if(extent==null)
		{
		createReport();
		}
		this.scenario=scenario;
		TCName = this.scenario.getName();
		System.out.println(TCName);
		logger = extent.createTest(TCName);
		
	}
	
	@After
	public void savereport()
	{
		extent.flush();
	}
	
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		init();
		 lp = new LoginPage(driver,logger);
		 hp = new HomePage(driver,logger);
	}

	@When("user enters valid userid and password")
	public void user_enters_valid_userid_and_password() {
	   
	    lp.EnterUseridPwd(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
	}
	
	@When("user enters invalid userid and password")
	public void user_enters_invalid_userid_and_password() {
		lp.EnterUseridPwd(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		lp.ClickLogin();
	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	    driver.findElement(By.linkText("Home123")).isDisplayed();
	}

	@Then("user can see logout link on home page")
	public void user_can_see_logout_link_on_home_page() {
		
		hp.verifyPipeline();
	}
	
	@Then("user should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
		lp.verifyLogo();
	}
	@Then("user can see error message")
	public void user_can_see_error_message() {
	    lp.verifyErrorMsg();
	}


}
