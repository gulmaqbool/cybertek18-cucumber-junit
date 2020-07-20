@wiki
Feature: Wiki title and search verifications


  Background: User is on the Wiki home page
    Given User is on the Wikipedia home page


  Scenario: Search functionality title verification
    When User searches "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the wiki title



  Scenario: Search functionality header verification
    When User searches "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the main header

  @wikiScenarioOutline
  Scenario Outline: Search functionality header verification
    When User searches "<searchValue>" in the wiki search page
    Then User should see "<expectedTitle>" in the wiki title
    Then User should see "<expectedMainHeader>" in the main header
    Then User should see "<expectedImageHeader>" in the image header

    Examples: example test data for wikipedia search
      | searchValue    | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs     | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | Tom Cruise     | Tom Cruise      | Tom Cruise         | Tom Cruise          |
      | Bruce Lee      | Bruce Lee       | Bruce Lee          | Bruce Lee           |
      | Imran Khan     | Imran Khan      | Imran Khan         | Imran Khan          |
      | Thomas Edison  | Thomas Edison   | Thomas Edison      | Thomas Edison       |







