package com.api.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.api.ui.util.TestUtil;
import com.api.ui.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver; //initiates web browser
	public static WebEventListener eventListener; //takes the events occurring and sends to extentreport
	//constructor
	public TestBase(){
		try{
			//create object for the properties 
			propt = new Properties();
			//read the file from directory and be able to access and utilize it into the object we created (ipa)
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/api/ui/config/config.properties");
		propt.load(ipa);
		//whenever we throw an XL file it always throws an error so we use ioexception to 
		//interact with it
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = propt.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/drivers/chromedriver.exe");
		}
		else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.internetexplorer.driver", "provide file path of driver");
			driver = new InternetExplorerDriver();
		}
		//creating object for action thats occurring and sharing with driver
		en_driver = new EventFiringWebDriver(driver);
		//create object of webeventlistener to register it with eventfiringwebdriver
		eventListener = new WebEventListener();
		//this throws an error because tryin to interact with weblistener
		//if we do en_driver.register(eventListener)
		//because we haven't worked on out webeventlistener yet
		//so we need to extend it to and build the webeventlistener
		/*event can be captured based on the method we create webeventlistener class*/
		en_driver.register(eventListener);
		//since we know driver object is for browser, en_driver is for event taking place.
		//we declaring that they are equal to each other when they are exchanging the info
		driver = en_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
		
		driver.get(propt.getProperty("url"));
		
	}
}	
	
