Feature: Create order

  @Capstone
  Scenario Outline: Create new order valid body
    Given Set request body to create order with "<ValidOrderData>"
    When Send request to create order
    Then Status code should be 201
    Examples:
      | ValidOrderData          |
      | ValidOrderDataBody.json |

  @Capstone
  Scenario Outline: Create new order invalid body
    Given Set request body to create order with "<InvalidOrderData>"
    When Send request to create order
    Then Status code should be 400
    Examples:
      | InvalidOrderData          |
      | InvalidOrderDataBody.json |