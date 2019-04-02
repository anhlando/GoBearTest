package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import services.dataServices.DataServiceFactory;
import services.dataServices.IDataService;
import services.reportServices.IReportService;
import services.reportServices.ReportServiceFactory;
import services.FileService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Environment {

    public static JdbcSources dataSources;
    public static Properties settings;
    public static Properties resources;
    public static Properties properties;
    public static Map<String, String> globalVar;
    public static TestReport testReport;
    public static IReportService reportService;
    public static IDataService dataService;
    public static WebDriver driver;

    public void initialize(String env) {
        try {
            //get environment
            generateEnvironmentProperties(env);
            //get settings
            generateSettings();
            //generate resources
            generateResources();
            //generate jdbc templates
            generateJdbcSources();
            //init testReport
            testReport = new TestReport();
            //init reportService based on the setting
            generateReportService();
            //init dataService
            generateDataService();
            //init globalVar
            globalVar = new HashMap<String, String>();
            //generate WebDriver
            generateWebDriver();

        } catch (Throwable e) {
            Log.error("Exception: " + e.getMessage());
        }
    }

    private void generateWebDriver() {
        try{
            String driverType = settings.getProperty("driver").trim().toLowerCase();
            Log.info("Driver type: " + driverType);
            switch (driverType){
                case "chrome":
                    System.getProperty("webdriver.chrome.driver","${basedir}/lib/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.getProperty("webdriver.firefox.marionette","${basedir}/lib/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }catch (Throwable e){
            Log.error(e.getMessage());
        }
    }

    private void generateDataService() {
        try {
            dataService = DataServiceFactory.getDataService(Environment.settings.getProperty("dataservice.type"));
            Log.info("Data service has been generated (type = '" + Environment.settings.getProperty("dataservice.type") + "')");
        } catch (Throwable e) {
            Log.error(e.getMessage());
        }
    }


    private void generateEnvironmentProperties(String env) {
        InputStream inputStream = null;
        String propFileName;
        try {
            if (env.trim().toLowerCase().equals("qc")) {
                propFileName = "environment.qc.properties";
            } else if (env.trim().toLowerCase().equals("staging")) {
                propFileName = "environment.staging.properties";
            } else {
                propFileName = "environment.properties";
            }
            this.properties = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            this.properties.load(inputStream);
            inputStream.close();
            Log.info("Environment [" + env + "]'s properties have been loaded successfully");
        } catch (Throwable e) {
            Log.error(e.getMessage());
        }
    }

    private void generateSettings() {
        InputStream inputStream = null;
        try {
            this.settings = new Properties();
            String propFileName = "settings.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            this.settings.load(inputStream);
            inputStream.close();

        } catch (Throwable e) {
            Log.error("Exception: " + e.getMessage());
        }
    }

    private void generateResources() {
        InputStream inputStream = null;
        try {
            this.resources = new Properties();
            String propFileName = "resources.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            this.resources.load(inputStream);
            inputStream.close();

        } catch (Throwable e) {
            Log.error("Exception: " + e.getMessage());
        }
    }

    private void generateJdbcSources() {
        try {
            dataSources = new JdbcSources(settings);
        } catch (Throwable e) {
            Log.error("Exception: " + e.getMessage());
        }
    }

    private void generateReportService() {
        try {
            reportService = ReportServiceFactory.getReportService(Environment.settings.getProperty("report.method"));
            Log.info("Report service has been generated (method = '" + Environment.settings.getProperty("report.method") + "')");
        } catch (Throwable e) {
            Log.error(e.getMessage());
        }
    }

    public void cleanup() {
        try {
            driver.quit();
            Log.info("Driver is stopped successfully!!!");
        } catch (Throwable e) {
            Log.error("Exception: " + e.getMessage());
        }

    }

}
