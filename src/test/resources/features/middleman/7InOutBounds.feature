Feature: InOutBounds
  Admin can manage inbounds & user can manage outbounds

  @Capstone @Admin @Inbounds
  #Positive-TC1
  Scenario: Get admin products inbounds
    Given Get admin products inbounds
    When Send request get admin inbounds
    Then Status code should be 200

  @Capstone @Admin @Inbounds
  #Positive-TC2
  Scenario: Post create new admin inbounds
    Given Post create new admin inbounds with valid request body "7PostCreateValidInbounds.json"
    When Send request post inbound
    Then Status code should be 201
    And Validate json schema "PostValidInboundsJsonSchema.json"

  @Capstone @Admin @Inbounds
  #Negative-TC2
  Scenario: Post create new admin inbounds without product id
    Given Post create new admin inbounds without product id with invalid request body "7PostCreateInvalidInbound.json"
    When Send request post inbound
    Then Status code should be 200

  @Capstone @Admin @Inbounds
  #Positive-TC3
  Scenario: Put update admin inbounds product quantity
    Given Put update admin inbounds product quantity with valid request body "7PostCreateValidInbounds.json" and parameter 4
    When Send request put update inbounds
    Then Status code should be 200
    And Validate json schema "PudUpdateInboundsJsonSchema.json"

  @Capstone @Admin @Inbounds
  #Negative-TC3
  Scenario: Put update admin inbounds product quantity with invalid request body
    Given Put update admin inbounds product quantity with invalid request body "7PostCreateInvalidInbound.json" and parameter 4
    When Send request put update inbounds
    Then Status code should be 400

  @Capstone @Admin @Inbounds
  #Positive-TC4
  Scenario: Delete admin inbound product by valid id
    Given Delete admin product inbounds by id 4
    When Send request delete product with valid id
    Then Status code should be 204

  @Capstone @User @Outbounds
  #Positive-TC1
  Scenario: Get user products outbounds
    Given Get user products outbounds
    When Send request get user outbounds
    Then Status code should be 200

  @Capstone @User @Outbounds
  #Positive-TC2
  Scenario: Post create new user outbounds
    Given Post create new user outbounds with valid request body "7PostCreateValidOutbounds.json"
    When Send request post outbounds
    Then Status code should be 201
    And Validate json schema "PostValidOutboundsJsonSchema.json"

  @Capstone @User @Outbounds
  #Negative-TC2
  Scenario: Post create new user outbounds without product id
    Given Post create new user outbounds without product id with invalid request body "7PostCreateInvalidInbound.json"
    When Send request post outbounds
    Then Status code should be 200

  @Capstone @User @Outbounds
  #Positive-TC3
  Scenario: Put update user outbounds product quantity
    Given Put update user outbounds product quantity with valid request body "7PostCreateValidOutbounds.json" and parameter 4
    When Send request put update product with valid request body
    Then Status code should be 200
    And Validate json schema "PudUpdateOutboundsJsonSchema.json"

  @Capstone @User @Outbounds
  #Negative-TC3
  Scenario: Put update user outbounds product quantity with invalid request body
    Given Put update user outbounds product quantity with invalid request body "7PostCreateInvalidInbound.json" and parameter 4
    When Send request put update product with valid request body
    Then Status code should be 400

  @Capstone @User @Outbounds
  #Positive-TC4
  Scenario: Delete user inbound product by valid id
    Given Delete user product outbounds by id 4
    When Send request delete product with valid id
    Then Status code should be 204