Feature: Inventories

  @Capstone6User
  #Positive-TC1
  Scenario: Create form to list user product out with valid request body by user
    Given Create form to list user product with valid request body by user and with valid json "6PostCreateFormUser.json"
    When  Send request post create form
    Then  Status code should be 201
    And   Validate json schema "6PostCreateFormUserSchema.json"

  @Capstone6User
  #Negative-TC1
  Scenario: Create form to list product (out) with invalid request body
    Given Create form to list user product by user and with invalid json "6PostCreateFormUserInvalid.json"
    When  Send request post create form
    Then  Status code should be 400

  @Capstone6User
  #Positive-TC2
  Scenario: Get all product forms from inventory by user
    Given Get all product forms from inventory by user
    When  Send request get all product forms
    Then  Status code should be 200

  @Capstone6User
  #Positive-TC3
  Scenario: Get detailed product from inventory by user
    Given  Get detailed product from inventory by user and set parameter to 1
    When   Send request get detailed product from inventory id
    Then   Status code should be 200

  @Capstone6Admin
  #Positive-TC4
  Scenario: Create a form to list product by admin
    Given Create a form to list product by admin with valid json "6PostCreateFormAdmin.json"
    When  Send request post create form by admin
    Then  Status code should be 201
    And   Validate json schema "6PostCreateFormAdminSchema.json"

  @Capstone6Admin
  #Positive-TC5
  Scenario: Get all product inventory forms by admin
    Given Get all product forms from inventory by admin
    When  Send request get all product forms by admin
    Then  Status code should be 200

  @Capstone6Admin
  #Positive-TC6
  Scenario: Get detailed product inventory form by admin
    Given Get detailed product from inventory by admin and set parameter to 1
    When  Send request get detailed product inventory forms
    Then  Status code should be 200