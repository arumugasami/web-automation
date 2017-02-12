package com.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "login-button")
	WebElement homeLogin;

	@FindBy(id = "email-input")
	WebElement email;
	
	@FindBy(id = "password-input")
	WebElement password;
	
	@FindBy(id = "submit-login-button")
	WebElement loginBtn;
	
	@FindBy(id = "register-user-link")
	WebElement registerUser;
	
	@FindBy(id = "gender-input")
	WebElement selectDropDown;
	
	@FindBy(id = "first-name-input")
	WebElement firstName;
	
	@FindBy(id = "last-name-input")
	WebElement lastName;
	
	@FindBy(id = "email-input")
	WebElement emailRegister;
	
	@FindBy(id = "password-input")
	WebElement passwordRegister;
	
	@FindBy(id = "day-input")
	WebElement inputDay;
	
	@FindBy(id = "month-input")
	WebElement inputMonth;

	@FindBy(id = "year-input")
	WebElement inputYear;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(xpath = "//small[contains(text(),'Email already exists')]")
	WebElement emailExists;
	
	@FindBy(xpath = "//span[@class='ellipsify account-customer-name']/span[1]")
	WebElement firstNameReg;
			
	public void clickLogin(){
		homeLogin.click();
	}
	
	public void loginUser(String login, String pass){
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(login);
		password.sendKeys(pass);
		loginBtn.click();
	}
	
	
	public boolean registerUser(Map<String, String> registerData){
		wait.until(ExpectedConditions.visibilityOf(registerUser));
		registerUser.click();
		wait.until(ExpectedConditions.visibilityOf(selectDropDown));
		selectItem(1,selectDropDown);
		firstName.sendKeys(registerData.get("firstName"));
		lastName.sendKeys(registerData.get("lastName"));
		emailRegister.sendKeys(registerData.get("email"));
		passwordRegister.sendKeys(registerData.get("password"));
		inputDay.sendKeys(registerData.get("Day"));
		inputMonth.sendKeys(registerData.get("Month"));
		inputYear.sendKeys(registerData.get("year"));
		registerButton.click();
		
		if(driver.findElements(By.xpath("//small[contains(text(),'Email already exists')]")).size()!=0){
		   Reporter.log("Email already exists");
		   return false;
		}
		
		else{
			wait.until(ExpectedConditions.visibilityOf(firstNameReg));
			if(registerData.get("firstName").equalsIgnoreCase(firstNameReg.getText())){
				return true;
			}
			Reporter.log("User successfully registered");
			;
		}
		
		return false;
	}

}
