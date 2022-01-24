package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue= {"stepDefinitions"},
tags = {"@regression"},
plugin = {"pretty", "junit:target/UI/JUnitReports/uireport.xml",
		"json:target/UI/JSONReports/uireport.json",
		"html:target/UI/UIHtmlReports"},
monochrome = true)
public class UITestRunner {

}