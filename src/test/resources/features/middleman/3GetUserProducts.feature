Feature: Get user products

  @Capstone
  Scenario: Get all user products
    Given Set path and token
    When Send request to get user products
    Then Status code should be 200