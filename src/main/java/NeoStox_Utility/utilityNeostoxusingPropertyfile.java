package NeoStox_Utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class utilityNeostoxusingPropertyfile 
{   
	 // commonly used methods-- like screenshot , wait ,scrollinto , reading data from excelsheet
	// all methods are static in utility
	
	public static String ReaddatafromPropertyFile(String key) throws IOException
	{ // create object of Properties file
		Properties prop = new Properties();
		
	  // create object of fileInputStream and pass Properties file path as parameter	
		
		FileInputStream myfile= new FileInputStream("C:\\Users\\Admin\\Maven_Project\\propertyClassNeostox.properties");
	    prop.load(myfile);
	    String value = prop.getProperty(key);
		Reporter.log("Reading"+key+"from property file", true);
		return value;
		
	}
	public static void takeScreenshot(WebDriver driver, String screenShotname) throws IOException
	{    wait(driver, 500);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File myfile=new File("D:\\Screenshot"+screenShotname+".png");
		FileHandler.copy(src, myfile);
		 Reporter.log("Taking screenshot...",true);
		
	}
	
	public static void scrollintoView(WebDriver driver,WebElement element)
	{
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].scrollIntoView(true)",element);
	   Reporter.log("Scrolling into view",true);
	}
	
	public static void wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for"+waitTime+"ms...",true);
		
	}
	
	

}
