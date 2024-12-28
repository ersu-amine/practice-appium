@wip
Feature: As a user I should be able to search any keyword

  Scenario: User should be able to search
    Given user is on the google homepage
    And user searches for "coffee"
    Then user should see relevant results for "coffee"