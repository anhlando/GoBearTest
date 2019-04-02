package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import utilities.Environment;
import utilities.Helper;
import utilities.Log;

import java.io.File;
import java.util.List;

import static utilities.Environment.driver;

public class BasePage {
    public BasePage() {
        Log.info(this.getClass().toString() + " is initialized");

    }

    public void refresh() {
        PageFactory.initElements(driver, this);
        Log.info("=======   Initial page successfully   =======");
    }

    public void goToUrl(String url){
        driver.get(url.trim());
    }

    public void enterValue(WebElement textbox, String value) {
        Log.info(textbox + " " + value);
        textbox.clear();
        textbox.sendKeys(value);
    }

    public void clickObject(WebElement object) {
        Log.info(object + "");
        object.click();
    }

    public void clickObjectByJS(WebElement object){
        Log.info(object + "");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", object);
    }

    public boolean checkText(WebElement object, String text) {
        Log.info("Expected text: " + text);
        Log.info("Actual text: " + object.getText());
        return object.getText().trim().equals(text);
    }

    public boolean checkAttribute(WebElement object, String attribute, String expectedValue){
        return object.getAttribute(attribute).trim().equals(expectedValue);
    }

    public void setAttributeByJS(WebElement object, String attribute, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0]" +
                ".setAttribute('"
                + attribute.trim().toLowerCase() +"', '"
                + value.trim().toLowerCase() +"')",
                object);
    }

    public void selectListItem(WebElement list, String itemValue){
        List<WebElement> items = list.findElements(By.xpath("//li"));
        //loop through list and click on the expected item
        for (WebElement item:items) {
            if (item.getText().trim().toLowerCase().contains(itemValue)){
                Log.info("Found expected item...");
                WebElement link = item.findElement(By.xpath("//a"));
                this.clickObjectByJS(link);
                break;
            }
        }
    }

    public void wait(int seconds) throws Throwable {
        try {
            Thread.sleep(seconds * 1000);

        } catch (Throwable e) {
            throw e;
        }
    }

    public boolean isElementExist(WebElement element, int sec) throws Throwable {
        int i = 0;
        boolean result = false;
        while (result == false & i < sec) {
            result = element.isDisplayed();
            wait(1);
            i++;
        }
        return result;
    }


    public void screenshot() throws Throwable {
        String fileName = this.getClass().toString().substring(6) + "_" + Helper.getCurrentDate("hhmmss") + ".png";
        String path = Helper.getScreenshotsFolder();
        String fullPath = path + fileName;
        Log.info("Screenshot filepath is initialized: " + fullPath);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            screenshot.renameTo(new File(fullPath));
            Log.info("Screenshot has been saved successfully at: " + fullPath);
        } catch (Throwable e) {
            throw new Throwable("Failed to take screenshot!!! " + e.getMessage());
        }
    }

}
