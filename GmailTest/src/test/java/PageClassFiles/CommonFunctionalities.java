package PageClassFiles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionalities {
	
WebDriver driver;
	
	public CommonFunctionalities(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void waitUntilElementLoaded(WebElement password, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(password));
	}

}
