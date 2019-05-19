package com.api.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.api.ui.base.TestBase;

public class OrderSummaryPage extends TestBase{
	
	@FindBy(css = "[class='cart_navigation clearfix'] [title='Proceed to checkout']")
	WebElement ProceedtoCheckout;
	
	@FindBy(css= "[name= 'processAddress']")
	WebElement processAddressButton;

	@FindBy(css = "[name='processCarrier']")
	WebElement ProcCarrierButton;

	@FindBy(id="cgv")
	WebElement TermsCondit;

	@FindBy(css="[class=''][title='pay by bank wire']")
	WebElement PayByBank;

	@FindBy(css= "[id='cheque-indent'] [class='dark']")
	WebElement ConfirmOrder;

	@FindBy(css= "[class='cheque-indent'] [class='dark']")
	WebElement OrderConf;

	public OrderSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage ProceedCheckOut(){
		ProceedtoCheckout.click();
		return this;
	}
	public OrderSummaryPage ProcessAddress(){
		processAddressButton.click();
		return this;
	}
	
	public OrderSummaryPage CarrierButton(){
		ProcCarrierButton.click();
		return this;
	}
	public OrderSummaryPage TermsConditionButton(){
		TermsCondit.click();
		ProcCarrierButton.click();
		return this;
	}
	public OrderSummaryPage confirmOrder(){
		PayByBank.click();
		ConfirmOrder.click();
		return this;
	}
	
	public String getConfirmMessage(){
		return OrderConf.getText();
	}
}
