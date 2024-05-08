Feature: Get Order

  @Capstone
  Scenario: Get all history order by user
    Given Set path for order by user
    When Send request to get order
    Then Status code should be 200

  @Capstone
  Scenario Outline: Get detail order with valid id
    Given Set path for detail order with <ValidId>
    When Send request to get detail order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone
  Scenario Outline: Get detail order with invalid id
    Given Set path for detail order invalid id with "<InvalidId>"
    When Send request to get detail order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwe       |

  @Capstone
  Scenario: Get all history order by admin
    Given Set path for all history order by admin
    When Send request to get all history order
    Then Status code should be 200

  @Capstone
  Scenario: Get incoming order from user
    Given Set path for incoming order
    When Send request to get incoming order
    Then Status code should be 200