Feature: Middleman Admin

  @Capstone6Admin
  #Positive-TC1
  Scenario Outline: Login with valid user email and password
    Given   Login with valid JSON "<JSON>"
    When    User Send request post login
    Then    Status code should be 200

    Examples:
      | JSON       |
      | Auth2.json |
