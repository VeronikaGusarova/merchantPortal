package com.epam.nwi.merchant_portal_at.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) - JUnit
@CucumberOptions(features = { "src/test/java/com/epam/nwi/merchant_portal_at/features" }, plugin = {
		"html:target/site/cucumber-html-report",
		"json:target/cucumber-json-report.json" }, glue = { "com.epam.nwi.merchant_portal_at.steps" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
