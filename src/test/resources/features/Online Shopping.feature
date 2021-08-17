Feature: Online Shopping

  @OnlineShopping
  Scenario: Able to add 2 items to the cart and place an order
    Given I start the web browser
    When I open YourLogo Home Page
    When I add 2 Products to Cart and click on Checkout
    When I login enter valid credentials to login
    When I click on Proceed and confirm Order
    #Finish Test