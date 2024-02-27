Feature: login functionality

Scenario Outline: login with valid credentials
Given user navigates to login page
When user enters a valid email <username> in the email field
And user enters a valid password <password> in the password field
And user clicks the login button
Then user should successfully log in
Examples: 
|username      |password|
|sjsf1@test.com|abcde   |
|sjsf2@test.com|abcde   |
|sjsf3@test.com|abcde   |

Scenario: login with invalid credentials
Given user navigates to login page
When user enters a invalid email in the email field
And user enters a invalid password "abcdeaa" in the password field
And user clicks the login button
Then user should get a warning message


Scenario: login with valid email and invalid password
Given user navigates to login page
When user enters a valid email "sjsf1@test.com" in the email field
And user enters a invalid password "abcdeaa" in the password field
And user clicks the login button
Then user should get a warning message


Scenario: login with invalid email and valid password
Given user navigates to login page
When user enters a invalid email in the email field
And user enters a valid password "abcde" in the password field
And user clicks the login button
Then user should get a warning message

Scenario: login without providing any credentials
Given user navigates to login page
When user does not enter email in the email field
And user does not enter password in the password field
And user clicks the login button
Then user should get a warning message
