package com.test;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.driver.DriverManager;
import com.driver.LocalDriverFactory;
import com.pages.LoginPage;
import com.pages.PlansPage;
import com.testdata.RegisterTestData;
import com.utils.LoadProperty;

public class RegisterUserLogin {
	
	WebDriver driver;
	LoginPage loginPage;
	PlansPage plansPage;
	String country;
		
	@Parameters("browserName")
	@BeforeTest
	public void beforeTest(String browserName) {
		DriverManager.setWebDriver(LocalDriverFactory.createInstance(browserName));
		driver = DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		country = System.getProperty("country");
		if(country.equalsIgnoreCase("uk")){
			driver.get(LoadProperty.getProperty("uk"));	
		}
		
		else {
			driver.get(LoadProperty.getProperty("us"));	 
		}
		
	}		
	
	@Test(dataProvider = "getRegisterLogin")
	public void verifyRegisterUser(Map<String,String> registerData) throws InterruptedException {
		loginPage = new LoginPage(driver);
		plansPage = new PlansPage(driver);
		loginPage.clickLogin();
		Assert.assertTrue(loginPage.registerUser(registerData));
			
	}
	
	@DataProvider
	public Object[][] getRegisterLogin(){
		Object[][] testData = RegisterTestData.registerData().clone();
		return testData;
		
	}

		
}
