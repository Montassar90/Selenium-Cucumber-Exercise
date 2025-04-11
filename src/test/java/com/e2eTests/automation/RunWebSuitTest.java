package com.e2eTests.automation;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" },
plugin = {"com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
		"com.e2eTests.automation.utils.Listener"},
glue = { "com.e2eTests.automation.stepDefinition",
		"com.e2eTests.automation.hooks"},
tags = (""), 
monochrome = true, 
snippets = CAMELCASE)
public class RunWebSuitTest {

}