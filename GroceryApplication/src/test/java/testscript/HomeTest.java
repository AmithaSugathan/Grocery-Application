package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	HomePage homepage;
	@Test(description="Verifying whether Admin can Successfully logout")
	
	public void verifyAdminLogOut() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "loginpage"); //0th row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(0, 1, "loginpage"); //0th row, 1st column, sheetname
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage=loginpage.clickLoginButton();
		
		
		homepage.adminClick();
		loginpage=homepage.adminLogoutClick();//as control passes to LoginPage
		
		String expectedtext="7rmart supermarket";
		String actualtext=loginpage.isSigninPageTextReturned();
		Assert.assertEquals(actualtext, expectedtext,Constant.ADMINUNABLETOLOGOUT);
	}

}
