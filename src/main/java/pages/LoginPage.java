package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement Email_Address_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement SignIn_Button;
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitCreate']") WebElement CreateAnAccount_Button;
	@FindBy(how = How.XPATH, using = "//input[@id='email_create']") WebElement CreatAccountEmail_Field;
	@FindBy(how = How.XPATH, using = "//*[@id='create_account_error']") WebElement InvalidEmail_Alert;
	@FindBy(how = How.XPATH, using = "//div[@id='create_account_error']/ol/li") WebElement invalidEmailAlertTextDisplayed;
	
	//InteractiveMethods
	public void enterEMailAddress(String Email) {
		Email_Address_Field.sendKeys(Email);
	}
	
	public void enterPassword(String Password) {
		Password_Field.sendKeys(Password);
	}
	
	public void clickSigninButton() {
		SignIn_Button.click();
	}
	
	public void clickCreateAnAccountButton() {
		CreateAnAccount_Button.click();
	}
	
	public void fillCreatAccountEmailField() {
		CreatAccountEmail_Field.sendKeys(randomNumberGenerator() + "." + randomNumberGenerator() + "user@email.com");
	}

	public void fillCreataccountWithinvalidemailField(String email) {
		CreatAccountEmail_Field.sendKeys(email);
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
