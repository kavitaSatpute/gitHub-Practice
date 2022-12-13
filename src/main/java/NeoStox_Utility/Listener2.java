package NeoStox_Utility;





import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import NeoStoxBase.Base_NeoStox;



public class Listener2 extends Base_NeoStox implements ITestListener
{   
	
	//on TC failed-->Invoked each time a test fails.
	
	public void onTestFailure(ITestResult result)
	{  // 1st way--> directly using method of ITestListener
	  // que asked---> How to take screenShot of failed TC
		String tResult = result.getTestName();
	   Reporter.log("TC  "+result.getName()+" is Failed please try again...",true);
	    
	   try 
	   {
		  utilityNeostoxusingPropertyfile.takeScreenshot(driver,tResult);
	      } 
	  catch (Exception e) 
	   {
		e.printStackTrace();
	   }                       //Prints this throwable and its backtrace to the standard error stream
		}
	
	// TC is passed--->Invoked each time a test succeeds
	public void onTestSuccess(ITestResult result)

	{   // 2nd way of--> by storing in ref. variable
	   
		String methodName = result.getName();   //The name of this TestResult, typically identical to the name of the method. 
	   Reporter.log("TC "+methodName+" is passed successfully.....", true);
	}
	
	
	
	//skipped TC --->Invoked each time a test is skipped
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC"+result.getName()+" is skipped please try again later....", true);	
	}
}
