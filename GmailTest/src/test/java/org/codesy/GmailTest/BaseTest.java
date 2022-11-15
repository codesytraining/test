package org.codesy.GmailTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageClassFiles.GmailLoginPage;

public class BaseTest {
	
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		//Read PROPERTIES file
		Properties prop = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\RohitData\\Selenium_Udemy\\NewVersion\\GmailTest\\src\\test\\java\\TestResources\\globalProp.properties");
		prop.load(file);
		
		String browserName = prop.getProperty("browser");
		
		//If browser = chrome
		if(browserName.equalsIgnoreCase("CHROME")) {
			//Browser Driver
			System.setProperty("webdriver.chrome.driver", "C:\\RohitData\\Eclipse\\SeleniumJARs\\chromedriver.exe");
					
			//Creating object of WebDriver
			driver = new ChromeDriver();
		}		
		//else if browser = firefox
		else if(browserName.equalsIgnoreCase("FIREFOX")) {
			
			//path of firefox driver
			
			//driver object of firefox
		}		
		//else if browser = edge
		else if(browserName.equalsIgnoreCase("EDGE")) {
			//path of edge driver
			
			//driver object of edge
		}		
				
		//Maximize
		driver.manage().window().maximize();
				
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//return driver
		
		return driver;
	}

	
	@BeforeMethod(alwaysRun = true)
	public WebDriver launchApplication() throws IOException {
		
		WebDriver driver = initializeDriver();
		
		GmailLoginPage gmailLogin = new GmailLoginPage(driver);
		gmailLogin.goTo();
		
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBroswer() {
		driver.close();
	}

	//Method to Read JSON file and return HashMap object containing JSON file data
	public HashMap<String, String> readJSONFile(File JSONPath) throws IOException {
		
		//Read JSON file and convert it to String
		String fileData = FileUtils.readFileToString(JSONPath, StandardCharsets.UTF_8);
		
		//Convert String into HashMap
		
		ObjectMapper obj = new ObjectMapper();
		
		HashMap<String, String> data = obj.readValue(fileData, new TypeReference<HashMap<String, String>>(){});
		
		return data;
		
	}

}
