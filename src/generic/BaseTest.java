package generic;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;





public abstract class BaseTest implements AutoConst{
	public WebDriver driver;
	
	@Parameters({"node","browser"})
	@BeforeMethod
	public void openApplication(String node,String browser) throws MalformedURLException{
		URL url=new URL(node);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(url,dc);

		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
	}
	@AfterMethod
	public void closeApplication(){
		driver.quit();	
	}

}
