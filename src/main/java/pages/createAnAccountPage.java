package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class createAnAccountPage extends basePage {

	WebDriver driver;
	
	public createAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']") WebElement mrRadioButton;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']") WebElement firstNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']") WebElement lastNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//select[@id='days']") WebElement daySelection;
	@FindBy(how = How.XPATH, using = "//select[@id='months']") WebElement monthSelection;
	@FindBy(how = How.XPATH, using = "//select[@id='years']") WebElement yearSelection;
	@FindBy(how = How.XPATH, using = "//input[@id='newsletter']") WebElement Newsletter_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='optin']") WebElement SpecialOffer_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']") WebElement addressFirstNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']") WebElement addressLastNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='company']") WebElement addressCompanyField;
	@FindBy(how = How.XPATH, using = "//input[@id='address1']") WebElement address1Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address2']") WebElement address2Field;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement cityField;
	@FindBy(how = How.XPATH, using = "//select[@id='id_state']") WebElement stateField;
	@FindBy(how = How.XPATH, using = "//input[@id='postcode']") WebElement zipCodeField;
	@FindBy(how = How.XPATH, using = "//select[@id='id_country']") WebElement countryField;
	@FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']") WebElement cellPhoneField;
	@FindBy(how = How.XPATH, using = "//input[@id='alias']") WebElement aliasAddressField;
	@FindBy(how = How.XPATH, using = "//button[@id='submitAccount']") WebElement registerButton;
	@FindBy(how = How.XPATH, using = "//div[@id=\"center_column\"]/div/p") WebElement errorAlertForMandatoryFieldsDisplayed;
	
	public void clickMrRadioButton() {
		mrRadioButton.click();
	}
	
	public void fillFirstNameField(String FirstName) {
		firstNameField.sendKeys(FirstName);
	}
	
	public void fillLastNameField(String LastName) {
		lastNameField.sendKeys(LastName);
	}
	
	public void fillPasswordField(String Password) {
		passwordField.sendKeys(Password);
	}
	
	public void selectDaySelection(String day) {
		
		selectFromDropdownByValue(daySelection, removeDecimalPoint(day));
	}
	
	public void selectMonthSelection(String month) {
		selectFromDropdownByValue(monthSelection, month);
	}
	
	public void selectYearSelection(String year) {
		selectFromDropdownByValue(yearSelection, removeDecimalPoint(year));
	}
	
	public void clickNewsletterCheckBox() {
		Newsletter_CheckBox.click();
	}
	
	public void clickSpecialOfferCheckBox() {
		SpecialOffer_CheckBox.click();
	}
	
	public void fillAddressFirstNameField(String aFirstName) {
		addressFirstNameField.sendKeys(aFirstName);
	}
	
	public void fillAddressLastNameField(String aLastName) {
		addressLastNameField.sendKeys(aLastName);
	}
	
	public void fillAddressCompanyField(String Company) {
		addressCompanyField.sendKeys(Company);
	}

	public void fillAddress1Field(String Address) {
		address1Field.sendKeys(Address);
	}

	public void fillCityField(String City) {
		cityField.sendKeys(City);
	}

	public void selectStateField(String State) {
		selectFromDropdownByVisibleText(stateField, State);
	}

	public void fillZipCodeField(String ZipCode) {
		zipCodeField.sendKeys(removeDecimalPoint(ZipCode));
	}

	public void selectCountryField(String Country) {
		selectFromDropdownByVisibleText(countryField, Country);
	}

	public void fillCellPhoneField() {
		cellPhoneField.sendKeys(phoneNumberGenerator());
	}
	
	public void fillAliasAddressField(String alias) {
		aliasAddressField.clear();
		aliasAddressField.sendKeys(alias);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	public void verifyErrorAlertForMandatoryFields() {
		
		if(errorAlertForMandatoryFieldsDisplayed.isDisplayed() == true) {
			System.out.println("Success! Error Alert For Mandatory Fields is displayed");
		}else {
			System.out.println("Failure, Error Alert For Mandatory Fields is not displayed");
		}
	}
}
