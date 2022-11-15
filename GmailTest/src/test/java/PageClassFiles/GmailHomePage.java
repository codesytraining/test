package PageClassFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	
	WebDriver driver;
	
	public GmailHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//All Elements
	@FindBy(id = "sdgBod")
	List<WebElement> googleAcountLogo;
	
	@FindBy(xpath="//a[@href='personal-info']/div[@class='GiKO7c']")
	WebElement personalInfoLink;
		
		
	//All Methods
	public boolean isLoginSuccess() {
		if(googleAcountLogo.size() == 0) {
			return false;
		}else {
			return true;
		}		
	}
	
	public void clickPersonalInfo() {
		personalInfoLink.click();
	}


}
