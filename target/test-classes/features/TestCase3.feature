#TestCase-3
#Step 1 - Select Multiple Windows
#Step 2 - Click on "Click Here"
#Step 3 - Log the URL of the newly opened tab
#Step 4 - Close the newly opened tab
#Step 5 - Log the title of the current page

@testcase3
Feature: Switch tab then close and log URL

  @regression
  Scenario: Switch to tab then log URL and close and then log current page URL
    Given user logs into application
    Then click on Multiple Windows link
    Then click on Click Here link
    Then Log the URL of new tab and close it
    Then Log the title of the current page