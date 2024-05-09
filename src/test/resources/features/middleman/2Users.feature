Feature: Middleman Users

  @Capstone2
  #Positive-TC1
  Scenario: Get User Profile
    Given Get Single User profile
    When Send request get user profile
    Then Status code should be 200

  @Capstone2
  #Positive-TC2
  Scenario: Update User Profile with valid body
    Given Put update a user profile with valid json "PutUpdateUserProfileValid.json"
    When Send request to put update cart
    Then Status code should be 200
    And Validate json schema "PutUpdateUserProfileValidSchema.json"


  @Capstone2
  #Negative-TC1
  Scenario: Update User Profile with invalid body
    Given Put update a user profile with valid json "PutUpdateUserProfileInvalid.json"
    When Send request to put update cart
    Then Status code should be 400
