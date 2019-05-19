package com.api.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.api.ui.base.TestBase;
import com.api.ui.pages.ProductDetail;
import com.api.ui.pages.SearchPage;

public class SearchPage extends TestBase{

	@FindBy(css="[title='Add to cart']")
	WebElement addCartButton;
	
	@FindBy(css="[title='Proceed to Checkout']")
	WebElement checkOut;
	
	@FindBy(css="[class='page-heading product-listing']")
	WebElement searchHeading;
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}
	public ProductDetail selectProduct(String productName){
		String locator = "[class=product-name'][title='" +productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetail();
	}
	public String getHeader(){
		return searchHeading.getText();
	}
	
}
