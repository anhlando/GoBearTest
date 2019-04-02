package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import pages.BasePage;
import utilities.Helper;
import utilities.Log;

public class GeneralSteps {
    BasePage page;

    public GeneralSteps() {
        this.page = new BasePage();
    }

    @Given("^I go to url: (.*)$")
    public void goToUrl(String url) throws Throwable {
        String destUrl = Helper.getBaseUrl() + url;
        Log.info(destUrl);
        this.page.goToUrl(destUrl.trim());
        this.page.wait(5);
    }
}
