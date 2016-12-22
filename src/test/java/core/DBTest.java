package core;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import net.sf.testng.databinding.*;

public class DBTest {
	WebDriver driver;

	@BeforeClass
	public void browserOpen() throws InterruptedException {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void browserQuit() throws InterruptedException {
		driver.quit();
	}

	@DataBinding
	@Test

	public void titleValidation(
			@TestInput(name = "csv_id") String id, 
			@TestInput(name = "csv_url") String url,
			@TestInput(name = "csv_title_expected") String title_expected) {

		driver.get(url);
		String title_actual = driver.getTitle();

		assertThat(title_actual, is(title_expected));
	}

}