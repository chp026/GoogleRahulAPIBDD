Feature: Get information
  Scenario: getting information from the Rahul Shattey API Server
    Given user is on the base uri of Rahul Shattey
    When user provides path and query param to get information
    Then user should be able to see all the details from API Server