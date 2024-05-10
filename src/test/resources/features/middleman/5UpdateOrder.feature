Feature: Update Order

  @Capstone
  Scenario Outline: Update to confirm order with valid id
    Given Set path to confirm order with <ValidId>
    When Send request to confirm order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone
  Scenario Outline: Update to confirm order with invalid id
    Given Set path to confirm order invalid id with "<InvalidId>"
    When Send request to confirm order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwerty    |

  @Capstone
  Scenario Outline: Update to finish order with valid id
    Given Set path to finish order with <ValidId>
    When Send request to finish order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone
  Scenario Outline: Update to finish order with invalid id
    Given Set path to finish order invalid id with "<InvalidId>"
    When Send request to finish order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwerty    |