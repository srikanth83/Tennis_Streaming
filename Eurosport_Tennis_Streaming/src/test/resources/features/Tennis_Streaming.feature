
@Tennis_Videos
Feature: Use able to watch the Videos from Eurosport
  As Eurosport Customer
  I want to watch my favourite sports videos streams
  So that I can enjoy and follow my favourite sports

  Scenario: able to watch Tennis sports streaming
    Given I am Eurosport Customer
    And On Videos Hub Page
    When I select to watch the videos from Tennis Section
    Then the selected video is playing
    And the following player controls are displayed
      |Play|
      |Pause|
      |Maximize|


    Scenario: when clicked on more videos button for tennis section the filter should be defaulted to tennis and latest videos
      Given I am Eurosport Customer
      And On Videos Hub Page
      When I click on more videos button from tennis section
      Then filter should be defaulted to Tennis and Latest videos


