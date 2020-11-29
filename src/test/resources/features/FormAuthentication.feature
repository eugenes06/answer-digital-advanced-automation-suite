Feature: Form authentication


  Scenario: Fail to login when correct username but incorrect password is used
    Given I enter the username "tomsmith"
    And I enter the password "eugene123"
    When I click Login
    Then the banner message will say "Your password is invalid!"

  Scenario: Fail to login when incorrect username but correct password is used
    Given I enter the username "eugene"
    And I enter the password "SuperSecretPassword!"
    When I click Login
    Then the banner message will say "Your username is invalid!"

  Scenario: Successfully login when correct username and password is used
    Given I enter the username "tomsmith"
    And I enter the password "SuperSecretPassword!"
    When I click Login
    Then the banner message will say "You logged into a secure area!"
    And after I logout
    Then the banner message will say "You logged out of the secure area!"