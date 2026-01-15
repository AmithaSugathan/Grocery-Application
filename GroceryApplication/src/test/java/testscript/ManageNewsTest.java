package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description="Verifying whether the User is able to ADD New NEWS")
	
	public void verifyUserIsAbleToAddNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "loginpage"); //0th row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(0, 1, "loginpage");
		String newnewsvalue=ExcelUtility.getStringData(0, 0, "managenewspage"); 
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage=loginpage.clickLoginButton();
		
		//HomePage homepage=new HomePage(driver);
		managenewspage=homepage.manageNewsMoreInfoClick();
		
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickNewNewsButton().enterNews(newnewsvalue).saveNewsButton();
		boolean isNewsSavedAlertSiaplayedValue=managenewspage.isNewsSavedAlertDisplayed();
		Assert.assertTrue(isNewsSavedAlertSiaplayedValue, Constant.USERUNABLETOADDNEWS);		
		
	}
	@Test(description="Verifying whether the User is able to SEARCH Newly Added NEWS")
	public void verifyUserIsAbleToSearchNewlyAddedNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "loginpage"); //0th row, 0th coloumn, sheetname
		String passwordvalue=ExcelUtility.getStringData(0, 1, "loginpage");
		String newnewsvalue=ExcelUtility.getStringData(0, 0, "managenewspage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage=loginpage.clickLoginButton();
		
		//HomePage homepage=new HomePage(driver);
		managenewspage=homepage.manageNewsMoreInfoClick();
		
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.searchNewNewsButtonClick().enterNewsToSearch(newnewsvalue).searchNewsButtonClick();
		int rowcountofusers=managenewspage.isNewsSearchFoundAlertDisplayed();
		Assert.assertTrue(rowcountofusers>0, Constant.USERUNABLETOSEARCHNEWS);	
		
	}	
	
}