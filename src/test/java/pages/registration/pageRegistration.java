package pages.registration;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class pageRegistration {
	
	//Enter Value in text field
	public void enterText(WebDriver driver,String locatorKey, String value) throws IOException {
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("/locators.properties"));
		String actualXpath = locator.getProperty(locatorKey);
		WebElement textField = driver.findElement(By.xpath(actualXpath));
		textField.sendKeys(value);
	}
	
	//Click on the button
	public void clickButton(WebDriver driver, String locatorKey) throws IOException {
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("/locators.properties"));
		String actualXpath = locator.getProperty(locatorKey);
		WebElement button = driver.findElement(By.xpath(actualXpath));
		button.click();
	}
	

	public String randomStringValue() {
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();

	    int length = 8; // change length if needed

	    for (int i = 0; i < length; i++) {
	        sb.append(chars.charAt(random.nextInt(chars.length())));
	    }
	    return sb.toString();
	}
	
	public String randomIntegerValue() {
	    String chars = "0123456789";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();

	    int length = 8; // change length if needed

	    for (int i = 0; i < length; i++) {
	        sb.append(chars.charAt(random.nextInt(chars.length())));
	    }
	    return sb.toString();
	}
	
	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void assertData(WebDriver driver, String locatorKey) throws IOException {
		
		Properties locator = new Properties();
		locator.load(getClass().getResourceAsStream("/locators.properties"));
		
		String actualXpath = locator.getProperty(locatorKey);
		
		WebElement warning = driver.findElement(By.xpath(actualXpath));
		Assert.assertEquals(warning.isDisplayed(), true);
	}
	
}
