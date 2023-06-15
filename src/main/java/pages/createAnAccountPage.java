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
	
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']") WebElement Mr_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']") WebElement FirstName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']") WebElement LastName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='days']") WebElement Day_Selection;
	@FindBy(how = How.XPATH, using = "//select[@id='months']") WebElement Month_Selection;
	@FindBy(how = How.XPATH, using = "//select[@id='years']") WebElement Year_Selection;
	@FindBy(how = How.XPATH, using = "//input[@id='newsletter']") WebElement Newsletter_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='optin']") WebElement SpecialOffer_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']") WebElement Address_FirstName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']") WebElement Address_LastName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='company']") WebElement Address_Company_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address1']") WebElement Address1_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address2']") WebElement Address2_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement City_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='id_state']") WebElement State_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='postcode']") WebElement ZipCode_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='id_country']") WebElement Country_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']") WebElement CellPhone_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='alias']") WebElement aliasAddressField;
	@FindBy(how = How.XPATH, using = "//button[@id='submitAccount']") WebElement Register_Button;
	@FindBy(how = How.XPATH, using = "//div[@id=\"center_column\"]/div/p") WebElement errorAlertForMandatoryFieldsDisplayed;
	
	public void clickMrRadioButton() {
		Mr_RadioButton.click();
	}
	
	public void fillFirstNameField(String FirstName) {
		FirstName_Field.sendKeys(FirstName);
	}
	
	public void fillLastNameField(String LastName) {
		LastName_Field.sendKeys(LastName);
	}
	
	public void fillPasswordField(String Password) {
		Password_Field.sendKeys(Password);
	}
	
	public void selectDaySelection(String day) {
		
		selectFromDropdownByValue(Day_Selection, removeDecimalPoint(day));
	}
	
	public void selectMonthSelection(String month) {
		selectFromDropdownByValue(Month_Selection, month);
	}
	
	public void selectYearSelection(String year) {
		selectFromDropdownByValue(Year_Selection, removeDecimalPoint(year));
	}
	
	public void clickNewsletterCheckBox() {
		Newsletter_CheckBox.click();
	}
	
	public void clickSpecialOfferCheckBox() {
		SpecialOffer_CheckBox.click();
	}
	
	public void fillAddressFirstNameField(String aFirstName) {
		Address_FirstName_Field.sendKeys(aFirstName);
	}
	
	public void fillAddressLastNameField(String aLastName) {
		Address_LastName_Field.sendKeys(aLastName);
	}
	
	public void fillAddressCompanyField(String Company) {
		Address_Company_Field.sendKeys(Company);
	}

	public void fillAddress1Field(String Address) {
		Address1_Field.sendKeys(Address);
	}

	public void fillCityField(String City) {
		City_Field.sendKeys(City);
	}

	public void selectStateField(String State) {
		selectFromDropdownByVisibleText(State_Field, State);
	}

	public void fillZipCodeField(String ZipCode) {
		ZipCode_Field.sendKeys(removeDecimalPoint(ZipCode));
	}

	public void selectCountryField(String Country) {
		selectFromDropdownByVisibleText(Country_Field, Country);
	}

	public void fillCellPhoneField() {
		CellPhone_Field.sendKeys(phoneNumberGenerator());
	}
	
	public void fillAliasAddressField(String alias) {
		aliasAddressField.clear();
		aliasAddressField.sendKeys(alias);
	}

	public void clickRegisterButton() {
		Register_Button.click();
	}

	public void verifyErrorAlertForMandatoryFields() {
		
		if(errorAlertForMandatoryFieldsDisplayed.isDisplayed() == true) {
			System.out.println("Success! Error Alert For Mandatory Fields is displayed");
		}else {
			System.out.println("Failure, Error Alert For Mandatory Fields is not displayed");
		}
	}
}
