Feature: Get Carts

  @Capstone
  Scenario: Get carts with valid path
    Given Set path for carts
    When Send request to get carts
    Then Status code should be 200