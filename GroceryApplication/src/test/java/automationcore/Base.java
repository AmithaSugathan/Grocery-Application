package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class Base {
	Properties properties;//Predefined class; Properties. Reference variable: properties
	FileInputStream fileinputstream;//
	
public WebDriver driver; //Global declaration
	
	@BeforeMethod(alwaysRun=true)//alwaysRun for Grouping to copy base class properties while running grouped test cases
	@Parameters("browsers")
	public void initialiseBrowser(String browsers) throws IOException
	{
		properties=new Properties();
		fileinputstream=new FileInputStream(Constant.CONFIGFILE);
		properties.load(fileinputstream);
		
		if(browsers.equalsIgnoreCase("Chrome")){     //equalsIgnoreCase for ignoring case sensitivity in browser names
			driver=new ChromeDriver();				//ChromeDriver is a class inside WebDriver Interface
		}
		else if(browsers.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");  //GET() to Launch URL
		
		driver.get(properties.getProperty("url")); 
		driver.manage().window().maximize();   //To Maximize window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit Wait. Duration Class
	}
	
	@AfterMethod(alwaysRun=true)
	
/*public void closeBrowser()
{
	//driver.close();
	//driver.quit();
}*/
	public void driverQuit(ITestResult iTestResult) throws IOException {//instead of closeBrowser()
   //ITestResult:Interface to manage the life cycle of a Test Case

		if (iTestResult.getStatus() == ITestResult.FAILURE) {//If Failure, create an obj for class ScreenShotUtility

		ScreenShotUtility screenShot = new ScreenShotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());//iTestResult.getName(): Gives the Method Name of the failed test case
		}
		//driver.quit();

		}

}
