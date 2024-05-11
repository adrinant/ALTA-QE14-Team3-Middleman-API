Feature: Middleman Users

  #Example
  #Positive-TC1
  Scenario Outline: Login with valid user email and password
    Given   Login with valid JSON "<JSON>"
    When    User send request post login
    Then    Status code should be 200

    Examples:
      | JSON       |
      | Auth1.json |