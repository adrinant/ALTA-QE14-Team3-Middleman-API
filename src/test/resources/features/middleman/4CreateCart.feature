Feature: Create Cart

  @Capstone
  Scenario Outline: Create new cart with valid body
    Given Set request with valid data product_id "<product_id>" and qty "<qty>"
    When Send request to create cart
    Then Status code should be 201
    Examples:
      | product_id | qty |
      | 4          | 2   |

  @Capstone
  Scenario Outline:Create new cart with invalid body
    Given Set request with invalid data qty "<qty>"
    When Send request to create cart
    Then Status code should be 400
    Examples:
      | qty |
      | 0   |