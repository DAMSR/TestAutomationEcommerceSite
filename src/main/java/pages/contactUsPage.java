package pages;

import org.openqa.selenium.WebDriver;

public class contactUsPage {

	WebDriver driver;
	
	public contactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
