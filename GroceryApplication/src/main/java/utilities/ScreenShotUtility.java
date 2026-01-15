package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {
	//failedTestCase:Method Name of the failed test case is stored

		TakesScreenshot scrShot = (TakesScreenshot) driver;// TakesScreenshot:Interface to take screen shot. scrShot: Reference variable.
		//(TakesScreenshot) driver :Casting
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//The Failed Screenshot is stored in File screenShot.
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//Current time is stored in timeStamp

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//Create File f1 in directory. ystem.getProperty("user.dir"): Project's path. OutputScreenShot: A new Folder to store screenshots is created
		if (!f1.exists()) {//In case no File fi is created, create directory by calling mkdirs()

		f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);//Create File finalDestination
		FileHandler.copy(screenShot, finalDestination);//Copy the screenshot in File screenShot to File finalDestination
		}

}
