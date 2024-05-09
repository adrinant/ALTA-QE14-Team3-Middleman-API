Feature: Search product

  @Capstone
  Scenario Outline: Search product data with valid parameter
    Given Set parameter to "<Parameter>"
    When Send request to search
    Then Status code should be 200
    And Validate json schema "<JsonSchema>"
    Examples:
      | Parameter               | JsonSchema                   |
      | search?productname=Gula | SearchProductJsonSchema.json |

  @Capstone
  Scenario Outline: Search product data with invalid parameter
    Given Set parameter to "<Parameter>"
    When Send request to search
    Then Status code should be 404
    Examples:
      | Parameter                |
      | search?productname=12345 |