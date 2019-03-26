package br.com.paulo.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "br.com.paulo.steps", 
		tags = {"@funcionais"},
		// plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		plugin = {"pretty"},
		monochrome = true, 
		dryRun = true,
		snippets = SnippetType.CAMELCASE)
public class RunnerFuncionalTest {
	
	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("pauloo@yahoo.com");
		driver.findElement(By.id("senha")).sendKeys("09032003");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
	
}