Feature: Check the login functionality and verify informations

  Background:
    Given User should be on login page with

  @wip
  Scenario: User login with valid cridentials and verify informations
    When user logs in and verify user lands on the home page
    And user clicks the IPC menu, searches keyword on the name box and clicks first action button
    And user clicks the JOB and  clicks the Select from work order
    And user clicks the Select From List button
    And user searches keyword on the ORder Reference No box and choses random row
    And user clicks the continue buton
    And user saves the informations on the list, clicks tha start button and verify Success message
    And user clicks the Active Job Information and saves the expected informations
    And user verifies actual and expected informations are equal
    And user clicks the X button
    And user clicks job,cliks Finish the Job and confirm
    Then user verifies Active Job Information is unable


