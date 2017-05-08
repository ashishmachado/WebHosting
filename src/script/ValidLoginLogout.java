package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class ValidLoginLogout extends BaseTest{
	@Test(priority=1)
	public void testValidLoginLogout() throws InterruptedException{
		String un=Excel.getCellData(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw=Excel.getCellData(INPUT_PATH, "ValidLoginLogout", 1, 1);
		String homePage=Excel.getCellData(INPUT_PATH, "ValidLoginLogout", 1, 2);
		String loginPage=Excel.getCellData(INPUT_PATH, "ValidLoginLogout", 1, 3);
		
		//enter valid username
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
		
		//enter valid password
		l.setPassword(pw);
		
		//click on login
		l.clickLogin();
		
		//verify that homePage is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(homePage);
		
		Thread.sleep(5000);
		//click on logout
		e.clickLogout();
		
		//verify that login page is displayed
		l.verifyTitle(loginPage);
		
	}

}
