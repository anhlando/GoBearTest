package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Log;

import java.util.List;

import static utilities.Environment.driver;

public class InsuranceTravelPage extends BasePage {
    @FindBy(xpath = "//div[@class='card-wrapper']")
    List<WebElement> listInsuranceTravelOptions;

    //Filter section
    @FindBy(xpath = "//label[contains(text(),'Promos only')]/parent::div/input")
    WebElement radioFilterByPromosOnly;

    @FindBy(xpath = "//label[contains(text(),'Show all')]/parent::div/input")
    WebElement radioFilterByShowAll;

    @FindBy(xpath = "//label[contains(text(),'Pacific Cross')]/parent::div/input")
    WebElement checkboxFilterByInsurerPacificCross;

    @FindBy(xpath = "//label[contains(text(),'STARR')]/parent::div/input")
    WebElement checkboxFilterByInsurerSTARR;

    @FindBy(xpath = "//label[contains(text(),'Medical expenses while traveling')]//following-sibling::div//input")
    WebElement sliderMedicalExpense;

    //Sort section
    @FindBy(xpath = "//label[contains(text(),'Review score: High to low')]/parent::div/input")
    WebElement radioSortByReviewScoreHighToLow;

    @FindBy(xpath = "//label[contains(text(),'Review score: Low to high')]/parent::div/input")
    WebElement radioSortByReviewScoreLowToHigh;

    //Details section
    @FindBy(xpath = "//label[contains(text(),'annual trip')]/parent::div/input")
    WebElement radioDetails_AnnualTrip;

    @FindBy(xpath = "//label[contains(text(),'single trip')]/parent::div/input")
    WebElement radioDetails_SingleTrip;

    @FindBy(xpath = "//label[contains(text(),'DESTINATION')]//following-sibling::div//button")
    WebElement buttonDropdownDestination;

    @FindBy(xpath = "//label[contains(text(),'DESTINATION')]//following-sibling::div//ul")
    WebElement listDestinations;

    @FindBy(xpath = "//label[contains(text(),'TRAVEL START DATE')]//following-sibling::div//input")
    WebElement dtpStartdate;

    @FindBy(xpath = "//th[@class='today']")
    WebElement buttonStartDate_Today;

    public InsuranceTravelPage() {
        super();
        Log.info(this.getClass().toString() + " is initialized");
        PageFactory.initElements(driver,this);
        Log.info("Init page successfully!!!");
    }

    public int countInsuranceTravelOptions(){
        if (this.listInsuranceTravelOptions != null) {
            return this.listInsuranceTravelOptions.size();
        } else {
            return 0;
        }
    }

    public void filterByShowAll() throws Throwable {
        this.clickObjectByJS(this.radioFilterByShowAll);
        this.wait(5);
    }

    public void filterByPromosOnly() throws Throwable {
        this.clickObjectByJS(this.radioFilterByPromosOnly);
        this.wait(5);
    }

    //Filter section
    public void filterByInsurer(String insurer){
        switch (insurer){
            case "pacific cross":
                this.clickObjectByJS(this.checkboxFilterByInsurerPacificCross);
                break;
            case "starr":
                this.clickObjectByJS(this.checkboxFilterByInsurerSTARR);
                break;
        }

    }

    public boolean verifyResultsByInsurer(String insurer) {
        for (WebElement option: listInsuranceTravelOptions) {
            Log.info("Option: " + option);
            WebElement header = option.findElement(By.xpath("//h4"));
            if (!header.getText().trim().toLowerCase().contains(insurer)){
                return false;
            }
        }
        return true;
    }

    public void setSliderMedicalExpenseValue(int value) {
        try {
            String finalValue = "0," + value;
            Log.info(finalValue);
            this.setAttributeByJS(this.sliderMedicalExpense, "value", finalValue);
            this.wait(10);
            Log.info("Page source: " + driver.getPageSource());
        } catch (Throwable e){
            Log.error(e.getMessage());
        }
    }

    //Sort section
    public void sortByReviewScore(boolean descending){
        if (descending){
            this.clickObjectByJS(this.radioSortByReviewScoreHighToLow);
        } else {
            //sort low to high
//            this.clickObjectByJS(this.radioSortByReviewScoreLowToHigh);
        }
    }

    //Details section
    public void setDetailsPolicyType(String type) throws Throwable {
        if (type.trim().toLowerCase().equals("annual")) {
            this.clickObjectByJS(this.radioDetails_AnnualTrip);
        } else {
            this.clickObjectByJS(this.radioDetails_SingleTrip);
        }
        this.wait(5);
    }

    public void selectDestination(String dest) throws Throwable {
        this.clickObjectByJS(this.buttonDropdownDestination);
        this.wait(5);
        this.selectListItem(this.listDestinations,dest.trim().toLowerCase());
        this.wait(5);
    }

    public void selectStartDate(String date) throws Throwable {
        this.dtpStartdate.sendKeys(date);
        this.wait(5);
    }

    public void selectStartDateAsToday() throws Throwable {
        this.clickObject(this.dtpStartdate);
        this.wait(5);
        this.clickObject(this.buttonStartDate_Today);
        this.wait(5);
    }
}
