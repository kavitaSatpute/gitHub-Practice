package NeoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class Base_NeoStox {

	protected static WebDriver driver;
   public void LaunchBrowser() throws InterruptedException, IOException 
   {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get(utilityNeostoxusingPropertyfile.ReaddatafromPropertyFile("url"));
        driver.manage().window().maximize();
        Thread.sleep(1000);
        Reporter.log("Launching Browser...",true);
        
   }
   
	
	
	
   
   
	
   public void closingBrowser(WebDriver driver)
  {   utilityNeostoxusingPropertyfile.wait(driver, 1000);
       Reporter.log("Closing Browser...",true);
	   driver.close();
   }
}
