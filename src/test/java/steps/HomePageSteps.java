package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pages.HomePage;
import utilities.Log;

public class HomePageSteps {
    HomePage homePage;

    public HomePageSteps() {
        Log.info("Init homepage steps...");
        this.homePage = new HomePage();
    }

    @When("^I select section: (.*)$")
    public void select_section(String section) throws Throwable {
        try{
            switch (section.trim().toLowerCase()){
                case "loans":
                    homePage.selectSectionLoans();
                    break;
                case "insurance":
                    homePage.selectSectionInsurance();
                    break;
                case "insurance_travel":
                    homePage.selectSectionInsuranceTravel();
                    break;
            }
            homePage.wait(5);
        } catch (Throwable e){
            Log.error(e.getMessage());
        }
    }

    @And("^I select country: (.*)$")
    public void select_coutry(String country) throws Throwable {
        homePage.selectCountry(country);
        homePage.wait(5);
    }

    @And("^I click Submit$")
    public void iClickSubmit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.submit();
        homePage.wait(10);
    }
}
