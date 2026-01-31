package test.registration;

import java.io.IOException;
import org.testng.annotations.Test;

import base.BaseTest;

public class testRegistration extends BaseTest {

	@Test (priority = 0)
	public void testRegister() throws IOException {
		
		test = extent.createTest("Registration Test");
		test.assignCategory("Registration");
		test.info("Starting registration test");
		
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "registrationLink.link");
		
		test.info("Entering First Name");
		String firstName = regPage.randomStringValue();
		regPage.enterText(driver, "firstName.link", firstName);
		
		test.info("Entering Last Name");
		String lastName = regPage.randomStringValue();
		regPage.enterText(driver, "lastName.link", lastName);
		
		test.info("Entering Email");
		String email = firstName + lastName + "@gmail.com";
		regPage.enterText(driver, "email.link", email);
		
		test.info("Entering Telephone number");
		String telephone = regPage.randomIntegerValue();
		regPage.enterText(driver, "telephone.link", telephone);
		
		test.info("Entering Password");
		regPage.enterText(driver, "password.link", firstName+lastName);
		
		test.info("Entering Confirmation Password");
		regPage.enterText(driver, "confirmPassword.link", firstName+lastName);
		
		test.info("Clicking Privacy Button ");
		regPage.clickButton(driver, "privacy.link");
		
		test.info("Clicking Submit Button ");
		regPage.clickButton(driver, "continue.link");
		
		test.pass("Registration test completed successfully");
		
	}
	
	@Test(priority = 1)
	public void logout() throws IOException {
		
		test = extent.createTest("Logout Test");
		test.assignCategory("Registration");
		test.info("Staring Loging out test");
		test.getStatus();
		
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "logout.link");

		test.pass("Logout test completed successfully");

	}
	
	
	
}
