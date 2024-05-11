Feature: Middleman Users
  User can register & login to Middleman API

  #Positive
  @Capstone @Login @Test
  Scenario Outline: Login with valid user email and password
    Given   Login with valid JSON "<JSON>"
    When    User send request post login
    Then    Status code should be 200
    And     Validate json schema "<JsonSchema>"

    Examples:
      | JSON            | JsonSchema                  |
      | 1UserLogin.json | LoginSuccessJsonSchema.json |

  #Positive
  @Capstone @Login @Test
  Scenario Outline: Login with valid user email and password admin
    Given   Login with valid JSON "<JSON>"
    When    User send request post login admin
    Then    Status code should be 200
    And     Validate json schema "<JsonSchema>"

    Examples:
      | JSON             | JsonSchema                  |
      | 1AdminLogin.json | LoginSuccessJsonSchema.json |

  #Negative
  @Capstone @Login
  Scenario: Login with invalid email and password
    Given Set request body with invalid email and password entered with json "1InvalidLogin.json"
    When Send request to login
    Then Status code should be 400

  #Positive
  @Capstone @Register
  Scenario: Register with valid data
    Given Set request body with valid data entered with json "1ValidRegister.json"
    When Send request to register
    Then Status code should be 201
    And  Validate json schema "RegisterSuccessJsonSchema.json"

  #Negative
  @Capstone @Register
  Scenario: Register with invalid data
    Given Set request body with invalid data entered with json "1InvalidRegister.json"
    When Send request to register
    Then Status code should be 400