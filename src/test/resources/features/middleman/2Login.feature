Feature: Login
  @Capstone
  Scenario:Login with valid email and password for user
    Given Set request body with valid email and password entered with json "LoginValidEmailAndPasswordUserBody.json"
    When Send request to login
    Then Status code should be 200

  @Capstone
  Scenario: Login with invalid email and password
    Given Set request body with invalid email and password entered with json "LoginInvalidEmailAndPasswordBody.json"
    When Send request to login
    Then Status code should be 400

  @Capstone
  Scenario: Login with valid email and password for admin
    Given Set request body with valid email and password entered with json "LoginValidEmailAndPasswordAdminBody.json"
    When Send request to login
    Then Status code should be 200