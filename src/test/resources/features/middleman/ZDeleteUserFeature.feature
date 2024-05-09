Feature: Delete User

  @CapstoneZ
#Positive-TC3
  Scenario: Delete User
    Given delete user profile
    When Send request delete user
    Then Status code should be 200