#1. Create booking - Derive appropriate values from the response and log on to the report
#
#2. Get booking - Derive appropriate values from the response and log on to the report
#
#3. Update booking - Derive appropriate values from the response and log on to the report
#
#4. Delete booking - Derive appropriate values from the response and log on to the report

@fail
Feature: Create, Get, Update and Delete Booking - Fail Scenario

  @apiregression
  Scenario: Create Booking and derive appropriate values from the response and log on to the report - Fail Scenario
    Given Create Booking
    Then Get Booking
    Then Update Booking
    And Delete Booking