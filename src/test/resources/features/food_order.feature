Feature: Food order website (foodorder.info uk)
  As a user I want to open the food order site (foodorder.info uk), browse products, add to cart, and see reports via TestNG and Cucumber.

  @foodorder @smoke
  Scenario: Open food order site and verify home page
    Given I open the food order website
    Then the food order page title should contain "food"
    And the page should show products or search

  @foodorder @smoke
  Scenario: Search for a product on food order site
    Given I open the food order website
    When I search for "cauliflower"
    Then search results should show "Cauliflower"

  @foodorder @regression
  Scenario: Add product to cart on food order site
    Given I open the food order website
    When I add the first product to cart
    Then the cart should show at least 1 item

  @foodorder @regression
  Scenario: Open cart from food order site
    Given I open the food order website
    When I add the first product to cart
    And I open the cart
    Then I should be on the cart page
