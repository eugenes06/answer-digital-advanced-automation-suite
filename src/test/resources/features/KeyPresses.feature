Feature: Display key presses

  Scenario Outline: Displays "<key>" when pressed on the screen
    Given I visit key presses page
    When I press key "<key>"
    Then I can see the result key press cotaning "<key>"

    Examples:
      | key     |
      | SHIFT   |
      | CONTROL |
      | SPACE   |
      | HOME    |