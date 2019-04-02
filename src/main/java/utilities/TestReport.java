package utilities;

import java.util.Map;

public class TestReport {

    private String listOfScenarios;
    private String summary;
    private String note;

    private int numberOfScenarios;
    private int numberOfPassedScenarios;
    private int executionTime;

    public TestReport() {
        this.listOfScenarios = "<table border=\"1\">\n" +
                                "    <thead style=\"background-color:{HEADER_COLOR};\">\n" +
                                "        <th></th>\n" +
                                "        <th>Testcase ID</th>\n" +
                                "        <th>Testcase description</th>\n" +
                                "        <th>Test result</th>\n" +
                                "        <th>Error</th>\n" +
                                "        <th>Execution time</th>\n" +
                                "        <th>Note</th>\n" +
                                "    </thead>\n";
        this.numberOfScenarios = 0;
        this.numberOfPassedScenarios = 0;
        this.executionTime = 0;
        this.summary = "";
        this.note = "";
    }

    public void addTestScenario(TestScenario scenario){
        if (scenario!=null){
            this.listOfScenarios += "<tr>\n" +
                                    "   <td>" + (this.numberOfScenarios + 1) + "</td>\n" +
                                    "   <td>" + scenario.getId() + "</td>\n" +
                                    "   <td>" + scenario.getDescription() + "</td>\n" +
                                    "   <td>" + scenario.getResult() + "</td>\n" +
                                    "   <td>" + scenario.getErrorCode() + " - " + scenario.getErrorMessage() + "</td>\n" +
                                    "   <td>" + scenario.getExecutionTime() + "s" + "</td>\n" +
                                    "   <td>" + this.generateNote(scenario.getNotes()) + "</td>\n" +
                                    "</tr>\n";
            this.numberOfScenarios++;
            this.numberOfPassedScenarios += (scenario.getResult().trim().toLowerCase().equals("passed") ? 1 : 0);
            this.executionTime += scenario.getExecutionTime();
        }
    }

    private String generateNote(Map<String, String> notes) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,String> note : notes.entrySet() ){
            result.append(" - " + note.getKey());
            result.append(": ");
            result.append(note.getValue());
            result.append("<br/>");
        }
        return result.toString();
    }

    private void generateSummary(){
        int percentageOfPassed = (int) ((this.numberOfPassedScenarios * 100.0f) / this.numberOfScenarios);
        this.summary += "<br> - Number of testcases: " + this.numberOfScenarios +
                        "<br> - PASSED: " + this.numberOfPassedScenarios +

                        " (~" + percentageOfPassed + "%)" +
                        "<br> - Execution time: " + this.executionTime +
                        "<br>Details: ";
    }

    private void setHeaderColor(){
        try{
            this.listOfScenarios = this.listOfScenarios.replace("{HEADER_COLOR}",this.generateHeaderColor());
            Log.info(this.listOfScenarios);
        }
        catch (Throwable e){
            throw e;
        }
    }

    private String generateHeaderColor() {
        try{
            int percentageOfPassed = (int) ((this.numberOfPassedScenarios * 100.0f) / this.numberOfScenarios);
            if (percentageOfPassed == 100){                                  //100%
                return "#00ff00";                                           //green
            }
            else if (percentageOfPassed >= 70){                             //70% - 99%
                return "#6699ff";                                           //light blue
            }
            else if (percentageOfPassed >= 40){                             //40% - 69%
                return "#ffcc00";                                           //yellow
            }
            else if (percentageOfPassed >= 10){                             //10% - 39%
                return "#ff00ff";                                           //fuchsia
            }
            else if (percentageOfPassed > 1){                               //1% - 9%
                return "#ff5c33";                                           //almost red
            }
            else {                                                          //0%
                return "#ff0000";                                            //red
            }
        }
        catch (Throwable e){
            throw e;
        }
    }

    public String toString(){
        this.generateSummary();
        this.setHeaderColor();
        return this.summary +
                this.listOfScenarios +
                "</table>";
    }
}
