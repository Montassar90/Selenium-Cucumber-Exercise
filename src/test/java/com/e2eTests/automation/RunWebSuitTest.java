package com.e2eTests.automation;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/spec/features" }, 
plugin = { "pretty","html:target/html-report.html" }, 
tags = (""), 
monochrome = true, 
snippets = CAMELCASE)
public class RunWebSuitTest {

}
