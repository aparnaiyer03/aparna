@listbox
Feature: Test List Box

  Scenario: 01 list box tab
    Given I login to the application
    And I click on list box tab
    Then I verify three drop down values are getting displayed

  Scenario Outline: 02 bootstrap list box tab
    Given I login to the application
    And I click on list box tab
    And I click on bootstrap list box
    When I select some results <message>
    And I press the shift elements button
    Then I verify the results<message> are shifted

    Examples: 
      | message                 |
      | bootstrap-duallist      |
    

  Scenario Outline: 03 Data List Filter tab
    Given I login to the application
    And I click on list box tab
    And I click on data list filter tab
    And I enter a value <random>
    Then I verify the results<random> are shown

    Examples: 
      | random            |
      | Tyreese Burn      |
      | manager           |
      | 980-543-3333      |
      | test5@company.com |
@list4
  Scenario Outline: 04 JQuery list box
    Given I login to the application
    And I click on list box tab
    And I click on JQuery
    And I select a result <option>
    And I click on Add button
    Then I verify result <option> is added
    When I select a result<option>
    And I click on remove
    Then I verify the element <option>is removed

    Examples: 
      | option   |
      | Alice    |
      

  Scenario: 05 JQuery addall and removeall
    Given I login to the application
    And I click on list box tab
    And I click on JQuery
    When I click on addall button
    Then I verify that all the results are added
    And when I click on removeall button
    Then I verify  all the results are removed

    
     