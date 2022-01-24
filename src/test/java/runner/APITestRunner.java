package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue= {"stepDefinitions"},
tags = {"@apiregression"},
//monochrome= true,
plugin = {"pretty", "junit:target/API/JUnitReports/apireport.xml",
		"json:target/API/JSONReports/apireport.json",
		"html:target/API/APIHtmlReports"}
		)
public class APITestRunner {

}