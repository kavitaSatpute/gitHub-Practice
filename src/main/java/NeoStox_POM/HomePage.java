package NeoStox_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class HomePage 
{   
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement PopUp1;
    @FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement PopUp2;
    @FindBy(xpath = "(//span[text()='Hi Kavita S.'])[1]")private WebElement UserName;
    @FindBy(xpath = "//span[text()='Rs.5,00,000.00']")private WebElement AccBlnc;
    @FindBy(xpath = "//span[text()='Logout']")private WebElement LogOut;
   
   
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  
  public void ClickOnPopUps(WebDriver driver) throws InterruptedException 
  {   Thread.sleep(3000);
	   if(PopUp1.isDisplayed())
  {  utilityNeostoxusingPropertyfile.wait(driver, 3000);
	 PopUp1.click();
	 Reporter.log("handled popUp1....",true);
	 Thread.sleep(2000);
	 PopUp2.click();  
	 Reporter.log("handled popUp2....",true);
  }
	  else
  {   Reporter.log("no PopUp found....",true);
	  Thread.sleep(1000);
	  
  }
   } 
   public String ActualUserId(WebDriver driver) throws InterruptedException, IOException
  {  
	   utilityNeostoxusingPropertyfile.wait(driver, 2000);
	   String actUId = UserName.getText();
	   Reporter.log("Actual UserName is."+actUId, true);
       String realUId = actUId.substring(3);
       Reporter.log("Real UserName is."+realUId, true);
       return actUId;
	  
  }
  
  public String GetAccntBlnc(WebDriver driver)
  {   utilityNeostoxusingPropertyfile.wait(driver, 2000);
	  String accblnc = AccBlnc.getText();
	  Reporter.log("getting accnt blnc....",true);
	  Reporter.log("AccntBlnc is"+accblnc,true);
	 return accblnc;  
  }
  
  public void ClickOnLogOutButton(WebDriver driver) 
  {  
	  AccBlnc.click();
	  utilityNeostoxusingPropertyfile.wait(driver, 1000);
	  LogOut.click();
	  Reporter.log("Logging out Application....",true);
  }
  }
