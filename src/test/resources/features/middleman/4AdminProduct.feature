Feature: Admin products

  @Capstone4
  #Positive TC-1
  Scenario: Add product by Admin
    Given Post add product by admin with valid data product_name "Beras Lele111", unit "kg", stock "11", price "11111", product_image "lele.jpeg"
    When Send request post update product
    Then Status code should be 201
    And Validate json schema "4PostAddProductByAdminValidSchema.json"

  @Capstone4
  #Negative TC-1
  Scenario: Add product by Admin
    Given Post add product by admin with valid data unit "kg", stock "4", price "8900", product_image "lele.jpeg"
    When Send request post update product
    Then Status code should be 400


  @Capstone4
  #Positive TC-2
  Scenario: Get all Admin products for admin & User
    Given get all admin products
    When Send request get admin products
    Then Status code should be 200


  @Capstone4
  #Positive-TC3
  Scenario: Search product data by admin
    Given Get search product data by admin
    When Send request to get product data
    Then Status code should be 200


  @Capstone4
 #Positive-TC4
  Scenario: Update product data
    Given Put update product by admin with valid data product_name "McLaren", unit "kg", stock "9", price "9999", product_image "lele.jpeg" and set parameter to 70
    When Send request put update product
    Then Status code should be 200
    And Validate json schema "4PutUpdateProductDataSchema.json"

  @Capstone4
 #Negative-TC2
  Scenario: Update product data
    Given Put update product by admin with invalid data product_name "", unit "kg", stock "6", price "9000", product_image "lele.jpeg" and set parameter to 70
    When Send request put update product
    Then Status code should be 400

  @CapstoneX
 #Positive-TC5
  Scenario: : Delete product by id
    Given Delete product by id 99
    When Send request delete product
    Then Status code should be 204

