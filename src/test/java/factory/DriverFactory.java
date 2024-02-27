package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public class DriverFactory 
{
	
	static WebDriver driver = null;
	
	public static WebDriver initializeBrowser(String browserName) 
	
	{
		//Properties prop = ConfigReader.initializeProperties();

		if(browserName.equals("chrome")) {
			
			 driver=new ChromeDriver();
			
		}
		else if(browserName.equals("edge")) {
			
			 driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.get("https://tutorialsninja.com/demo/");
		
		return driver;
	
	}
	public static WebDriver getDriver() {
		
		return driver;
	}
}
