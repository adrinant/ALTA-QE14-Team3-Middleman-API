Feature: Create order
  User can manage order in Middleman API

  @Capstone @User @Order
  Scenario Outline: Create new order valid body
    Given Set request body to create order with "<ValidOrderData>"
    When Send request to create order
    Then Status code should be 201
    Examples:
      | ValidOrderData           |
      | 6ValidOrderDataBody.json |

  @Capstone @User @Order
  Scenario Outline: Create new order invalid body
    Given Set request body to create order with "<InvalidOrderData>"
    When Send request to create order
    Then Status code should be 400
    Examples:
      | InvalidOrderData           |
      | 6InvalidOrderDataBody.json |

  @Capstone @User @Order
  Scenario Outline: Get all history order by user
    Given Set path for order by user
    When Send request to get order
    Then Status code should be 200
    And Validate json schema "<JsonSchema>"
    Examples:
      | JsonSchema                              |
      | GetAllHistoryOrderByUserJsonSchema.json |

  @Capstone @User @Order
  Scenario Outline: Get detail order with valid id
    Given Set path for detail order with <ValidId>
    When Send request to get detail order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone @User @Order
  Scenario Outline: Get detail order with invalid id
    Given Set path for detail order invalid id with "<InvalidId>"
    When Send request to get detail order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwe       |

  @Capstone @User @Order
  Scenario Outline: Get all history order by admin
    Given Set path for all history order by admin
    When Send request to get all history order
    Then Status code should be 200
    And Validate json schema "<JsonSchema>"
    Examples:
      | JsonSchema                               |
      | GetAllHistoryOrderByAdminJsonSchema.json |

  @Capstone @User @Order
  Scenario: Get incoming order from user
    Given Set path for incoming order
    When Send request to get incoming order
    Then Status code should be 200

  @Capstone @User @Order
  Scenario Outline: Update to confirm order with valid id
    Given Set path to confirm order with <ValidId>
    When Send request to confirm order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone @User @Order
  Scenario Outline: Update to confirm order with invalid id
    Given Set path to confirm order invalid id with "<InvalidId>"
    When Send request to confirm order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwerty    |

  @Capstone @User @Order
  Scenario Outline: Update to finish order with valid id
    Given Set path to finish order with <ValidId>
    When Send request to finish order
    Then Status code should be 200
    Examples:
      | ValidId    |
      | 1714913939 |

  @Capstone @User @Order
  Scenario Outline: Update to finish order with invalid id
    Given Set path to finish order invalid id with "<InvalidId>"
    When Send request to finish order
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwerty    |