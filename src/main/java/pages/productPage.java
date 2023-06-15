package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class productPage extends basePage {

	WebDriver driver;
	double DblCurrentTotal;

	public productPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='quantity_wanted']")
	WebElement quantityWanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group_1']")
	WebElement sizeSelection;
	@FindBy(how = How.XPATH, using = "//a[@id='color_14']")
	WebElement selectColor;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")
	WebElement addToCartButton;
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	WebElement proceedToCheckoutButton;
	@FindBy(how = How.XPATH, using = "//a[@class='cart_quantity_up btn btn-default button-plus']")
	WebElement increaseQuantityButton;
	@FindBy(how = How.XPATH, using = "//td[@class='cart_total']//span")
	WebElement TotalProductPrice;
	@FindBy(how = How.XPATH, using = "//td[@data-title='Unit price']//span//span")
	WebElement ProductPrice;

	// InteractiveMethods
	public void enterQuantity(String quantity) {
		quantityWanted.clear();
		quantityWanted.sendKeys(quantity);
	}

	public void selectSize(String Size) {
		selectFromDropdownByVisibleText(sizeSelection, Size);
	}

	public void selectColor() {
		selectColor.click();
	}

	public void clickAddToCartButton() {
		addToCartButton.click();
	}

	public void clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}

	public void clickIncreaseQuantityButton() {
		increaseQuantityButton.click();
	}

	public void TestTotalCalculation() throws InterruptedException {

		double DblCurrentTotal = convertStringToDouble(TotalProductPrice);
		
		clickIncreaseQuantityButton();
		
		double DblProductPrc = convertStringToDouble(ProductPrice);

		Thread.sleep(2000);

		double DblModifiedTotal = convertStringToDouble(TotalProductPrice);
		
		if (DblCurrentTotal + DblProductPrc == DblModifiedTotal) {
			System.out.println("Success! the calculation is correct");
		} else {
			System.out.println("Failure, the calculation is wrong");
		}
	}

}
