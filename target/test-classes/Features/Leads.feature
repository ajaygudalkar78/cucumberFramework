Feature: Login functionality

Background:
Given user should be on login page
When user enters valid userid and password
And clicks on login button

Scenario Outline: Lead_Creation_TC03
When user click on new lead link
And user enters lastname as "<lastname>" and company as "<company>" and click on save button
Then lead should be created successfully
And close browser

Examples:
|lastname | company |
|Modi     | BJP     |
|Gandhi   | Congress|
|Thakre   | ShivSena|

