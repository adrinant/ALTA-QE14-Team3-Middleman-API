Feature: Get user products

  @Capstone
  Scenario Outline: Get all user products
    Given Set path and token
    When Send request to get user products
    Then Status code should be 200
    And Validate json schema "<JsonSchema>"
    Examples:
      | JsonSchema                       |
      | GetAllUserProductJsonSchema.json |