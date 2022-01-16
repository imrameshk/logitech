#TestCase-5
#Step 1 - Select Frames then click iFrame
#Step 2 - Clear the predefined text and Enter some text
#Step 3 - Apply Bold style for the newly entered text
#Step 4 - Take the screenshot of the same

@testcase5
Feature: Select Frame then apply style and then take screenshot

  @regression
  Scenario: Perform action with Frame then apply style and then take screenshot
    Given user logs into application
    Then click on Frames link
    Then click on iFrame link
    Then clear text and enter Testing Scenario and apply bold style to text
    Then Take Screenshot TestCase5_Text_Style