Feature: Admin products
  Admin can manage product in Middleman API

  @Capstone @Admin @Product
  #Positive TC-1
  Scenario: Add product by Admin
    Given Post add product by admin with valid data product_name "Beras Regression 4", unit "kg", stock "40", price "22222", product_image "BerasLele.jpg"
    When Send request post update product
    Then Status code should be 201
    And Validate json schema "AddProductJsonSchema.json"

  @Capstone @Admin @Product
  #Negative TC-1
  Scenario: Add product by Admin without ProductName
    Given Post add product by admin with valid data unit "kg", stock "4", price "8900", product_image "BerasLele.jpg"
    When Send request post update product
    Then Status code should be 400

  @Capstone @Admin @Product
  #Positive TC-2
  Scenario: Get all Admin products
    Given Get all admin products
    When Send request get admin products
    Then Status code should be 200

  @Capstone @Admin @Product
  #Positive-TC3
  Scenario: Search product data by admin
    Given Get search product data by admin
    When Send request to get product data
    Then Status code should be 200

  @Capstone @Admin @Product
  #Positive-TC4
  Scenario: Update product data
    Given Put update product by admin with valid data product_name "Beras McLaren", unit "kg", stock "9", price "9999", product_image "BerasLele.jpg" and set parameter to 70
    When Send request put update product
    Then Status code should be 200
    And Validate json schema "UpdateProductJsonSchema.json"

  @Capstone @Admin @Product
  #Negative-TC2
  Scenario: Update product data
    Given Put update product by admin with invalid data product_name "", unit "kg", stock "6", price "9000", product_image "BerasLele.jpg" and set parameter to 70
    When Send request put update product
    Then Status code should be 400

  @Capstone @Admin @Product
  #Positive-TC5
  Scenario: Admin Delete product by id
    Given Delete product by id 101
    When Send request delete product
    Then Status code should be 204