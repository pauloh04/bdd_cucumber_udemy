package br.com.paulo.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "br.com.paulo.steps", 
		tags = {"@unitarios"},
		// plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		plugin = {"pretty"},
		monochrome = true, 
		dryRun = false,
		snippets = SnippetType.CAMELCASE)
public class RunnerTest {
	
}