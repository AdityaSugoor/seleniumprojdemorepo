Feature: Application Login

Scenario: Login with valid credentials 
Given Open any Browser
And Navigate to Login page 
When User enters username as "aditya.123@gmail.com" and password as "@Pass01word" into the fields
And User clicks on the login button
Then Verify user is able to successfully login 

