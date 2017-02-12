package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PlansPage extends BasePage {
	
	public PlansPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//ul[@class='nav navbar-nav hidden-sm-down pull-left']//a")
	WebElement helloFresh;

	@FindBy(id = "banner-view-plans-button")
	WebElement viewPlan;
	
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right']//a[@title= 'Our Recipe Boxes']")
	WebElement recipeBox;
	
	@FindBy(xpath = "//h3[contains(text(),'Classic')]")
	WebElement classicPlan;

	@FindBy(xpath = "//span[@ng-bind='grandTotal']")
	WebElement classicPrice;
	
	@FindBy(id = "add-to-cart-button")
	WebElement continueBtn;
	
	@FindBy(xpath = "//span[@ng-repeat='product in vm.items']//strong[contains(text(),'Classic')]")
	WebElement classicPlanTxt;
	
	@FindBy(xpath = "//strong[@ng-bind='product.price']")
	WebElement classicPriceTxt;
	
	
	public boolean verifyPlanDetails(){
		wait.until(ExpectedConditions.visibilityOf(helloFresh));
		helloFresh.click();
		jsExecutor.executeScript("arguments[0].click();", viewPlan);
		String classicPlantxt = classicPlan.getText();
		classicPlan.click();
		String priceBoxtxt = classicPrice.getText();
		jsExecutor.executeScript("arguments[0].click();", continueBtn);
		
		if(classicPlantxt.equalsIgnoreCase(classicPlanTxt.getText())
				&& priceBoxtxt.equalsIgnoreCase(classicPriceTxt.getText())){
			return true;
		}
		
		return false;
			
	}
	
	
}
