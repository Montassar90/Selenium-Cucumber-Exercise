package com.e2eTests.automation;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/spec/features" },
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
tags = ("@Signup"), 
monochrome = true, 
snippets = CAMELCASE)
public class RunWebSuitTest {

}
