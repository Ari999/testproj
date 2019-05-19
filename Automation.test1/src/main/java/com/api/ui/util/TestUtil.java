package com.api.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.TakesScreenshot;

import com.api.ui.base.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
public class TestUtil extends TestBase{
	
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;
	
	public static String XL_SHEET_PATH ="path of the xl sheet";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	//two arrays provided below: username and password
	public static Object [][] getTestData(String sheetName){
		FileInputStream file = null; //handling scenarios where somehow the exception provided has no value
		//if it has no value then it wont run the method66
		try{
			file = new FileInputStream(XL_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i<sheet.getLastRowNum(); i++){
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
	public static void takeScreenshotAtEndOftest() throws IOException{
		// the source file where screenshot wil be taken
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDirect=System.getProperty("user.dir");
		//takes the current time and uses it as the name of the screenshot file
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + 
		System.currentTimeMillis() + ".png"));
				
	}
	public static void runtTimeInfo(String  messageType, String message) throws InterruptedException{
		js= (JavascriptExecutor) driver;
		//check for jquery on the page. add it if need be
		js.executeScript("if (!window.JQuery){"
			+ "var jquery=document.createElement('script'); jquery.type = 'text/javascript';"
			+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
			+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
	Thread.sleep(5000);
	
	//use jquery to add jquery-growl to the page
	js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
	//use jquery to add jquery-growl styles to the page
			js.executeScript("$('head').append('<link rel=\"stylesheet\" "
					+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "/type=\"text/css\" />');");
			Thread.sleep(3000);
			//jquery-growl w/ no frills
			js.executeScript ("$ growl({ title: 'GET' , message: '/'});");
			//color
			if (messageType.equals("error")){
				js.executeScript("$ growl.error({ title: 'ERROR' message: '"+message+"'});");
			}
				else if(messageType.equals("info")){
					js.executeScript("$growl.error({title: 'Notice', message: 'your notice message will appear here' });");
				}
				else if(messageType.equals("warning")){
					js.executeScript("$growl.warning({title: 'Warning!!!', message: 'warning message will appear here' });");
				}else
						System.out.println("Show NO error messages");
			Thread.sleep(3000);
			}
}
	
