Feature: Infinite scroll

  Scenario Outline: Scroll to the bottom of the page "<numberOfTimes>" times, then scroll up
    Given I visit infinite scroll page
    When I scroll down to the bottom <numberOfTimes> times
    Then I scroll up
    And the top title text will say "Infinite Scroll"

    Examples:
      | numberOfTimes |
      | 2             |