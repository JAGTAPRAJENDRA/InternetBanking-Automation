package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;//
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(//
    features = "src/test/resources/features/login/Login.feature",//to specify the location of the feature files
    glue = {"stepdefinitions", "hooks"},//to specify the location of the step definitions and hooks
    plugin = {
    		
        "pretty",
        "html:target/cucumber-report.html",//to generate an HTML report of the test execution
        "json:target/cucumber.json",
        "junit:target/cucumber.xml",
        "rerun:target/failed_scenarios.txt"//to generate a text file with the failed scenarios for easy rerun
        
    }
    
 //   dryRun=true,//Dry Run checks missing step definitions without executing tests
 //   monochrome=true//to make the console output more readable by removing unnecessary characters
    
   // tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

