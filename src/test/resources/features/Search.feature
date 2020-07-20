Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search page.


  Background: User should be on google search page
    Given User is on the google search page


  Scenario: Google default title verification
    When User searches apple
    Then User should see title is Google


  @wip #working in progress
  Scenario: Google title verification after search
    When User searches apple
    Then User should see apple in the title


  Scenario: Google title verification after search
    When User searches "mango"
    Then User should see "mango" in the title


  Scenario: Google -About- link page title verification
    Then User should see About link
    When User clicks to About link
    Then User should see title Google - About Google, Our Culture & Company News

  @googleTable
  Scenario: Google search page footer links verification
    Then User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |

    #Control alt L --> to make it neat


