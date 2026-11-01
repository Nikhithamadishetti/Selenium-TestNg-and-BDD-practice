Feature: Login

Scenario: Successful Login with valid redentials
Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/V1/index.php"
And User enters username as "mngr668935" and Password as "vyresAr"
And click on submit
Then Page title should be "GTPL Bank Manager HomePage"
Then close browser