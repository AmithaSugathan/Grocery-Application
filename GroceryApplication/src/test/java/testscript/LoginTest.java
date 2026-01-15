package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	HomePage homepage;//Reference Variable to implement Chaining
	
	@Test(priority=1, description="Verifying whether User can Login with Valid Credentials", groups= {"smoke"} )
	public void validateUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "loginpage"); //0th row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(0, 1, "loginpage"); //0th row, 1st column, sheetname
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage=loginpage.clickLoginButton();
		//assertTrue()
		boolean isdashboarddisplayedvalue=loginpage.isDashboardDisplayed();	
		Assert.assertTrue(isdashboarddisplayedvalue, Constant.VALIDCREDENTIALERROR); //Error msg is false condition
		
	}
	
	@Test(priority=2, description="Verifying whether User can Login with Invalid Credentials", retryAnalyzer=retry.Retry.class)
	public void validateUserWithInvalidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage"); //1th row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(1, 1, "loginpage"); //1th row, 1st column, sheetname
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue).clickLoginButton();
		String expectedtext="7rmart supermarket";
		String actualtext=loginpage.isSigninPageTextReturned();
		Assert.assertEquals(actualtext, expectedtext, Constant.INVALIDCREDENTIALERROR);//Error msg is displayed on Jenkins console
	}
	
	@Test(priority=3,description="Verifying whether User can Login with Invalid Username and Valid Password")	
	public void validateUserWithInvalidUsernameValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "loginpage"); //2ndh row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(2, 1, "loginpage"); //2nd row, 1st column, sheetname
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue).clickLoginButton();
		String expectedtext="7rmart supermarket";
		String actualtext=loginpage.isSigninPageTextReturned();
		Assert.assertEquals(actualtext, expectedtext, Constant.INVALIDUSERNAMEVALIDPASSWORDERROR );//Error msg is displayed on Jenkins console
	}
	
	@Test(priority=4, description="Verifying whether User can Login with Valid Username and Invalid Password", groups= {"smoke"}, dataProvider = "loginProvider")	
	public void validateUserWithValidUsernameInvalidPassword(String usernamevalue, String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "loginpage"); //3rd row, 0th coloumn, sheetname
		//String passwordvalue=ExcelUtility.getStringData(3, 1, "loginpage"); //3rd row, 1st column, sheetname
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue).clickLoginButton();
		String expectedtext="7rmart supermarket";
		String actualtext=loginpage.isSigninPageTextReturned();
		Assert.assertEquals(actualtext, expectedtext, Constant.VALIDUSERNAMEINVALIDPASSWORDERROR);//Error msg is displayed on Jenkins console
	}
	
	//Used instead of Excel Read, so no need of lines 64,65
	@DataProvider(name = "loginProvider")//DataProvider Name: loginProvider
	public Object[][] getDataFromDataProvider() throws IOException {//return type is Object

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },//Returns objects, here 2 objects
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
