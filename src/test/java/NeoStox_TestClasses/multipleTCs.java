package NeoStox_TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NeoStoxBase.Base_NeoStox;
import NeoStox_POM.HomePage;
import NeoStox_POM.NeoStoxLoginPage;
import NeoStox_POM.PasscodePage;
import NeoStox_POM.SignInButtonPage;
import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class multipleTCs extends Base_NeoStox
{    
      
	  NeoStoxLoginPage login;
	  PasscodePage psc;
	  HomePage HP;
	  SignInButtonPage signIn;
	  
	@BeforeClass
	public void LaunchingBrowser() throws InterruptedException, IOException
	{ 
		
	 LaunchBrowser();   // method from base class
	  
	  login=new NeoStoxLoginPage(driver);
	  psc=new PasscodePage(driver);
	  HP=new HomePage(driver);
	  signIn=new SignInButtonPage(driver);
	}
	
	@BeforeMethod
	public void loginPage() throws EncryptedDocumentException, IOException, InterruptedException
	{    signIn.clickOnSignInButton(driver);
	    login.SendMobNo(driver, utilityNeostoxusingPropertyfile.ReaddatafromPropertyFile("mobNo"));
		login.clickSignINButton(driver);
		psc.SendPasscode(driver,utilityNeostoxusingPropertyfile.ReaddatafromPropertyFile("password"));
		psc.ClickSubmitButton(driver);
		HP.ClickOnPopUps(driver);
	}
	
    @Test 
    public void validation() throws EncryptedDocumentException, IOException, InterruptedException 
    {   
       Assert.assertNotEquals(HP.GetAccntBlnc(driver),"TC is Failed unable to fetch the balance");
	    
    }
    @Test (priority=-1)
	   public void validationUserId() throws EncryptedDocumentException, IOException, InterruptedException 
	  {   
	    Assert.assertEquals(HP.ActualUserId(driver),utilityNeostoxusingPropertyfile.ReaddatafromPropertyFile("userName"),"TC is Failed Actual and Expected UserName is not matching");
	   utilityNeostoxusingPropertyfile.takeScreenshot(driver,HP.ActualUserId(driver));  
		  
	   }
    @AfterMethod
    public void logout()
    {
    	HP.ClickOnLogOutButton(driver);
    }
    
    @AfterClass
    public void ClosingBrowser()
    {   Reporter.log("Closing Browser..", true);
    	driver.close();
    }
    
}
