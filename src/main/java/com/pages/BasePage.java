package com.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.driver.DriverManager;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait = DriverManager.rtnWebdriverWait();
	JavascriptExecutor jsExecutor = DriverManager.rtnJSExecutor();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void selectItem(int i, WebElement element) {
		Select dropDown = new Select(element);
		dropDown.selectByIndex(i);
	}

	

}