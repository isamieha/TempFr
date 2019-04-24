@regression
Feature:Log in to Amazon application

  @smoke
  Scenario: Amazon Title verification and checking the orders count
    When user goes to amazon application
    Then user should see proper title
    And user logs in to amazon
    And user clicks on Orders tab
    Then print the order count