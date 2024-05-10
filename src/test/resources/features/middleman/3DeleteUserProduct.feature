Feature: Delete user product

  @Capstone
  Scenario Outline: Delete product with valid id
    Given Set id with <id>
    When Send request to delete
    Then Status code should be 204
    Examples:
      | id |  |
      | 14 |  |

  @Capstone
  Scenario Outline: Delete product with invalid id
    Given Set invalid id with "<id>"
    When Send request to delete
    Then Status code should be 204
    Examples:
      | id  |
      | qwe |