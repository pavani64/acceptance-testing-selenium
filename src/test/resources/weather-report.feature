Feature: Weather Report
  As a user of Weather Website
  I want to be able to see five day  weather forecast
  when I enter City name
#Enter city name, get 5 day weather forecast
  Scenario Outline: A user sees five day weather forecast for city of his choice
    Given the application is running
    When I enter city name as: Glasgow
    Then the forecast should have <Day>

    Examples:
      | Day |
      | Tue |
      | Wed |
      | Thu |
      | Fri |

  Scenario: A user sees five day weather forecast for city of his choice
    Given the application is running
    When I enter city name as: Livingston
    Then I should see error message


