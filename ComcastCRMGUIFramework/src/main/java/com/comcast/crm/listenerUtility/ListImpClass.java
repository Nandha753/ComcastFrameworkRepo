package com.comcast.crm.listenerUtility;
/**
 * @author Nandhakumar J
 */


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener{
	
		public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
			System.out.println("Report configuration");
	}
		public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
			System.out.println("Report Backup");
		}
		public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
			System.out.println("===== =====>"+result.getMethod().getMethodName()+">==========");
		
		}
		
		
		public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
			System.out.println("===== =====>"+result.getMethod().getMethodName()+">==========");
		}
	
		public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
			String testName = result.getMethod().getMethodName();
			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			String time =new Date().toString().replace(" ","_").replace(":","_");
			try {
				FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+"+"+time+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		}
		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
			
		}
		
		public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		}
		 
		public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		}
		
		public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		}
}
