package br.com.paulo.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/aprender-cucumber.feature", 
		glue = "br.com.paulo.steps", 
//		tags = "@esse",
//		tags = "~@ignore",
		plugin = "pretty", 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE)
public class Runner {

}
