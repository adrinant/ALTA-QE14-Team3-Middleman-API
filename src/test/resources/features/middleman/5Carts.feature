Feature: Carts
  User can manage carts in Middleman API

  @Capstone @User
  Scenario: Get carts with valid path
    Given Set path for carts
    When Send request to get carts
    Then Status code should be 200

  @Capstone @User
  Scenario Outline: Create new cart with valid body
    Given Set request with valid data product_id "<product_id>" and qty "<qty>"
    When Send request to create cart
    Then Status code should be 201
    Examples:
      | product_id | qty |
      | 4          | 2   |

  @Capstone @User
  Scenario Outline:Create new cart with invalid body
    Given Set request with invalid data qty "<qty>"
    When Send request to create cart
    Then Status code should be 400
    Examples:
      | qty |
      | 0   |

  @Capstone @User
  Scenario Outline: Update product quantity with valid id
    Given Set parameter to update cart valid id <Parameter> and request data qty "<qty>"
    When Send request to update cart
    Then Status code should be 200
    Examples:
      | Parameter | qty |
      | 4         | 10  |

  @Capstone @User
  Scenario Outline: Update product quantity with invalid id
    Given Set parameter to update cart invalid id "<Parameter>" and request data qty "<qty>"
    When Send request to update cart
    Then Status code should be 404
    Examples:
      | Parameter | qty |
      | qwe       | 10  |

  @Capstone @User
  Scenario Outline: Update product quantity with invalid data
    Given Set parameter to update cart valid id <Parameter> and request invalid data qty "<qty>"
    When Send request to update cart
    Then Status code should be 400
    Examples:
      | Parameter | qty |
      | 4         | qwe |

  @Capstone @User
  Scenario Outline: Delete cart with valid id
    Given Set carts id with <id>
    When Send request to delete cart
    Then Status code should be 204
    Examples:
      | id |
      | 4  |

  @Capstone @User
  Scenario Outline: Delete cart with invalid id
    Given Set carts invalid id with "<InvalidId>"
    When Send request to delete cart
    Then Status code should be 404
    Examples:
      | InvalidId |
      | qwe       |