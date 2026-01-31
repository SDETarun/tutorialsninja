package pages.homepage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

public class homepage extends BaseTest {

	@Test
	public void verifyPageTitle() {
		String originalTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		Assert.assertEquals(originalTitle, expectedTitle);
	}

	@Test
	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//a[@href = 'https://tutorialsninja.com/demo/index.php?route=common/home']"));
		Assert.assertTrue(logo.isDisplayed());
	}

	@Test
	public void navigator() throws IOException {
		Properties locator = new Properties();
        locator.load(getClass().getResourceAsStream("/locators.properties"));
        
		WebElement navigator = driver.findElement(By.xpath(locator.getProperty("navigator.link")));
		Assert.assertTrue(navigator.isDisplayed());
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

	@Test (dataProvider = "categoryData")
	public void navHover (String categoryName, String xpath) throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath(xpath));
		act.moveToElement(hover).perform();
		Thread.sleep(300);
		//hover.click();
		//driver.navigate().back();
	}
	
	@Test
	public void searchBar() throws IOException {
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("locator.properties"));
		
		WebElement searchBar = driver.findElement(By.xpath(locator.getProperty("searchBar.link")));
		Assert.assertTrue(searchBar.isDisplayed());
		Assert.assertTrue(searchBar.isEnabled());
	}
}
