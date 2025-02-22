Feature: Swag Lab Testing

  @SmokeTest
  Scenario: Check Login
    Given I open the website
    When I login with the UserID "standard_user" and Password "secret_sauce"
    Then I validate the login is successful
    And I quit my browser

    @Regression @SmokeTest
  Scenario: Check Cart
    Given I open the website
    When I login with the UserID "standard_user" and Password "secret_sauce"
    Then I validate the login is successful
    Then I add "item1" to the cart
    Then I go to the cart
    Then I verify "item1" in the cart
    Then I remove a item in the cart
    Then I go back continue shopping
    Then I add "item2" to the cart
    Then I go to the cart
    Then I verify "item2" in the cart
    Then I go back continue shopping
    Then I add "item1" to the cart
    Then I go to the cart
    Then I verify "item1" in the cart
    Then I checkout with items in the cart
    And I quit my browser

    @Regression
  Scenario: Check Sort
    Given I open the website
    When I login with the UserID "standard_user" and Password "secret_sauce"
    Then I validate the login is successful
    Then I check the sort
    And I quit my browser