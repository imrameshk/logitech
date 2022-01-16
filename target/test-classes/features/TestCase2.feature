#TestCase-2
#Step 1 - Select Dynamic Loading the click "Example 2: Element rendered after the fact"
#Step 2 - Click Start
#Step 3 - Validate the progress bar
#Step 4 - Validate the final message once the progress gets complete. (Note: Avoid hard-coded wait)

@testcase2
Feature: Validate progress bar and final message

  @regression
  Scenario: Navigate to website and check progress bar and confirmation
    Given user logs into application
    Then click on Dynamic Loading link
    Then click on Example 2: Element rendered after the fact link
    Then click on start button
    Then validate the progress bar & verify final message