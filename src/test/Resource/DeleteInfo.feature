Feature: Deleting information
  Scenario: Removing information from database
    Given user is on the base uri rahul shattey API
    When user searches specific placeID and remove information
    Then user should be able to see successful message for deleting information