package Scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Config {

	WebDriver driver;
	
	@BeforeTest	
	@Parameters("strbrowser")
	public void browerSetup(String browser) throws MalformedURLException
	{
		
		DesiredCapabilities cap ;	
		if(browser.equalsIgnoreCase("chrome"))
		{
			cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");			
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"),cap);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			cap = DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"),cap);
		}

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}


	@Test
	public void testA() {
		String strPageTitle =driver.getTitle();
		if(strPageTitle.equalsIgnoreCase("Google"))
		{
			System.out.println("Title of the page is: "+strPageTitle);
			System.out.println("Sandeep Pooja");

		}
		else
		{
			System.out.println("Test case is failed as title of the page is: "+strPageTitle);
		}
	}

	@AfterTest
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}

	}

}
