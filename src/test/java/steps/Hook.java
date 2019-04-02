package steps;

import cucumber.api.java.Before;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import utilities.Environment;
import utilities.Log;
import utilities.TestExecution;
import utilities.TestScenario;

import java.util.List;

public class Hook implements Formatter,Reporter {

    @Override
    public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {

    }

    @Override
    public void uri(String uri) {

    }

    @Override
    public void feature(Feature feature) {
        Log.info("Start testing feature: " + feature.getName());
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {

    }

    @Override
    public void examples(Examples examples) {
        examples.getRows().get(0);
    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
        Log.startTest();
        TestExecution.testScenario = new TestScenario();
    }

    @Override
    public void background(Background background) {

    }

    @Override
    public void scenario(Scenario scenario) {

    }

    @Override
    public void step(Step step) {
    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
        Log.endTest();
        Environment.testReport.addTestScenario(TestExecution.testScenario);

    }

    @Override
    public void done() {
        Log.info("Done");
    }

    @Override
    public void close() {
        Log.info("Closed");
    }

    @Override
    public void eof() {
        Log.info("Eof");
    }

    @Override
    public void before(Match match, Result result) {
    }

    @Override
    public void result(Result result) {
        Log.info(result.getStatus() + " duration: " + (result.getDuration()/1000));
    }

    @Override
    public void after(Match match, Result result) {

    }

    @Override
    public void match(Match match) {

    }

    @Override
    public void embedding(String mimeType, byte[] data) {

    }

    @Override
    public void write(String text) {

    }
}
