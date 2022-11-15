package PageClassFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
	
	WebDriver driver;
	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//All WebELements of Login Page using Page Factory	
	@FindBy(xpath = "//a[contains(@aria-label,'Name')]/div/div/div/div[2]/div/div[@class='bJCr1d']")
	WebElement nameField;
	
	@FindBy(xpath = "//a[contains(@aria-label,'Birthday')]/div/div/div/div[2]/div/div[@class='bJCr1d']")
	WebElement birthDateField;
	
	@FindBy(xpath = "//a[contains(@aria-label,'Gender')]/div/div/div/div[2]/div/div[@class='bJCr1d']")
	WebElement genderField;

	
	//All methods of Login Page - Action Methods
	
	public boolean validateName(String expectedName) {
		
		CommonFunctionalities obj = new CommonFunctionalities(driver);
		obj.waitUntilElementLoaded(nameField, 10);
		
		if(nameField.getText().equalsIgnoreCase(expectedName)) {
			return true;
		}
		
		return false;
	}
	
	public boolean validateBirthDate(String expectedBirthday) {
			
		CommonFunctionalities obj = new CommonFunctionalities(driver);
		obj.waitUntilElementLoaded(birthDateField, 10);
		
		System.out.println("Actual" + birthDateField.getText() + " Expected:" + expectedBirthday);
		if(birthDateField.getText().equalsIgnoreCase(expectedBirthday)) {
			return true;
		}
		
		return false;
	}

	public boolean validateGender(String expectedGender) {
		
		if(genderField.getText().equalsIgnoreCase(expectedGender)) {
			return true;
		}
		
		return false;
	}
	
}
