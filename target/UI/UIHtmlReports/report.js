$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TestCase1.feature");
formatter.feature({
  "name": "Test Successful and Unssuccessful Logins",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase1"
    }
  ]
});
formatter.scenario({
  "name": "Navigate to website then retrieve credentials and check login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase1"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Form Authentication link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "retrieve credentials and store to file",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.retrieveAndStore()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "read json and login",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.returnAndLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate login success and logout",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateLoginSuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate login failure",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateFailure()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase1_Failure.feature");
formatter.feature({
  "name": "Test Successful and Unssuccessful Logins - Failure",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase1failure"
    }
  ]
});
formatter.scenario({
  "name": "Navigate to website then retrieve credentials and check login - Failure",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase1failure"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application failure",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplicationFailure()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003cThe Internet[]\u003e but was:\u003cThe Internet[1]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat stepDefinitions.StepDefinition.loginApplicationFailure(StepDefinition.java:89)\r\n\tat ✽.user logs into application failure(file:///C:/Users/ACER/Desktop/Ramesh/src/test/resources/features/TestCase1_Failure.feature:13)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on Form Authentication link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "retrieve credentials and store to file",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.retrieveAndStore()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "read json and login",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.returnAndLogin()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "validate login success and logout",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateLoginSuccess()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "validate login failure",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateFailure()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase2.feature");
formatter.feature({
  "name": "Validate progress bar and final message",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase2"
    }
  ]
});
formatter.scenario({
  "name": "Navigate to website and check progress bar and confirmation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase2"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Dynamic Loading link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Example 2: Element rendered after the fact link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on start button",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickButton(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the progress bar \u0026 verify final message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateProgressBar()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase3.feature");
formatter.feature({
  "name": "Switch tab then close and log URL",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase3"
    }
  ]
});
formatter.scenario({
  "name": "Switch to tab then log URL and close and then log current page URL",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase3"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Multiple Windows link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Click Here link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Log the URL of new tab and close it",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.geturlAndClose()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Log the title of the current page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.getURL()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase4.feature");
formatter.feature({
  "name": "Drag and Drop and then take screenshot",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase4"
    }
  ]
});
formatter.scenario({
  "name": "Perform Drag and Drop and then take screenshot",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase4"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Drag and Drop link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Drag box A and drop it into B and validate success",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.DragDrop()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take Screenshot TestCase4_Drag_Drop",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.screenshot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase5.feature");
formatter.feature({
  "name": "Select Frame then apply style and then take screenshot",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase5"
    }
  ]
});
formatter.scenario({
  "name": "Perform action with Frame then apply style and then take screenshot",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase5"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Frames link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on iFrame link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clear text and enter Testing Scenario and apply bold style to text",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clearEnterText(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take Screenshot TestCase5_Text_Style",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.screenshot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/TestCase6.feature");
formatter.feature({
  "name": "Javascript alert and cancel and validate message",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@testcase6"
    }
  ]
});
formatter.scenario({
  "name": "Perform action on Javascript alert and cancel and validate message",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testcase6"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.loginApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on JavaScript Alerts link",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on button",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.clickbuttonJS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "cancel the alert",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.cancelAlert()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the canceled message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.validateCancelMsg()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take Screenshot TestCase6_Cancel_Message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinition.screenshot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});