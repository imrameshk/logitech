#TestCase-6
#Step 1 - Select JavaScript Alerts
#Step 2 - Click on "Click for JS confirm"
#Step 3 - Cancel the alert
#Step 4 - Validate the alert canceled message

@testcase6
Feature: Javascript alert and cancel and validate message

  @regression
  Scenario: Perform action on Javascript alert and cancel and validate message
    Given user logs into application
    Then click on JavaScript Alerts link
    Then click on button
    Then cancel the alert
    Then validate the canceled message
    Then Take Screenshot TestCase6_Cancel_Message