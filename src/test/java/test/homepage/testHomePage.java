package test.homepage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

public class testHomePage extends BaseTest {

	@Test(priority = 0)
	public void verifyPageTitle() {
		test = extent.createTest("Verify Page Title");
		test.assignCategory("Home Page");
		test.info("Verifying page info");
		
		String originalTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		Assert.assertEquals(originalTitle, expectedTitle);
		
		test.pass("Verify Page Title test completed successfully");
	}

	@Test(priority = 1)
	public void verifyLogo() {
		test = extent.createTest("Verify Logo");
		test.assignCategory("Home Page");
		test.info("Verifying logo");
		
		WebElement logo = driver.findElement(By.xpath("//a[@href = 'https://tutorialsninja.com/demo/index.php?route=common/home']"));
		Assert.assertTrue(logo.isDisplayed());
		
		test.pass("Verify logo test completed successfully");
	}
	
	@Test(priority = 2)
	public void searchBar() throws IOException {
		test = extent.createTest("Verify Search Bar");
		test.assignCategory("Home Page");
		test.info("Verifying search bar");
		
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("/locators.properties"));
		
		WebElement searchBar = driver.findElement(By.xpath(locator.getProperty("searchBar.link")));
		Assert.assertTrue(searchBar.isDisplayed());
		Assert.assertTrue(searchBar.isEnabled());
		test.pass("Verify seacrh bar test completed successfully");
	}

	@Test(priority = 3)
	public void navigator() throws IOException {
		
		test = extent.createTest("Verify Navigator");
		test.assignCategory("Home Page");
		test.info("Verifying navigator");
		
		Properties locator = new Properties();
        locator.load(getClass().getResourceAsStream("/locators.properties"));
        
		WebElement navigator = driver.findElement(By.xpath(locator.getProperty("navigator.link")));
		Assert.assertTrue(navigator.isDisplayed());

		test.pass("Verify navigator test completed successfully");
	}
	
	@DataProvider(name = "categoryData")
	public Object[][] getTestData() throws IOException {
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("/locators.properties"));
		
		Object[][] testData = {
		        {"Desktops", locator.getProperty("desktops.link")},
		        {"Laptops", locator.getProperty("laptops.link")},
		        {"Components", locator.getProperty("components.link")},
		        {"MP3 Players", locator.getProperty("mp3Players.link")}
		    };
		
	    return testData;
	}

	@Test (dataProvider = "categoryData", priority = 4)
	public void navHover (String categoryName, String xpath) throws InterruptedException {
		test = extent.createTest("Verify Hover on Navigator");
		test.assignCategory("Home Page");
		test.info("Verifying haver on navigator");
		
		Actions act = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath(xpath));
		act.moveToElement(hover).perform();
		Thread.sleep(300);
		//hover.click();
		//driver.navigate().back();
		
		test.pass("Verify navigator hover test completed successfully");
	}
}
