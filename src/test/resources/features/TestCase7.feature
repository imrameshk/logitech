#1. Create booking - Derive appropriate values from the response and log on to the report
#
#2. Get booking - Derive appropriate values from the response and log on to the report
#
#3. Update booking - Derive appropriate values from the response and log on to the report
#
#4. Delete booking - Derive appropriate values from the response and log on to the report

@api
Feature: Create, Get, Update and Delete Booking

  @apiregression
  Scenario: Create Booking and derive appropriate values from the response and log on to the report
    Given Create Booking
    Then Get Booking
    And I am an authorized user
    Then Update Booking
    And Delete Booking