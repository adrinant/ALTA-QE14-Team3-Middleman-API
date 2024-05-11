Feature: User Products
  User can manage product in Middleman API

  #Positive
  @Capstone @User @Product
  Scenario: Get all user products
    Given Set path and token
    When Send request to get user products
    Then Status code should be 200

  #Positive
  @Capstone @User @Product
  Scenario Outline: Add product by User
    Given Post add product by user with valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", product_image "<product_image>"
    When Send request to add product
    Then Status code should be 201
    And Validate json schema "AddProductJsonSchema.json"
    Examples:
      | product_name | unit | stock | price | product_image |
      | Gulayes3     | kg   | 5     | 15000 | Gulaku.jpg    |

  #Negative
  @Capstone @User @Product
  Scenario Outline: Add product by user with invalid body
    Given Post add product by user with invalid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", product_image "<product_image>"
    When Send request to add product
    Then Status code should be 400
    Examples:
      | product_name | unit | stock | price | product_image |
      |              |      |       |       | Gulaku.jpg         |

  #Positive
  @Capstone @User @Product
  Scenario Outline: Search product data with valid parameter
    Given Set parameter to "<Parameter>"
    When Send request to search
    Then Status code should be 200
    Examples:
      | Parameter        |
      | productname=Gula |

  #Negative
  @Capstone @User @Product
  Scenario Outline: Search product data with invalid parameter
    Given Set parameter to "<Parameter>"
    When Send request to search
    Then Status code should be 404
    Examples:
      | Parameter         |
      | productname=@!~ |

  @Capstone @User @Product
  Scenario Outline: Update product with valid id
    Given Set parameter to valid id <Parameter> and valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", image "<imageName>"
    When Send request to update user product
    Then Status code should be 200
    And Validate json schema "UpdateProductJsonSchema.json"
    Examples:
      | Parameter | product_name | unit | stock | price | imageName  |
      | 7         | Gula Nomor 7 | kg   | 10    | 15000 | Gulaku.jpg |

  @Capstone @User @Product
  Scenario Outline: Update product with invalid id
    Given Set parameter to invalid id <Parameter> and valid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", image "<imageName>"
    When Send request to update user product
    Then Status code should be 404
    Examples:
      | Parameter | product_name | unit | stock | price | imageName     |
      | 101       | Gula         | kg   | 10    | 15000 | BerasLele.jpg |

  @Capstone @User @Product
  Scenario Outline: Update product with invalid body
    Given Set parameter to valid id <Parameter> and invalid data product_name "<product_name>", unit "<unit>", stock "<stock>", price "<price>", image "<imageName>"
    When Send request to update user product
    Then Status code should be 400
    Examples:
      | Parameter | product_name | unit | stock | price | imageName     |
      | 7         |              |      |       |       | BerasRaja.jpg |

  @Capstone @User @Product
  Scenario Outline: User Delete product with valid id
    Given Set id with <id>
    When Send request to delete
    Then Status code should be 204
    Examples:
      | id |
      | 18 |

  @Capstone @User @Product
  Scenario Outline: User Delete product with invalid id
    Given Set invalid id with "<id>"
    When Send request to delete
    Then Status code should be 500
    Examples:
      | id  |
      | qwe |