package NeoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class NeoStoxLoginPage
{
   @FindBy(className = "form-control") private WebElement MobNo;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signButton;
	
	public NeoStoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void SendMobNo(WebDriver driver, String MbN)
	{   utilityNeostoxusingPropertyfile.wait(driver, 3000);
		MobNo.sendKeys(MbN);
		Reporter.log("Sending mob no....",true);
	}
	
	public void clickSignINButton(WebDriver driver)
	{   utilityNeostoxusingPropertyfile.wait(driver, 3000);
		signButton.click();
		Reporter.log("clicking on submit button.......",true);
	}
}
