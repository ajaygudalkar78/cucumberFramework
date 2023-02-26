package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;

import com.vtiger.pages.LeadPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leadsdefinitions extends BaseDefinitions {
	
	
	@When("user click on new lead link")
	public void user_click_on_new_lead_link() {
	  hp.clicknewlead();
	}
	
	
	@When("user enters lastname as {string} and company as {string} and click on save button")
	public void user_enters_lastname_as_and_company_as(String userid, String pwd) {
		 ldp = new LeadPage(driver,logger);
	     ldp.createLead(userid, pwd);
	}
	
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
	   
	}
	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}


}
