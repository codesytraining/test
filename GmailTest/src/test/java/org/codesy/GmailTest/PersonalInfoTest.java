package org.codesy.GmailTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import PageClassFiles.GmailHomePage;
import PageClassFiles.GmailLoginPage;
import PageClassFiles.PersonalInfoPage;

public class PersonalInfoTest extends BaseTest {


	@Test(dataProvider = "getDataForBasicInfo")
	public void validateBasicInfo(HashMap<String,String> input){
		
//		String expectedName = "Codesy Test";
//		String expectedBirthday = "13 May 1990";
//		String expectedGender = "Male";
//		
//		String userName = "codesytest";
//		String password = "Test@123";

		
		//Create Object of GmailLoginPage class and call method to login to gmail application
		GmailLoginPage gmailLogin = new GmailLoginPage(driver);
		//gmailLogin.loginToGmail(userName, password);
		gmailLogin.loginToGmail(input.get("userName"), input.get("password"));
				
		//Create Object of GmailHomePage class and call method to check if login success or not
		GmailHomePage gmailHome = new GmailHomePage(driver);
		boolean res = gmailHome.isLoginSuccess();


		if(res) {
		   System.out.println("Login to Gmail is Successfull!!");
		}else {
		   Assert.assertTrue(false, "Login to Gmail Failed!!");
		}
		
		//click Personal Info Page
		gmailHome.clickPersonalInfo();
		
		//Perform Validations on Basic Info
		
		PersonalInfoPage personalInfo = new PersonalInfoPage(driver);
		
		//Validate if Expected Name is SAME as Actual Name
		res = personalInfo.validateName(input.get("expectedName"));
		if(res) {
		   System.out.println("Name in Basic Info is as Expected!!");
		}else {
		   Assert.assertTrue(false, "Name NOT as Expected. Basic Info Validation Failed!!");
		}
		
		res = personalInfo.validateBirthDate(input.get("expectedBirthday"));
		if(res) {
		   System.out.println("Birtday in Basic Info is as Expected!!");
		}else {
		   Assert.assertTrue(false, "Birthday NOT as Expected. Basic Info Validation Failed!!");
		}
		
		res = personalInfo.validateGender(input.get("expectedGender"));
		if(res) {
		   System.out.println("Gender in Basic Info is as Expected!!");
		}else {
		   Assert.assertTrue(false, "Gender NOT as Expected. Basic Info Validation Failed!!");
		}
	}
	
	
	@DataProvider
	public Object[][] getDataForBasicInfo() throws IOException {
		
//		Object[][] data = {{"codesytest", "Test@123", "Codesy Test", "13 May 1990", "Male"},{"codesytest", "Test@123", "Codesy Test", "13 May 1990", "Male"}};
		
//		data[0][0] = "codesytest";
//		data[0][1] = "Test@123";
//		data[0][2] = "Codesy Test";
//		data[0][3] = "13 May 1990";
//		data[0][4] = "Male";
		
//		return data;
		//Create Object of HashMap
		HashMap<String,String> map = new HashMap<String,String>();

//		map.put("userName", "codesytest");
//		map.put("password", "Test@123");
//		map.put("expectedName", "Codesy Test");
//		map.put("expectedBirthday", "13 May 1990");
//		map.put("expectedGender", "Male");
		
		map = readJSONFile(new File("C:\\RohitData\\Selenium_Udemy\\NewVersion\\GmailTest\\src\\test\\java\\TestResources\\PersonalInfoData.json"));
		
		return new Object[][] {{map}};
		
	}
	
	
}
