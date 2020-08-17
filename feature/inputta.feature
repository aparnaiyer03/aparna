@inputta
Feature: input tab

Scenario Outline: 01
Given I login 
And I click on input forms tab
And I click on simple form demo
And I click on enter message <name>
Then I verify <name> is displayed

Examples:
|name|
|aparna|

Scenario Outline: 02 Add
Given I login
And I click on input forms tab
And I click on simple form demo
And I enter 2 values <a> <b>
And I click on total 
Then I verify the result<result>

Examples:
|a|b|result|
|10|20|30|
|apa|rna|NaN|


Scenario: 03 Single checkbox
Given I login
And I click on input forms tab
And I click on checkbox demo
And I press on singlecheckbox
Then I verify if it has been checked 

Scenario: 04 Multiple check
Given I login
And I click on input forms tab
And I click on checkbox demo
And I click on checkall
Then I verify if all 4options are checked



