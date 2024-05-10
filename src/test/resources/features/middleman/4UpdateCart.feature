Feature: Update cart

  @Capstone
  Scenario Outline: Update product quantity with valid id
    Given Set parameter to update cart valid id <Parameter> and request data qty "<qty>"
    When Send request to update cart
    Then Status code should be 200
    Examples:
      | Parameter | qty |
      | 4         | 10  |

  @Capstone
  Scenario Outline: Update product quantity with invalid id
    Given Set parameter to update cart invalid id "<Parameter>" and request data qty "<qty>"
    When Send request to update cart
    Then Status code should be 404
    Examples:
      | Parameter | qty |
      | qwe       | 10  |

  @Capstone
  Scenario Outline: Update product quantity with invalid data
    Given Set parameter to update cart valid id <Parameter> and request invalid data qty "<qty>"
    When Send request to update cart
    Then Status code should be 400
    Examples:
      | Parameter | qty |
      | 4         | qwe |