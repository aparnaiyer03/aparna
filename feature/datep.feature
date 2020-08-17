@datep
Feature: Datepicker 



Scenario Outline: 01 Date picker tab
Given I log in the application
And I click on Date picker tab
Then I verify 2 values<value> are being displayed
Examples:
|value|
|Bootstrap Date Picker|
|JQuery Date Picker|


Scenario Outline: 02 JQuery Date Picker From tab
Given I log in the application
And I click on Date picker tab 
And I click on JQuery Date Picker
And I select a month <month2> and a date<date2> in start
Then I verify months before<month2> and date<date2> is disabled

Examples:
|month2|date2|
|Feb|14|

@basic
Scenario Outline: 03 JQuery Date Picker To tab
Given I log in the application
And I click on Date picker tab 
And I click on JQuery Date Picker
And I select a month <month1> and a date<date1> in end
Then I verify months after<month1> and <date1> is disabled

Examples:
|month1|date1|
|Oct|03|

@Dateeg
Scenario: 04 Dateeg
Given I log in the application
And I click on Date picker tab 
And I click on Bootstrap date picker tab
And I click on calender in dateeg
And I click on today
Then I verify today's date is being displayed 
And I click on clear 
Then I verify the field is empty

Scenario: 05 Dateeg futuredate
Given I log in the application
And I click on Date picker tab 
And I click on Bootstrap date picker tab
And I click on calender in dateeg
And I verify all future year and month is disbaled 

