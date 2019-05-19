package com.api.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.api.ui.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(css="[classes='login']")
	WebElement signinButton; 

	@FindBy (id="constact-link")
	WebElement ContactButton;
	
	@FindBy(id="search_query_top")
	WebElement SearchField;
	
	@FindBy(css="[classes='submit_search']")
	WebElement SubmitSearch;
	
	@FindBy(css="[classes='logout']")
	WebElement LogoutButton;
	
	//initalize page object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//create method for search page
	public SearchPage searchProduct(String productName){
		SearchField.sendKeys(productName);
		SubmitSearch.click();
		return new SearchPage();
	}
	
	
	//create method for signin
	public void SignIn(){
		signinButton.click();
	}
	
	//create method for contactbutton
	public void clickOnContact(){
		ContactButton.click();
	}
	
	//create method for logout
	public void Logout(){
		LogoutButton.click();
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}	
	
	}
