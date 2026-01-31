package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeClass
	public void setup() throws IOException {
		Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/config.properties"));

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(props.getProperty("url"));
		
		extent = ExtentManager.getExtent();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Output.html");
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void updateReport() {
		ExtentManager.getExtent().flush();

	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
