Feature: Delete an existing item from the basket

  Scenario: As a user I want to be able to delete the item I have previously added from the basket
    Given I add an item to my basket
    When I go to my basket page
    Then there is a delete button
    And when I click it the item is removed from the basket
    And the banner will say "Your shopping cart is empty."