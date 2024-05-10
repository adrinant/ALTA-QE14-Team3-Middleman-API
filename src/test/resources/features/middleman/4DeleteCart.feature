Feature: Delete Cart

  @Capstone
  Scenario Outline: Delete cart with valid id
    Given Set carts id with <id>
    When Send request to delete cart
    Then Status code should be 204
    Examples:
      | id |
      | 4  |

  @Capstone
  Scenario Outline: Delete cart with invalid id
    Given Set carts invalid id with "<InvalidId>"
    When Send request to delete cart
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwe       |