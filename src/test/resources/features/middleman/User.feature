Feature: Middleman Users

  @Capstone
  #Positive-TC1
  Scenario: Get User profile
    Given Get Single User profile
    When Send request get user profile
    Then Status code should be 200