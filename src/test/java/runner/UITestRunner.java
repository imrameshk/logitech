package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue= {"stepDefinitions"},
tags = {"@regression"},
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports"},
monochrome = true)
public class UITestRunner {

}