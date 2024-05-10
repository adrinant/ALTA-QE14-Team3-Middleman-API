Feature: InOutBounds

  @Capstone5
  #Positive-TC1
  Scenario: Get inbound stock for user and admin
    Given Get inbound stock for user and admin
    When Send request get inbound stock for user and admin
    Then Status code should be 200

  @Capstone5
  #Positive-TC2
  Scenario: Create new cart for stock with valid request body
    Given Post create new inbound stock for user and admin with valid request body "5postCreateValidInbound.json"
    When Send request post inbound stock for user and admin
    Then Status code should be 201
    And Validate json schema "5postCreateValidInboundSchema.json"

  @Capstone5
  #Negative-TC2
  Scenario: Create new cart for stock  without product id
    Given Post create new inbound stock for user and admin with invalid request body "5postCreateInvalidInbound.json"
    When Send request post inbound stock for user and admin
    Then Status code should be 200

  @Capstone5
  #Positive-TC3
  Scenario: Update product for inbound stock with valid request body by admin
    Given Put update product with valid request body "5putUpdateProductvalid.json" and parameter 4
    When Send request put update product with valid request body
    Then Status code should be 200
    And Validate json schema "5putUpdateProductValidSchema.json"

  @Capstone5
  #Negative-TC3
  Scenario: Update product with invalid request body by admin
    Given Put update product with invalid request body "5putUpdateProductInvalid.json" and parameter 4
    When Send request put update product with valid request body
    Then Status code should be 400

  @Capstone5
  #Positive-TC4
  Scenario: Delete product by valid id
    Given Delete product with valid product id 3
    When Send request delete product with valid id
    Then Status code should be 204

