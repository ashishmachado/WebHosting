package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class BasePage {
public WebDriver driver;

public BasePage(WebDriver driver)
{
	this.driver=driver;
}

public void verifyTitle(String eTitle){
	WebDriverWait wait=new WebDriverWait(driver,5);
	try{
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is matching:PASS",true);
	}
	
	catch(Exception e){
		Reporter.log("Title is Not matching:FAIL",true);
		Assert.fail();
	}
}
}
