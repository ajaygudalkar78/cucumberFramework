@allrun
Feature: Login functionality

Background:
Given user should be on login page

@regression
Scenario: valid_login_TC01
When user enters valid userid and password
And clicks on login button
Then user should be navigated to home page
And user can see logout link on home page
And close browser


@test @sanity 
Scenario: Invalid_login_TC02
When user enters invalid userid and password
And clicks on login button
Then user should be navigated to login page
And user can see error message
And close browser





