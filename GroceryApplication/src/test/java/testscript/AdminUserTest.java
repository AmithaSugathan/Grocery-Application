package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test(description = "Verifying whether the User is able to ADD New User")

	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "loginpage"); // 0th row, 0th coloumn, sheetname
		String passwordvalue = ExcelUtility.getStringData(0, 1, "loginpage"); // 0th row, 1st column, sheetname

		RandomDataUtility randomdatautility = new RandomDataUtility();// To generate Random username and password
		// String newusername1value=ExcelUtility.getStringData(0, 0, "adminuserpage");
		// //0th row, 0th coloumn, sheetname
		// String newuserpassword1value=ExcelUtility.getStringData(0, 1,
		// "adminuserpage");
		String newusername1value = randomdatautility.getRandomUserName();
		String newuserpassword1value = randomdatautility.getRandonPassword();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage = loginpage.clickLoginButton();

		adminuserpage = homepage.adminUsersMoreInfoClick();

		// AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.newUserButtonClick().enterNewUserName(newusername1value)
				.enterNewUserPassword(newuserpassword1value).selectNewUserType().createNewUserButton();
		boolean isnewuseralertdisplayedvalue = adminuserpage.isnewUserAlertDisplayed();
		Assert.assertTrue(isnewuseralertdisplayedvalue, Constant.ADMINUNABLETOADDNEWUSER);

	}

	@Test(description = "Verifying whether the User is able to SEARCH the New User")

	public void verifyUserIsAbleToSearchNewlyAddedUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "loginpage"); // 0th row, 0th coloumn, sheetname
		String passwordvalue = ExcelUtility.getStringData(0, 1, "loginpage");
		String newusername1value = ExcelUtility.getStringData(0, 0, "adminuserpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage = loginpage.clickLoginButton();

		// HomePage homepage=new HomePage(driver);
		adminuserpage = homepage.adminUsersMoreInfoClick();

		// AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.newUserSearchButtonClick().enterNewlyAddedUserNameToSearch(newusername1value)
				.enterNewlyAddedUserTypeToSearch().searchButtonClick().isAdminUsersTableEmpty();
		int rowcountofusers = adminuserpage.isAdminUsersTableEmpty();
		Assert.assertTrue(rowcountofusers > 0, Constant.ADMINUNABLETOSEARCHNEWUSER);

	}

	@Test(description = "Verifying whether the User is able to RESET the page")

	public void verifyUserIsAbleToReset() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "loginpage"); // 0th row, 0th coloumn, sheetname
		String passwordvalue = ExcelUtility.getStringData(0, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameToUserNameField(usernamevalue).enterPasswordToPasswordField(passwordvalue);
		homepage = loginpage.clickLoginButton();
		// HomePage homepage=new HomePage(driver);
		adminuserpage = homepage.adminUsersMoreInfoClick();
		// AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.newUserResetButton();
		boolean isadminuserstabledisplayedvalue = adminuserpage.isAdminUsersTableDisplayed();
		Assert.assertTrue(isadminuserstabledisplayedvalue, Constant.ADMINUNABLETORESET);
	}

}
