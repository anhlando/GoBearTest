import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.Environment;
import utilities.Helper;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = {"@gobear"},
        plugin = {"steps.Hook"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

@RunWith(Cucumber.class)
public class RunnerTest {
    private static Environment environment;

    @BeforeClass
    public static void beforeAll() {
        String env = System.getProperty("env");
        //String env = "c1";
        if (env != null && !env.equals("")) {
            Log.info("Start test...");
            Log.info("Environment: " + env);
            environment = new Environment();
            environment.initialize(env);
        }
        else {
//            Log.error("No environment has been specified!!! Test is terminated!!!");
//            Environment.reportService.generateReport(Environment.testReport.toString());
//            System.exit(1);
            environment = new Environment();
            environment.initialize("qc");
        }
    }

    @AfterClass
    public static void afterAll() {
        Log.info("End test...");
        environment.cleanup();
        environment.reportService.generateReport(Environment.testReport.toString());

    }
}
