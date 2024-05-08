Feature: Middleman Users

  @Capstone
  #Positive-TC1
  Scenario Outline: Login with valid user email and password
    Given   Login with valid JSON "<JSON>"
    When    User Send request post login
    Then    Status code should be 200

    Examples:
      | JSON       |
      | Auth1.json |

  @Capstone
  Scenario Outline: Login with valid user email and password admin
    Given   Login with valid JSON "<JSON>"
    When    User Send request post login admin
    Then    Status code should be 200

    Examples:
      | JSON       |
      | Auth2.json |