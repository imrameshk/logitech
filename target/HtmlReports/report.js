$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TestCase7.feature");
formatter.feature({
  "name": "Create, Get, Update and Delete Booking",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.scenario({
  "name": "Create Booking and derive appropriate values from the response and log on to the report",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@api"
    },
    {
      "name": "@apiregression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Create Booking",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.createBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get Booking",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.getBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am an authorized user",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.iAmAnAuthorizedUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Update Booking",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.updateBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Delete Booking",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.deleteBooking()"
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
formatter.uri("file:src/test/resources/features/TestCase7_failure.feature");
formatter.feature({
  "name": "Create, Get, Update and Delete Booking - Fail Scenario",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@fail"
    }
  ]
});
formatter.scenario({
  "name": "Create Booking and derive appropriate values from the response and log on to the report - Fail Scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@fail"
    },
    {
      "name": "@apiregression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Create Booking",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.createBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get Booking",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.getBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Update Booking",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.updateBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Delete Booking",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.ApiStepDefinitions.deleteBooking()"
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