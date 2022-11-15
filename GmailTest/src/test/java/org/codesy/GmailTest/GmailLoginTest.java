package org.codesy.GmailTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageClassFiles.GmailHomePage;
import PageClassFiles.GmailLoginPage;

public class GmailLoginTest extends BaseTest {


	@Test(groups= {"Positive"})
	public void loginPositiveTestCase() throws IOException {
				
		String userName = "codesytest";
		String password = "Test@123";

				
		//Create Object of GmailLoginPage class and call method to login to gmail application
		GmailLoginPage gmailLogin = new GmailLoginPage(driver);
		gmailLogin.loginToGmail(userName, password);
				
		//Create Object of GmailHomePage class and call method to check if login success or not
		GmailHomePage gmailHome = new GmailHomePage(driver);
		boolean res = gmailHome.isLoginSuccess();


		if(res) {
		   System.out.println("Login to Gmail is Successfull!!");
		}else {
		   Assert.assertTrue(false, "Login to Gmail Failed!!");
		}
		
		
	}						

	
	@Test(groups= {"Negative"})
	public void loginNegativeTestCase() throws IOException {
				
		String userName = "codesytest";
		String password = "Test@1234";

				
		//Create Object of GmailLoginPage class and call method to login to gmail application
		GmailLoginPage gmailLogin = new GmailLoginPage(driver);
		gmailLogin.loginToGmail(userName, password);
				
		//Create Object of GmailHomePage class and call method to check if login success or not
		GmailHomePage gmailHome = new GmailHomePage(driver);
		boolean res = gmailHome.isLoginSuccess();

		if(!res) {
		   System.out.println("Negative Test - Login to Gmail is Successfull!!");
		}else {
		   Assert.assertTrue(false, "Negative Test - Login to Gmail Failed!!");
		}
		
		
	}
}
