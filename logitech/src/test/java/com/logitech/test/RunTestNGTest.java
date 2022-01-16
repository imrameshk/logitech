package com.logitech.test;

import org.testng.annotations.BeforeClass;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src\test\resources\features",
glue = "stepDefinitions",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags="@testcase1")
public class RunTestNGTest extends AbstractTestNGCucumberTests{

	private TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	  testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
}
