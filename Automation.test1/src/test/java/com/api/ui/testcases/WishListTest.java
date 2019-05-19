package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.LoginPage;
import com.api.ui.pages.ProductDetail;
import com.api.ui.pages.SearchPage;

public class WishListTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	ProductDetail productdetail;
	
	public WishListTest(){
		super();
	}
	@BeforeMethod
	public void setUpdriver(){
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	@Test
	public void testAddProductWishList(){
		String product = "printed chiffon dress";
		homepage.SignIn();
		homepage = loginpage.login(propt.getProperty("username"), propt.getProperty("password"));
		searchpage = homepage.searchProduct(product);
		String header=searchpage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		//add product to the wishlist
		productdetail.ClickAddWishListButton();
		productdetail.verifyAddWishListMsg();
		homepage.Logout();
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}

