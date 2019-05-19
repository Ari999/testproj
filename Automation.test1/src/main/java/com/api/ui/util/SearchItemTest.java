package com.api.ui.util;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.LoginPage;
import com.api.ui.pages.SearchPage;

public class SearchItemTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	
	public SearchItemTest(){
		super();
	}
@BeforeMethod
public void setUpdriver(){
	initialization();
	loginpage = new LoginPage();
	homepage = new HomePage();
	
}
@Test(priority=3)
public void testSearchItem(){
	String product =  "Evening";
	homepage.SignIn();
	homepage = loginpage.login(propt.getProperty("username"), propt.getProperty("password"));
		
	searchpage = homepage.searchProduct("Evening");
	String header = searchpage.getHeader();
	System.out.println(header);
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	homepage.Logout();
}
@AfterMethod
public void teardown(){
	driver.quit();
}

}
