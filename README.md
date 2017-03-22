# acceptance-testing-selenium
A simple project which deals with testing of weather forecast using Selenium BDD

This application covers testing of following features 
### Features
* Enter city name, get 5 day weather forecast
* Select day, get 3 hourly forecast
* Select day again, hide 3 hourly forecast
* Daily forecast should summarise the 3 hour data:
  * Most dominant (or current) condition
  * Most dominant (or current) wind speed and direction
  * Aggregate rainfall
  * Minimum and maximum temperatures


### Techincal Overview

This Automation Suite built using Cucumber Java, Selenium and Maven.

Feature files are created using Gherkin Syntax and step definitions written in Java and Assertions with jUnit.
 
Feature files are located under src/test/resources.

Step Definitions are located under src/test/java/SeleniumCucumberSteps.

SeleniumCucumber is the entry point for these tests .

### Pre-requisites

* Java is already installed on the client machine.
* Maven
* Chrome Browser is already installed.


### Running Tests 

* Run the Weather Application 
* open IDE , Run SeleniumCucumber.java

### Note 
* ChromeDriver already bundled with this project under Directory :drivers
In case of any driver related failures try setting the absolute path in SeleniumCucumberSteps.beforeTest()
  