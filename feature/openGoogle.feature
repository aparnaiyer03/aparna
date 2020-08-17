@progress
Feature: Test Progress Bar


    

  Scenario: 01 Test three drop-down options after clicking Progress Bar tab
     Given I launch the application
    And I click on Progress Bar Tab
    Then I verify three drop-down values are getting displayed
    

  Scenario Outline: 02 Test JQuery Download Progress bars button
  Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab JQuery Download Progress bars
    Then I verify text on webpage "<xpath_data>"is "<text>" 
    
    Examples:
    |text|xpath_data|
    |JQuery UI Progress bar - Download Dialog|/html/body/div[2]/div/div[2]/div/h2|
		
		
  Scenario: 03 Test Start Download button
     Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab JQuery Download Progress bars
    Then I click on Start Download button
    And I verify download status is complete before clicking close button
    And I click on Close button 
	
    
  Scenario Outline: 04 Test Bootstrap Progress Bar button
 Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab Bootstrap Progress Bar
    Then I verify text on webpage "<xpath_data>"is "<text>" 
    Examples:
    |text|xpath_data|
    |Stylish progress bar demo for the automation|/html/body/div[2]/div/div[2]/h3|
	
	
	Scenario Outline: 05 Test Bootstrap Progress Bar button
    Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab Bootstrap Progress Bar
    Then I verify initial value of progress bar is "<percent>"
    Examples:
    |percent|
    |0%|
    
    
	
  Scenario: 06 Test
    Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab Bootstrap Progress Bar
    And I click on Downloadsize:20480kb button
    Then I verify the progress bar stops at 100%


  Scenario Outline: 07 Test Drag and Drop Slider button
    Given I launch the application
    And I click on Progress Bar Tab
    And I click on sub tab Drag and Drop Slider
    Then I verify text on webpage "<xpath_data>"is "<text>" 
    
    Examples:
    |text|xpath_data|
    |Range Sliders|/html/body/div[2]/div/div[2]/h2|
    
    
    
  





