package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;

	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUpdriver(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "Later will check on site");
	}
	@Test(priority=2)
	public void apLogoTest(){
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage=loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}

