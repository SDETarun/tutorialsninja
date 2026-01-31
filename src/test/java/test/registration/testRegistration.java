package test.registration;

import java.io.IOException;
import org.testng.annotations.Test;

import base.BaseTest;

public class testRegistration extends BaseTest {

	@Test
	public void testRegister() throws IOException {
		
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "registrationLink.link");
		
		String firstName = regPage.randomStringValue();
		regPage.enterText(driver, "firstName.link", firstName);
		
		String lastName = regPage.randomStringValue();
		regPage.enterText(driver, "lastName.link", lastName);
		
		String email = firstName + lastName + "@gmail.com";
		regPage.enterText(driver, "email.link", email);
		
		String telephone = regPage.randomIntegerValue();
		regPage.enterText(driver, "telephone.link", telephone);
		
		regPage.enterText(driver, "password.link", firstName+lastName);
		
		regPage.enterText(driver, "confirmPassword.link", firstName+lastName);
		
		regPage.clickButton(driver, "privacy.link");
		
		regPage.clickButton(driver, "continue.link");
		
	}
	
	@Test
	public void logout() throws IOException {
		pages.registration.pageRegistration regPage = new pages.registration.pageRegistration();
		regPage.clickButton(driver, "myAccount.link");
		regPage.clickButton(driver, "logout.link");
	}
	
	
	
}
