Feature:Select day, get 3 hourly forecast

  Scenario: A user should be able to see three hourly forecast for a given day
    Given the application is running
    When date is given
    And user clicks on day1
    Then user will be  able to see three hourly forecast
    #Then I should be able to see the five day weather forecast

  Scenario: A user should be able to see three hourly forecast for a given day
    Given the application is running
    When date is given
    And user clicks on next day
    Then user will be  able to see three hourly forecast for next day

  #@single
  Scenario:A user should be able to hide the three hourly forecast
    Given the application is running
    And user clicks on day1
    When user clicks on day1 again
    Then the hourly forecast should be hidden



