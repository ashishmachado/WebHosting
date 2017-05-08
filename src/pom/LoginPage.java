package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;


public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement login;
	
	@FindBy(xpath="//nobr[contains(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
    public void setUsername(String un){
    	username.sendKeys(un);
    }
    
    public void setPassword(String pw){
    	password.sendKeys(pw);
    }
    
    public void clickLogin(){
    	login.click();
    }
    
    public void verifyVersion(String eVersion){
    	String aVersion=version.getText();
    	Assert.assertEquals(aVersion, eVersion);
    }
    
    public void verifyErrMsgIsDisplayed(){
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	
    try{
    wait.until(ExpectedConditions.visibilityOf(errMsg));
    Reporter.log("Err Msg is Displayed:PASS",true);
    }
    
    catch(Exception e){
    	Reporter.log("Err Msg is Not Displayed:FAIL",true);
       Assert.fail();
    }
    }
    
    
}
