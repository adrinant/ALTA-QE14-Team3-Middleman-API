Feature: Middleman Users
  User can get, update & delete user in Middleman API

  @Capstone @User
  #Positive
  Scenario: Get User Profile
    Given Get Single User profile
    When Send request get user profile
    Then Status code should be 200

  @Capstone @User
  #Positive
  Scenario: Update User Profile with valid body
    Given Put update a user profile with valid json "2PutUpdateValid.json"
    When Send request to put update cart
    Then Status code should be 200
    And Validate json schema "PutUpdateUserJsonSchema.json"

  @Capstone @User
  #Negative
  Scenario: Update User Profile with invalid body
    Given Put update a user profile with valid json "2PutUpdateInvalid.json"
    When Send request to put update cart
    Then Status code should be 400

  @Capstone @User
  #Positive
  Scenario: Delete User
    Given Delete user profile
    When Send request delete user
    Then Status code should be 200