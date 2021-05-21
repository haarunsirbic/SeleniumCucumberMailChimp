Feature: Create account

  Scenario Outline: Validate that account creation is working
    Given Browser is open
    And user is on account creation page
    When user is typing <email> <username> password
    Then closes browser and session

    
    Examples:
    | email | username |
    | testkonto@gmail.com | Testare |
    | test123@gmail.com | 123 |
    | usernametaken@gmail.com | z |
    |  | Testare |