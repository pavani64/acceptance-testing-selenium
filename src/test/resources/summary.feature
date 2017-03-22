//@single
Feature:Daily forecast should summarise the 3 hour data

  Scenario:Summarise three hour data
    Given the application is running
    When I enter city name as: Glasgow
    And user clicks on day1
    Then summary of all the   hourly  data should be displayed like below
    #Hour| Description | Max_Temp | Min_Temp | Wind_Speed | Rainfall | Pressure
      | 1300 | Rain   | 16 | 13 | 3kph | 1mm | 1015mb |
      | 1600 | Clouds | 16 | 14 | 3kph | 0mm | 1014mb |
      | 1900 | Clouds | 13 | 12 | 1kph | 0mm | 1013mb |
      | 2200 | Clouds | 7  | 7  | 2kph | 0mm | 1013mb |







