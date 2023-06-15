package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate User Registration Process

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.*/

public class UserRegistrationProcess {
	WebDriver driver;

	// 1. Open this url http://automationpractice.com/index.php
	// 2. Click on sign in link.
	// Starting browser and navigating to website
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}


	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}
}
