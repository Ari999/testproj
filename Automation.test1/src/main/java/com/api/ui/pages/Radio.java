package com.api.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Radio {
	 public static void main(String[] args) throws InterruptedException{
		 System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Arif\\Desktop\\chromedriver.exe");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
		 driver.manage().window().maximize();
		 Thread.sleep(4000);
		 WebElement radioaction = driver.findElement(By.cssSelector("[class=ui-slider-range ui-widget-header ui-corner-all']"));
		 Thread.sleep(3000);
		 Actions actions = new Actions(driver);
		 												//X	//Y
		 actions.clickAndHold(radioaction).moveByOffset(150, 260).release().perform();
		 
		 //this is to grab a radio button and drag it to a certain pixel coordinate in the site
		 //actions.dragAndDropBy(radioaction, 672, 549).release().build().perform();
		 radioaction.click();
	 }
}
