Feature: Register

  @Capstone
  Scenario: Register with valid data
    Given Set request body with valid data enetered with json "ValidDataRegisterBody.json"
    When Send request to register
    Then Status code should be 201

  @Capstone
  Scenario: Register with invalid data
    Given Set request body with invalid data enetered with json "InvalidDataRegisterBody.json"
    When Send request to register
    Then Status code should be 400