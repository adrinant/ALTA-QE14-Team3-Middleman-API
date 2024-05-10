Feature: Update user product

  @Capstone
  Scenario Outline: Update product with valid id
    Given Set parameter to valid id <Parameter> and valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>"
    When Send request to update user product
    Then Status code should be 200
    Examples:
      | Parameter | product_name | unit | stock | price |
      | 7         | Gula         | kg   | 10    | 15000 |

  @Capstone
  Scenario Outline: Update product with invalid id
    Given Set parameter to invalid id "<Parameter>" and valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>"
    When Send request to update user product
    Then Status code should be 400
    Examples:
      | Parameter | product_name | unit | stock | price |
      | qwe       | Gula         | kg   | 10    | 15000 |

  @Capstone
  Scenario Outline: Update product with invalid body
    Given Set parameter to valid id <Parameter> and invalid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>"
    When Send request to update user product
    Then Status code should be 400
    Examples:
      | Parameter | product_name | unit | stock | price |
      | 7         |              |      |       |       |