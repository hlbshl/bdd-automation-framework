@main_page

Feature: Change the language and search for a bus

  Scenario: Default language can be changed
    Given actor navigates to Obilet main page
    When actor clicks on language selector
    And actor selects English language
    Then actor verifies page is displayed in English

  Scenario: Search for today's bus from Istanbul Anatolia
    When actor searches for 'Istanbul Anatolia' departure station
    And actor searches for 'Izmir' arrival station
    And actor clicks on search button
    Then actor verifies search results are present