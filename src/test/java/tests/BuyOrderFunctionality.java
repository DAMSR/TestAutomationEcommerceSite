package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.mainPage;
import pages.myAccountPage;
import pages.OrderPage;
import pages.productPage;
import pages.tshirtsPage;
import util.browserFactory;
import util.excelReader;

/*Test Case - Automate End to End Buy Order functionality.

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.*/

public class BuyOrderFunctionality {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = browserFactory.launchBrowser();
	}

	// The actual Test
	@Test
	public void TestBuyOrderFunctionality() throws InterruptedException {
		
		excelReader reader = new excelReader("./data/testdata.xlsx");
		String username = reader.getCellData("LoginInfo", "username", 2);
		String password = reader.getCellData("LoginInfo", "password", 2);

		mainPage MainP = PageFactory.initElements(driver, mainPage.class);
		MainP.clickOnSignInButton();

		// 2. Login to the website.
		loginPage LoginP = PageFactory.initElements(driver, loginPage.class);
		LoginP.enterEMailAddress(username);
		LoginP.enterPassword(password);
		LoginP.clickSigninButton();

		myAccountPage MyAcc = PageFactory.initElements(driver, myAccountPage.class);
		// 3. Move your cursor over Women's link.
		MyAcc.hoverOverWomenButton();
		// 4. Click on sub menu 'T-shirts'.
		MyAcc.clickTshirtsButton();

		tshirtsPage ts = PageFactory.initElements(driver, tshirtsPage.class);
		// 5. Mouse hover on the first product displayed.
		ts.hoverOverProduct();
		// 6. 'More' button will be displayed, click on 'More' button.
		ts.clickMoreButtonProductOne();

		productPage ProdP = PageFactory.initElements(driver, productPage.class);
		// 7. Increase quantity to 2.
		ProdP.enterQuantity("2");
		// 8. Select size 'L'
		ProdP.selectSize("L");
		// 9. Select color.
		ProdP.selectColor();
		// 10. Click 'Add to Cart' button.
		ProdP.clickAddToCartButton();
		// 11. Click 'Proceed to checkout' button.
		ProdP.clickProceedToCheckoutButton();

		// 12. Complete the buy order process till payment.
		OrderPage OrderP = PageFactory.initElements(driver, OrderPage.class);
		OrderP.clickProceedToCheckout();
		OrderP.clickProceedToCheckoutAddressPage();
		OrderP.clickCheckBoxAgreeToTermsShippingPage();
		OrderP.clickProceedToCheckoutShippingPage();
		OrderP.clickPayByBankWirePaymentPage();
		OrderP.clickIConfirmMyOrderPage();
		// 13. Make sure that Product is ordered.
		OrderP.assertOrderConfirmation();

	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		browserFactory.CloseBrowser();
	}

}