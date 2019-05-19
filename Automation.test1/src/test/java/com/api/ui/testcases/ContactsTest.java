package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.api.ui.base.TestBase;
import com.api.ui.pages.ContactsPage;
import com.api.ui.pages.HomePage;

public class ContactsTest extends TestBase{

		ContactsPage contactspage;
		HomePage homepage;
		
		public ContactsTest(){
			super();
		}
		
		@BeforeMethod
		public void setUpdriver(){
			initialization();
			contactspage = new ContactsPage();
			homepage = new HomePage();
		}
		@Test
		public void testsContact(){
			homepage.clickOnContact();
			contactspage = contactspage.fillContactForm("Customer service", "Random@test.com",
					"Testing", "This is test purpose");
			
			contactspage.submitMessage();
			String successMsg = contactspage.getMessage();
			Assert.assertEquals(successMsg, "will check the message on the site later");
		}
		
		@AfterMethod
		public void tearDown(){
		driver.quit();
		}	
}
