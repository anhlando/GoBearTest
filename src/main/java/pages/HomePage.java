package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Environment;
import utilities.Log;

import java.util.List;

import static utilities.Environment.driver;

public class HomePage extends BasePage {
    @FindBy(xpath = "//li[@role='presentation' and @data-gb-name='Loans']")
    WebElement sectionLoans;

    @FindBy(xpath = "//li[@role='presentation' and @data-gb-name='CreditCards']")
    WebElement sectionCreditCards;

    @FindBy(xpath = "//li[@role='presentation' and @data-gb-name='Insurance']")
    WebElement sectionInsurance;

    @FindBy(xpath = "//li[@role='presentation' and @data-gb-name='Travel']")
    WebElement sectionInsuranceTravel;

    @FindBy(xpath = "//button[@type='button' and @name='product-form-submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//button[@type='button' and @name='product-form-reset']")
    WebElement buttonReset;

    @FindBy(xpath = "//div[@data-gb-name='travel-form-country']//ul")
    WebElement listCountries;

    @FindBy(xpath = "//div[@data-gb-name='travel-form-country']//button")
    WebElement buttonSelectCountry;

    @FindBy(xpath = "(//div[@gb-data-name='car-info']//button)[1]")
    WebElement buttonSelectCar;


    public HomePage() {
        super();
        Log.info(this.getClass().toString() + " is initialized");
        PageFactory.initElements(driver,this);
        Log.info("Init page successfully!!!");
    }

    public boolean isSectionLoansSelected(){
        return this.checkAttribute(this.sectionLoans,"class","active");
    }

    private boolean isSectionInsuranceSelected() {
        return this.checkAttribute(this.sectionInsurance,"class","active");
    }

    public boolean isSectionInsuranceTravelSelected(){
        return this.checkAttribute(this.sectionInsuranceTravel,"class","active");
    }

    public void selectSectionLoans(){
        if (!isSectionLoansSelected()) {
            this.clickObject(this.sectionLoans);
        }
    }

    public void selectSectionInsurance(){
        if (!isSectionInsuranceSelected()) {
            this.clickObject(this.sectionInsurance);
        }
    }

    public void selectSectionInsuranceTravel(){
        if (!isSectionInsuranceTravelSelected()) {
            this.clickObject(this.sectionInsuranceTravel);
        }
    }

    public void selectCountry(String country){
        try{
            Log.info("Country: " + country);
            Log.info("Driver: " + driver);
            driver.wait(10);
            String pageSource = driver.getPageSource();
            Log.info("Page source: " + pageSource);
//            List<WebElement> countries = this.listCountries.findElements(By.tagName("li"));
//            for (WebElement item:countries) {
//                if (item.getText().trim().equals(country)){
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
//                    this.clickObject(item);
//                }
//            }
        }catch (Throwable e){
            Log.error(e.getStackTrace().toString());
        }
    }

    public void resetForm(){
        this.clickObject(buttonReset);
    }

    public void submitForm(){
        this.clickObject(buttonSubmit);
    }

    public void submit() {
        try{
            this.clickObject(this.buttonSubmit);
        }catch (Throwable e){
            throw e;
        }
    }
}
