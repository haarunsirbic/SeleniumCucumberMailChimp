Feature: Create account

  Scenario Outline: Validate that account creation is working
    Given Browser is open
    And user is on account creation page
    And user is typing <email> <username> password
    When presses sign up
    Then user is navigated to check your email page

    
    Examples:
    | email | username |
    | testkonto@gmail.com | Testare |
    | test123@gmail.com | randomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandomrandom |
    | usernametaken@gmail.com | z |
    |  | Testare |