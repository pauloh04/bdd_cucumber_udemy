import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teste {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chrome-driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com");
	}
}