Feature: Add product by user

  @Capstone
  Scenario Outline: Add product by User
    Given Post add product by user with valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", product_image "<product_image>"
    When Send request to add product
    Then Status code should be 201
    Examples:
      | product_name | unit | stock | price | product_image |
      | Gulaku33     | kg   | 7     | 15000 | gula.jpg      |

  @Capstone
  Scenario Outline: Add product by user with invalid body
    Given Post add product by user with invalid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", product_image "<product_image>"
    When Send request to add product
    Then Status code should be 201
    Examples:
      | product_name | unit | stock | price | product_image |
      |              |      |       |       | gula.jpg      |