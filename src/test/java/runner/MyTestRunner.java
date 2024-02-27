package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/SearchTest.feature",
glue= {"stepdefinitions", "hooks"},
plugin ={"pretty","html:reports/CucumberReports/CucumberReport.html"},
monochrome = true,
publish=true

					)

public class MyTestRunner 

{
	
}
