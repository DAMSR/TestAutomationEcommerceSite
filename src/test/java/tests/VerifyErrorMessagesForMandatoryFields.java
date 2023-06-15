package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.createAnAccountPage;
import pages.loginPage;
import pages.mainPage;
import util.BrowserFactory;

/*Test Case - Verify error messages for mandatory fields.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter email address and click Register button.
4. Leave the mandatory fields (marked with *) blank and click Register button.
5. Verify that error has been displayed for the mandatory fields.*/

public class VerifyErrorMessagesForMandatoryFields {

	WebDriver driver;

	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}

	@Test
	public void TestVerifyErrorMessagesForMandatoryFields() {
		mainPage mainp = PageFactory.initElements(driver, mainPage.class);
		mainp.clickOnSignInButton();

		loginPage loginp = PageFactory.initElements(driver, loginPage.class);
		loginp.fillCreatAccountEmailField();
		loginp.clickCreateAnAccountButton();

		createAnAccountPage createaccp = PageFactory.initElements(driver, createAnAccountPage.class);
		createaccp.clickRegisterButton();
		createaccp.verifyErrorAlertForMandatoryFields();

	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}

}
