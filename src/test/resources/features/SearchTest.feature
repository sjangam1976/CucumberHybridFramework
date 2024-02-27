Feature: Search functionality

  Scenario: user searches for a valid product
    Given user navigates to search page
    When user enters valid product "HP" into search box field
    And user clicks on search button
    Then user should get valid product displayed in search result

  Scenario: user searches for an invalid product
    Given user navigates to search page
    When user enters invalid product "honda" into search box field
    And user clicks on search button
    Then user should get a message about no product matching

  Scenario: user searches without any product
    Given user navigates to search page
    When user does not enter any product name into search box field
    And user clicks on search button
    Then user should get a message about no product matching
