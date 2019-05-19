package com.api.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.api.ui.base.TestBase;

public class ProductDetail extends TestBase{
	
	@FindBy(id="quantitiy_wanted")
	WebElement quantity;
	
	@FindBy(css="[id='group_1']")
	WebElement size;

	@FindBy(id="add_to_cart")
	WebElement addCart;

	@FindBy(css="[title='Proceed to checkout']")
	WebElement CheckOutButton;

	@FindBy(css="[title='Add to my wishlist']")
	WebElement AddWishList;

	@FindBy(css="[class='fancybox-error']")
	WebElement WishMsg;

	@FindBy(css="class='[fancybox-item fancybox-close']")
	WebElement WishMsgClose;
	//constructor initializing page factory and taking elements from our driver and initializing elements
	public ProductDetail(){
		PageFactory.initElements(driver, this);
	}
	//constructor overloading
	public ProductDetail QuantItem(String Quantity){
	quantity.clear();
	quantity.sendKeys(Quantity);
	return this;
	}
	/*
	public void SelectSize(){
		Select SizeDrop = new Select(driver.findElement(By.id("group_1")));
		SizeDrop.selectByIndex(2);
	}
*/
	public ProductDetail SelectSizealt(String selectsize){
		Select select = new Select(size);
		select.selectByVisibleText(selectsize);
		return this;
	}
	
	public ProductDetail SelectColor(String color){
		String locator = "[name='" +color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	
	public ProductDetail cartButton(){
		addCart.click();
		return this;
	}
	
	public OrderSummaryPage CheckOutButton(){
		CheckOutButton.click();
		return new OrderSummaryPage();
	}
	
	public ProductDetail ClickAddWishListButton(){
		AddWishList.click();
		return this;
	}
	//verifies the wishlist message in our console  then closes the text box
	public void verifyAddWishListMsg(){
		Assert.assertEquals(WishMsg.getText(), "Added to your wishlist.");
		WishMsgClose.click();
	}
	
}
