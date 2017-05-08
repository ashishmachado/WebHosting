package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class InvalidLogin extends BaseTest{
@Test(priority=2)
public void testInvalidLogin() throws InterruptedException
{
	int rc=Excel.getRowCount(INPUT_PATH,"InvalidLogin");
	System.out.println("rc:"+rc);
	for(int i=1;i<=rc;i++){
		String un=Excel.getCellData(INPUT_PATH,"InvalidLogin",i,0);
	    String pw=Excel.getCellData(INPUT_PATH,"InvalidLogin",i,1);
	    System.out.println("username:"+un+" password:"+pw);
	    LoginPage l=new LoginPage(driver);
	    l.setUsername(un);
	    l.setPassword(pw);
	
	    l.clickLogin();
	    Thread.sleep(1000);
	    l.verifyErrMsgIsDisplayed();
	    
	}
}
}
