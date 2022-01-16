#TestCase-1
#Step 1 - Launch the site then click on Form Authentication
#Step 2 - Get the username and password from the given text and store them in an external file.
#Step 3 - Read that username and password from the external file and log in with those credentials
#Step 4 - Validate the login success.
#Step 5 - Enter any invalid credentials and validate the failure scenario as well.

@testcase1failure
Feature: Test Successful and Unssuccessful Logins - Failure

  @regression
  Scenario: Navigate to website then retrieve credentials and check login - Failure
    Given user logs into application failure
    Then click on Form Authentication link
    Then retrieve credentials and store to file
    Then read json and login
    Then validate login success and logout
    Then validate login failure