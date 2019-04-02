Feature: test Travel Insurance page of GoBear

  @gobear
  Scenario: search for a Travel Insurance should return at least 3 result cards
    Given Testcase-ID (GOBEAR_01) - Testcase description (Verify Travel Insurance page and its functional menu)
    Given I go to url: /ph?x_session_type=UAT
    When I select section: Insurance
    And I select section: Insurance_Travel
    And I click Submit
    Then I see Insurance Travel page displays with at least (3) options
    When I filter Insurance Travel results by Promos only
    Then I see Insurance Travel page displays with (0) options
    When I filter Insurance Travel results by Show all
    Then I see Insurance Travel page displays with at least (3) options
    When I filter Insurance Travel results by Insurer: Pacific Cross
    Then I see Insurance Travel page displays with results of: Pacific Cross
    When I sort Insurance Travel results by Review score: desc
    And I set details - policy type: annual
    And I select destination: Schengen
    And I select travel start date: today
    Then report - append note (Result;PASSED)