package test.registration;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;

public class testNegativeRegistration extends BaseTest {

	@Test(priority = 1)
	public void duplicateRegister() throws IOException {

		test = extent.createTest("Duplicate Registration Test");
		test.assignCategory("Test Negative Registration Scenario");
		test.info("Verifying duplicate registration test");
		
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "registrationLink.link");

		//String firstName = regPage.randomStringValue();
		regPage.enterText(driver, "firstName.link", "qwerty");

		//String lastName = regPage.randomStringValue();
		regPage.enterText(driver, "lastName.link", "qwerty");

		String email = "qwerty525@gmail.com";
		regPage.enterText(driver, "email.link", email);

		String telephone = regPage.randomIntegerValue();
		regPage.enterText(driver, "telephone.link", telephone);

		regPage.enterText(driver, "password.link", "qwerty@123");

		regPage.enterText(driver, "confirmPassword.link", "qwerty@123");

		regPage.clickButton(driver, "privacy.link");

		regPage.clickButton(driver, "continue.link");

		regPage.assertData(driver, "emailRegisteredWarning");
		
		regPage.backPage(driver);
		
		test.pass("Verify dupliate registration completed successfully");

	}
	
	@Test(priority = 0)
	public void emptyFields() throws IOException{
		
		test = extent.createTest("Empty Fields Registration Test");
		test.assignCategory("Test Negative Registration Scenario");
		test.info("Verifying empty fields");
		
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "registrationLink.link");
		
		regPage.clickButton(driver, "continue.link");

		regPage.assertData(driver, "emailRegisteredWarning");
		
		test.pass("Verify empty fields completed successfully");
	}
}
