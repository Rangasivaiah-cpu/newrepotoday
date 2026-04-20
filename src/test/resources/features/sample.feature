Feature: Sample feature for automation
  As a user I want to run Cucumber tests via TestNG

  Scenario: Open browser and check title
    Given I open the url "https://www.google.com"
    Then the page title should contain "Google"

  Scenario: Open another site
    Given I open the url "https://www.bing.com"
    Then the page title should contain "Bing"
