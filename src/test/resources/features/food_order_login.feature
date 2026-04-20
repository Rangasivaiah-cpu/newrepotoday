@smoke @sanity @regression
Feature: Food Order Login

  Scenario: Successful food order category clicking
    Given user launches the food order application
    When user clicks on browse menu
    And user clicks on login
    And user enters email "arepatiranga@gmail.com"
    And user enters password "12345678"
    And user clicks on login button
    And user clicks on category
    And user clicks on clickitem
    And user clicks on additem
    And user clicks on paybutton
    Then itemprice should be display correctly
    And user clicks on checkout
    And user clicks on finalpay
    And user clicks on backtohome
    And user clicks on deliveryservice
    And user enters postcode "EH6 6AX"
    And user clicks on proceedbutton
    And user clicks on clicksujetionlocation
    And user clicks on proceedbutton2
    And user clicks on clickcollectionservice
    And user clicks on clickdeliveryservice2
    And user clicks on clicklocatmeoption
    And user enters address "Uppal, Hyderabad, Telangana, India"
    And user clicks on clickconfirmadress
    And user clicks on clickproceed3
    And invalid address screen is captured for report
    And user clicks on gposcat
    And user clicks on clickprotonsitem
    And user clicks on clickcontinuebuttonfor2item
    And user clicks on clickmodifier
    And user clicks on clickaddtocartbutton
    And user clicks on clickpaybutton2
    And user clicks on clickcheckoutbutton2
    And user clicks on incresethaitemquantity
    And user opens promocode section
    And user clicks on last coupon code
    Then invalid coupon code due to cart amount less than 25 should be displayed
    And user clicks on finalpay
    And user clicks on backtohome2

  @negative
  Scenario Outline: Login with invalid credentials
    Given user launches the food order application
    When user clicks on browse menu
    And user clicks on login
    And user enters email "<email>"
    And user enters password "<password>"
    And user clicks on login button and expects error
    Then invalid credentials error message should be displayed

    Examples:
      | email                | password   |
      | wrong@mail.com       | 123456     |
      | shiva@123@gmail.com  | 1234567    |
      | @johns@hotmail.com   | 123458     |
      | @Drona@hotmail.com   | Drona12345 |
