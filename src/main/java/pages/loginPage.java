package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage extends basePage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement emailAddressField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement createAnAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']") WebElement creatAccountEmailField;
	@FindBy(how = How.XPATH, using = "//*[@id='create_account_error']") WebElement InvalidEmail_Alert;
	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']/ol/li") WebElement invalidEmailAlertTextDisplayed;
	
	//InteractiveMethods
	public void enterEMailAddress(String Email) {
		emailAddressField.sendKeys(Email);
	}
	
	public void enterPassword(String Password) {
		passwordField.sendKeys(Password);
	}
	
	public void clickSigninButton() {
		signInButton.click();
	}
	
	public void clickCreateAnAccountButton() {
		createAnAccountButton.click();
	}
	
	public void fillCreatAccountEmailField() {
		creatAccountEmailField.sendKeys(randomNumberGenerator() + "." + randomNumberGenerator() + "user@email.com");
	}

	public void fillCreataccountWithinvalidemailField(String email) {
		creatAccountEmailField.sendKeys(email);
	}

	public void verifyCreataccountWithinvalidemailField() {
		
		if(invalidEmailAlertTextDisplayed.isDisplayed() == true) {
			System.out.println("Success! Alert for invalid email was displayed");
			System.out.println(invalidEmailAlertTextDisplayed.getText());
		}else {
			System.out.println("Failure, alert for invalid email was not displayed ");
		}
		
	}
}
