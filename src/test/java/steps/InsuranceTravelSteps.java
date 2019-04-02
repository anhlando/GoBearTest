package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.InsuranceTravelPage;
import utilities.Log;

public class InsuranceTravelSteps {
    InsuranceTravelPage insuranceTravelPage;

    public InsuranceTravelSteps() {
        this.insuranceTravelPage = new InsuranceTravelPage();
    }

    @Then("^I see Insurance Travel page displays with at least \\((\\d+)\\) options$")
    public void check_number_of_results_found(int minAmountOfInsuranceTravelOptions) throws Throwable {
        Log.info("Actual count: " + insuranceTravelPage.countInsuranceTravelOptions());
        Assert.assertTrue(insuranceTravelPage.countInsuranceTravelOptions() >= minAmountOfInsuranceTravelOptions);
    }

    @When("^I filter Insurance Travel results by Insurer: (.*)$")
    public void filter_by_insurer(String insurer) throws Throwable {
        insuranceTravelPage.filterByInsurer(insurer.trim().toLowerCase());
        insuranceTravelPage.wait(5);
    }

    @Then("^I see Insurance Travel page displays with results of: (.*)$")
    public void check_insurance_travel_results_by_insurers(String insurer) throws Throwable {
        boolean result = insuranceTravelPage.verifyResultsByInsurer(insurer.trim().toLowerCase());
        Assert.assertTrue(result);
    }

    @When("^I filter Insurance Travel results by Promos only$")
    public void FilterInsuranceTravelResultsByPromosOnly() throws Throwable {
        insuranceTravelPage.filterByPromosOnly();
    }

    @When("^I filter Insurance Travel results by Show all$")
    public void iFilterInsuranceTravelResultsByShowAll() throws Throwable {
        insuranceTravelPage.filterByShowAll();
    }

    @Then("^I see Insurance Travel page displays with \\((\\d+)\\) options$")
    public void check_exact_number_of_results_found(int amountOfInsuranceTravelOptions) throws Throwable {
        Log.info("Actual count: " + insuranceTravelPage.countInsuranceTravelOptions());
        Assert.assertTrue(insuranceTravelPage.countInsuranceTravelOptions() == amountOfInsuranceTravelOptions);
    }

    @When("^I set Medical Expense value to: (\\d+)$")
    public void set_medical_expense(int value) throws Throwable {
        insuranceTravelPage.setSliderMedicalExpenseValue(value);
    }

    @When("^I sort Insurance Travel results by Review score: (.*)$")
    public void sort_by_review_score(String order) throws Throwable {
        boolean desc = !(order.trim().toLowerCase().equals("asc"));
        insuranceTravelPage.sortByReviewScore(desc);
        insuranceTravelPage.wait(5);
    }

    @When("^I set details - policy type: (.*)$")
    public void set_details_by_policy_type(String type) throws Throwable {
        insuranceTravelPage.setDetailsPolicyType(type);
        insuranceTravelPage.wait(5);
    }

    @When("^I select destination: (.*)$")
    public void select_destination(String dest) throws Throwable {
        insuranceTravelPage.selectDestination(dest);
    }

    @When("^I select travel start date: (.*)$")
    public void select_travel_start_date(String date) throws Throwable {
        if (date.trim().toLowerCase().equals("today")){
            insuranceTravelPage.selectStartDateAsToday();
        }
    }
}
