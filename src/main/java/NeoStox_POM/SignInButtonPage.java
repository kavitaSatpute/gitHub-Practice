package NeoStox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NeoStox_Utility.utilityNeostoxusingPropertyfile;

public class SignInButtonPage
{
    @FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signInButton;

    public SignInButtonPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    
    public void clickOnSignInButton(WebDriver driver)
    {   utilityNeostoxusingPropertyfile.wait(driver, 1000);
    	signInButton.click();
    }
    
    
    
    
    
    
    
    
    
    
    
}
