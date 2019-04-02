package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import services.ParsingService;
import utilities.Log;
import utilities.TestExecution;

public class ReportSteps {
    @Given("^Testcase-ID \\((.*)\\) - Testcase description \\((.*)\\)$")
    public void set_testcase_ID(String testcaseID, String testcaseDesc) throws Throwable {
        TestExecution.testScenario.setId(testcaseID);
        TestExecution.testScenario.setDescription(testcaseDesc);
        Log.info("Testcase ID: " + TestExecution.testScenario.getId() + " - Testcase description: " + TestExecution.testScenario.getDescription());
    }


    @Then("^report - append note \\((.*);(.*)\\)$")
    public void report_append_note(String key, String value) throws Throwable {
        String parsedValue = ParsingService.parseParam(value);
        TestExecution.testScenario.getNotes().put(key,parsedValue);
    }
}
