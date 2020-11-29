# Answer Digital automation suite for the standard "The Internet" Heroku app.

This is an automation regression test suite for Answer Digital,
which tests the form authentication, infinite scroll and key presses functionality of the herokuapp [The Internet](http://the-internet.herokuapp.com)

The project utilises Java 11, Cucumber with JUnit and Selenium Chrome webdriver.

# Pre-requisite requirements
* Java 11
* Chrome browser
* Chromium webdriver for your version of the browser and OS
* Find out existing chrome version by going to Menu -> About Chrome
* Download chromedriver from [here](https://chromedriver.chromium.org/),
matching the version of the chrome and OS
* Extract it from zip, and place the binary in the project's `src/test/resources/driver` directory, replacing the old one.

** Please note, default binary is for Windows, Chrome version "86.0.4240", so if you have different OS or very different
browser version, it won't work without doing the above steps.

# To run the project
* `cd` into the root project directory
* Run using the provided maven wrapper, for Windows - `mvnw.cmd clean test`
* For Linux / MacOS - `./mvnw clean test`