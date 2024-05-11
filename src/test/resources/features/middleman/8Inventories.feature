Feature: Inventories
  Admin & user can make form list based on in/outbounds

  #Precondition Inventories (Must have inbound & outbounds)
  #Because inbounds & outbounds keeps resetting if it hitted by another method
  @Capstone @Admin @Inbounds
  #Positive-TC2
  Scenario: Post create new admin inbounds
    Given Post create new admin inbounds with valid request body "8CreateInbounds.json"
    When Send request post inbound
    Then Status code should be 201
    And Validate json schema "PostValidInOutboundsJsonSchema.json"

  @Capstone @User @Outbounds
  #Positive-TC2
  Scenario: Post create new user outbounds
    Given Post create new user outbounds with valid request body "8CreateOutbounds.json"
    When Send request post outbounds
    Then Status code should be 201
    And Validate json schema "PostValidInOutboundsJsonSchema.json"
  #====================================================================================================================#

  @Capstone @User @Inventories
  #Positive-TC1
  Scenario: Create form to list user product out with valid request body by user
    Given Create form to list user product with valid request body by user and with valid json "8CreateOutboundFormList.json"
    When  Send request post create form
    Then  Status code should be 201

  @Capstone @User @Inventories
  #Negative-TC1
  Scenario: Create form to list product (out) with invalid request body
    Given Create form to list user product by user and with invalid json "8CreateInvalidInOutboundsFormList.json"
    When  Send request post create form
    Then  Status code should be 404

  @Capstone @User @Inventories
  #Positive-TC2
  Scenario: Get all product forms from inventory by user
    Given Get all product forms from inventory by user
    When  Send request get all product forms
    Then  Status code should be 200

  @Capstone @User @Inventories
  #Positive-TC3
  Scenario: Get detailed product from inventory by user
    Given  Get detailed product from inventory by user and set parameter to 1715094614
    When   Send request get detailed product from inventory id
    Then   Status code should be 200

  @Capstone @Admin @Inventories
  #Positive-TC4
  Scenario: Create a form to list product by admin
    Given Create a form to list product by admin with valid json "8CreateInboundFormList.json"
    When  Send request post create form by admin
    Then  Status code should be 201

  @Capstone @Admin @Inventories
  #Positive-TC5
  Scenario: Get all product inventory forms by admin
    Given Get all product forms from inventory by admin
    When  Send request get all product forms by admin
    Then  Status code should be 200

  @Capstone @Admin @Inventories
  #Positive-TC6
  Scenario: Get detailed product inventory form by admin
    Given Get detailed product from inventory by admin and set parameter to 1714394310
    When  Send request get detailed product inventory forms
    Then  Status code should be 200