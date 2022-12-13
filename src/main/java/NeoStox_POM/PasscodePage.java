package NeoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class PasscodePage
{
	@FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement Passcode;
	@FindBy(xpath = "//a[text()='Submit']")private WebElement submitButton;
	
	public PasscodePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void SendPasscode(WebDriver driver,String PC)
	{    utilityNeostoxusingPropertyfile.wait(driver, 1000);
		Passcode.sendKeys(PC);
		Reporter.log("Sending passcode...",true);
	}

	public void ClickSubmitButton(WebDriver driver) throws InterruptedException
	{   Thread.sleep(3000);
		submitButton.click();
		Reporter.log("clicking on submit button....",true);
	}
	
}
