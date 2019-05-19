package com.api.ui.ExtentReport.Listener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter{
	private ExtentReports extent; //this is created as private because dont wanna share info with other projects
	
	//xml suite has all the classes that we will use. testing type(smoke, regression, sanity)
	//isuite- class pages(Login, checkout)
	                      //where listener path is from xmlsuites  //where listener path is from parameter suites
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, 
		String outputDirectory){
	
	//
	//extent.html is the file created/says to save the file as that specified name
	//generate this report only if its true
	extent = new ExtentReports(outputDirectory + File.separator
			+ "Extent.html", true);
	//two additional new line of code that I forgot Earlier
	for(ISuite suite : suites){ //for loop, at child suites, telling results to get results
		Map<String, ISuiteResult>result = suite.getResults(); //map cannot contain duplicate value, unique value to one location(extent report)
		//map is an interface in java generally which allows you to map one key to one value.
	
	for(ISuiteResult r : result.values()){
		ITestContext context =r.getTestContext();
		
		buildTestNo(context.getPassedTests(), LogStatus.PASS);
		buildTestNo(context.getFailedTests(), LogStatus.FAIL);
		buildTestNo(context.getSkippedTests(), LogStatus.SKIP);
			
	}
}
extent.flush(); //assume execution is complete, add to the attachment or html file we have
extent.close(); //close the report when its done adding results

}

private void buildTestNo(IResultMap tests, LogStatus status){
	ExtentTest test; //calling extenttest and making object named test;
	
	if(tests.size()>0){
		for (ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());
			
			//these two lines will retrieve the starting time of the test and the ending time of the test
			//and report how long it took
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			
			//group them in pass, fail or skip
			for(String group : result.getMethod().getGroups())
				test.assignCategory(group);
			
			//if theres an error, log the errors
			if(result.getThrowable() !=null){
				test.log(status, result.getThrowable());
			}else{ 
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				
		}
			extent.endTest(test);
			
	}
}
}
private Date getTime(long millis){
	Calendar calender = Calendar.getInstance();
	calender.setTimeInMillis(millis);
	return calender.getTime();
	
	
}
}
