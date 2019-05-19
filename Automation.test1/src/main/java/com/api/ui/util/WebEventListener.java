/*We have created this class WebDriverEventListener in order to implement interface
 * is to override all the methods and define certain helpful log actions which would
 * be displayed/logged as the app under test is being executed. These methods will be invoked
 * by itself automatically when certain actions are performed. EX: click, submit, screenshot, findby, etc 
 */
package com.api.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.api.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	public void beforeNavigate (String url, WebDriver driver) {
		System.out.println("Before navi to: '" + url + "'");
	}
	
	public void afterNavigate (String url, WebDriver driver) {
		System.out.println("After navi to: '" + url + "'");
	
	}
	public void beforeChangeValue (WebElement element, WebDriver driver) {
	System.out.println("Value of: " + element.toString() + "before making any change");
}	
	public void afterChangeValue (WebElement element, WebDriver driver) {
		System.out.println("Value of: " + element.toString() + "after making any change");
		
	}
	public void beforeClickingOn (WebElement element, WebDriver driver) {
		System.out.println("Attempting to Click on: " + element.toString());
	
	}
	public void afterClickingOn (WebElement element, WebDriver driver) {
		System.out.println("Successfully Clicked on: " + element.toString());
	}
	public void beforeNavigatingback(WebDriver driver){
		System.out.println("attempting navigating to current page");
	
	}
	public void afterNavigatingback(WebDriver driver){
		System.out.println("Successfully navigating current page");
	}
	public void beforeNavigatingforward(WebDriver driver){
		System.out.println("Attempting navigating forward to next page");
	}
	public void afterNavigatingforward(WebDriver driver){
		System.out.println("Successfully navigating forward to next page");
	}
	public void dueToException (Throwable error, WebDriver driver){
		System.out.println("Exception occured: "+ error);
		try{
			TestUtil.takeScreenshotAtEndOftest();
		}catch (IOException e){
			e.printStackTrace();
}
}
	public void beforeFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Attempting to find the element: " +by.toString());
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Successfully found the element: " +by.toString());
	}
	//these are non overridden methods of the weblistener class
	public void beforeScript(String script, WebDriver driver){
		
	}
	public void afterScript(String script, WebDriver driver){
		
	}
	public void beforeAcceptingAlert(WebDriver driver){
		
	}
	public void afterAcceptingAlert(WebDriver driver){
	}
	public void beforeDismissingAlert(WebDriver driver){
	
	}
	public void afterDismissingAlert(WebDriver driver){
	}
	public void beforeNavigatingRefresh(WebDriver driver){
		
	}
	public void afterNavigatingRefresh(WebDriver driver){
	}
	public void beforeChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
		
	}
	public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){

	}
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0, X arg1){
		
	}
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){
	}
	public void beforeGetText(WebElement arg0, WebDriver arg1){
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
	}
	public void beforeSwitchToWindow(String arg0, WebDriver arg1){
	
	}
	public void afterSwitchToWindow(String arg0, WebDriver arg1){
	
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}