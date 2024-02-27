Feature: Registration Functionality

Scenario: user creates an acccount only with madatory fields
Given user navigates to Register page
When user enters the details into below fields
|firstName|abc|
|lastName|xyz|
|email|sjsj11@test.com|
|telephone|963852741|
|password|abcde|
And user selects privacy policy
And user clicks continue button
Then user account should get created successfully


Scenario: user creates an acccount with all fields
Given user navigates to Register page
When user enters the details into below fields
|firstName|abc|
|lastName|xyz|
|email|sjsj12@test.com|
|telephone|963852741|
|password|abcde|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks continue button
Then user account should get created successfully


Scenario: user creates a duplicate account
Given user navigates to Register page
When user enters the details into below fields
|firstName|abc|
|lastName|xyz|
|email|sjsj12@test.com|
|telephone|963852741|
|password|abcde|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks continue button
Then user should get proper warning about duplicate email



Scenario: user creates an account without filling any details
Given user navigates to Register page
When user does not enter any details into fields
And user clicks continue button
Then user should get proper warning message for every mandatory field