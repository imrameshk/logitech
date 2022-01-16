#TestCase-4
#Step 1 - Select Drag and Drop
#Step 2 - Drag box A and drop it into B
#Step 3 - Validate the drop success
#Step 4 - Take the screenshot of the same

@testcase4
Feature: Drag and Drop and then take screenshot

  @regression
  Scenario: Perform Drag and Drop and then take screenshot
    Given user logs into application
    Then click on Drag and Drop link
    Then Drag box A and drop it into B and validate success
    Then Take Screenshot TestCase4_Drag_Drop