package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.mainPage;
import pages.tshirtsPage;
import util.browserFactory;

/*Test Case - Verify that 'Add to Wishlist' only works after login.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Move your cursor over Women's link.
3. Click on sub menu 'T-shirts'.
4. Mouse hover on the second product displayed.
5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
6. Verify that error message is displayed 'You must be logged in to manage your wishlist.'*/

public class WishListWorksAfterLogin {
	WebDriver driver;

	//1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = browserFactory.launchBrowser();
	}

	@Test
	public void TestWishListWorksAfterLohin() throws InterruptedException {

		mainPage MainP = PageFactory.initElements(driver, mainPage.class);
		// 2. Move your cursor over Women's link.
		MainP.hoverOverWomenButton();
		// 3. Click on sub menu 'T-shirts'.
		MainP.clickTshirtsButton();

		tshirtsPage ts = PageFactory.initElements(driver, tshirtsPage.class);
		// 4. Mouse hover on the second product displayed.
		ts.hoverOverProduct();
		// 5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
		ts.clickWishlistProduct();
		//6. Verify that error message is displayed
		ts.verifyWishlistErrorBox();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void CloseBrowser() {
		browserFactory.CloseBrowser();
	}
}
