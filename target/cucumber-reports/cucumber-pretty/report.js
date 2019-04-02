$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Travel/travel_insurance.feature");
formatter.feature({
  "line": 1,
  "name": "test Travel Insurance page of GoBear",
  "description": "",
  "id": "test-travel-insurance-page-of-gobear",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "search for a Travel Insurance should return at least 3 result cards",
  "description": "",
  "id": "test-travel-insurance-page-of-gobear;search-for-a-travel-insurance-should-return-at-least-3-result-cards",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@gobear"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Testcase-ID (GOBEAR_01) - Testcase description (Verify Travel Insurance page and its functional menu)",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I go to url: /ph?x_session_type\u003dUAT",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I select section: Insurance",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I select section: Insurance_Travel",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click Submit",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I see Insurance Travel page displays with at least (3) options",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I filter Insurance Travel results by Promos only",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I see Insurance Travel page displays with (0) options",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I filter Insurance Travel results by Show all",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I see Insurance Travel page displays with at least (3) options",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I filter Insurance Travel results by Insurer: Pacific Cross",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I see Insurance Travel page displays with results of: Pacific Cross",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I sort Insurance Travel results by Review score: desc",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I set details - policy type: annual",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select destination: Schengen",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I select travel start date: today",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "report - append note (Result;PASSED)",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GOBEAR_01",
      "offset": 13
    },
    {
      "val": "Verify Travel Insurance page and its functional menu",
      "offset": 48
    }
  ],
  "location": "ReportSteps.set_testcase_ID(String,String)"
});
formatter.result({
  "duration": 325385195,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/ph?x_session_type\u003dUAT",
      "offset": 13
    }
  ],
  "location": "GeneralSteps.goToUrl(String)"
});
formatter.result({
  "duration": 26626520925,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Insurance",
      "offset": 18
    }
  ],
  "location": "HomePageSteps.select_section(String)"
});
formatter.result({
  "duration": 5474596828,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Insurance_Travel",
      "offset": 18
    }
  ],
  "location": "HomePageSteps.select_section(String)"
});
formatter.result({
  "duration": 5389593426,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.iClickSubmit()"
});
formatter.result({
  "duration": 10538197486,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 52
    }
  ],
  "location": "InsuranceTravelSteps.check_number_of_results_found(int)"
});
formatter.result({
  "duration": 162479264,
  "status": "passed"
});
formatter.match({
  "location": "InsuranceTravelSteps.FilterInsuranceTravelResultsByPromosOnly()"
});
formatter.result({
  "duration": 5435603466,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 43
    }
  ],
  "location": "InsuranceTravelSteps.check_exact_number_of_results_found(int)"
});
formatter.result({
  "duration": 10119381367,
  "status": "passed"
});
formatter.match({
  "location": "InsuranceTravelSteps.iFilterInsuranceTravelResultsByShowAll()"
});
formatter.result({
  "duration": 5155355635,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 52
    }
  ],
  "location": "InsuranceTravelSteps.check_number_of_results_found(int)"
});
formatter.result({
  "duration": 51693241,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pacific Cross",
      "offset": 46
    }
  ],
  "location": "InsuranceTravelSteps.filter_by_insurer(String)"
});
formatter.result({
  "duration": 5191266756,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pacific Cross",
      "offset": 54
    }
  ],
  "location": "InsuranceTravelSteps.check_insurance_travel_results_by_insurers(String)"
});
formatter.result({
  "duration": 669741702,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "desc",
      "offset": 49
    }
  ],
  "location": "InsuranceTravelSteps.sort_by_review_score(String)"
});
formatter.result({
  "duration": 5339783208,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "annual",
      "offset": 29
    }
  ],
  "location": "InsuranceTravelSteps.set_details_by_policy_type(String)"
});
formatter.result({
  "duration": 10250821476,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Schengen",
      "offset": 22
    }
  ],
  "location": "InsuranceTravelSteps.select_destination(String)"
});
formatter.result({
  "duration": 13311300640,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "today",
      "offset": 28
    }
  ],
  "location": "InsuranceTravelSteps.select_travel_start_date(String)"
});
formatter.result({
  "duration": 10813515325,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Result",
      "offset": 22
    },
    {
      "val": "PASSED",
      "offset": 29
    }
  ],
  "location": "ReportSteps.report_append_note(String,String)"
});
formatter.result({
  "duration": 5533584,
  "status": "passed"
});
});