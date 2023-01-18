Feature: Check the login functionalities

  Background:
    Given User should be on login page with "url"

  Scenario: User login with valid cridentials
    When user enter "username" , "password" and click the submit button
    Then user shoul be on the home page

    Scenario: User adds and removes players and guests
      When user add new player and guests from Willow Pass
      And user starts the game
      And user finishes the game
      And user checks the waiting list is not empty
      And user remove the all players from waiting list
      Then user checks the waiting list is empty
