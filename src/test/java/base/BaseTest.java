package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;

	@BeforeClass
	public void setup() throws IOException {
		Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/config.properties"));

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(props.getProperty("url"));
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
