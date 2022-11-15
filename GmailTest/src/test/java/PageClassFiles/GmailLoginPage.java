package PageClassFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
	
	WebDriver driver;
	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//All WebELements of Login Page using Page Factory	
	@FindBy(id = "identifierId")
	WebElement userNameField;
	
	@FindBy(xpath = "//span[text() = 'Next']")
	WebElement nextBtn;
	
	@FindBy(name = "Passwd")
	WebElement passwordField;

	
	//All methods of Login Page - Action Methods
	public void loginToGmail(String userName, String password) {
		//Enter User Name
		userNameField.sendKeys(userName);
		
		//Click next button
		nextBtn.click();
		
		CommonFunctionalities obj = new CommonFunctionalities(driver);
		obj.waitUntilElementLoaded(passwordField, 10);
		
		//Enter Password
		passwordField.sendKeys(password);
		
		//Click next button
		nextBtn.click();
		
	}
	
	public void goTo() {
		//Go to the website	for mouse operations on button	
		driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-821904935%3A1667015492274468&continue=https%3A%2F%2Fmyaccount.google.com%3Futm_source%3Daccount-marketing-page%26utm_medium%3Dgo-to-account-button&service=accountsettings&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWpN2fm8LzFhg2bzM3sOnI_muEJyg0I1Z4T91GhA3fVCRLAf53GswbIXNf1zKVpPK-KgpXrknQ");
	}
}
