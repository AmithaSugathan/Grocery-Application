package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
public WebDriver driver;
PageUtility pageutility=new PageUtility();


public AdminUserPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newUserButton;
@FindBy(xpath="//input[@id='username']") WebElement newUserName1;
@FindBy(xpath="//input[@id='password']")WebElement newUserPassword1;
@FindBy(xpath="//select[@id='user_type']") WebElement newUserType1dropdown;
@FindBy(xpath="//button[@name='Create']")WebElement savenewuser1;
@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")WebElement newuseralert;
@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement newUserSearchButton;
@FindBy(xpath="//i[@class='fa fa-search']")WebElement searchusername;
@FindBy(xpath="//input[@id='un']") WebElement enterusernametosearch;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")List <WebElement> adminuserstable;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']") WebElement newUserReset;
@FindBy(xpath="//h4[text()='Admin Users']")WebElement adminuserstableinreset;
@FindBy(xpath="//select[@id='ut']")WebElement usertypedropdown;

//NEW USER BUTTON
public AdminUserPage newUserButtonClick()
{
newUserButton.click();
return this;
}

//ENTER NEW USERNAME

public AdminUserPage enterNewUserName(String newusername1value)
{
	newUserName1.sendKeys(newusername1value);
	return this;
}

//ENTER NEW PASSWORD

public AdminUserPage enterNewUserPassword(String newuserpassword1value)
{
	newUserPassword1.sendKeys(newuserpassword1value);
	return this;
}

//SELECT USERTYPE

public AdminUserPage selectNewUserType()
{
	pageutility.selectDragDropWithValue(newUserType1dropdown, "staff");
	//Select select=new Select(newUserType1dropdown);
	//select.selectByValue("staff");
	return this;
}

//SAVE NEW USER

public AdminUserPage createNewUserButton()
{
	savenewuser1.click();
	return this;
}

//NEW USER CREATED ALERT

public boolean isnewUserAlertDisplayed()
{
	return newuseralert.isDisplayed();
}

//NEW USER SEARCH

public AdminUserPage newUserSearchButtonClick()
{
newUserSearchButton.click();
return this;
}


public AdminUserPage enterNewlyAddedUserNameToSearch(String newusername1value)
{
enterusernametosearch.sendKeys(newusername1value);
return this;
}


public AdminUserPage enterNewlyAddedUserTypeToSearch()
{
	pageutility.selectDragDropWithValue(usertypedropdown, "staff");
	//Select select=new Select(usertypedropdown);
	//select.selectByValue("staff");
	return this;
}


public AdminUserPage searchButtonClick()
{
searchusername.click();
return this;
}

//NEWLY ADDED USER SEARCH CONDITION

public int isAdminUsersTableEmpty()
{
	int rowCount=adminuserstable.size();
	return rowCount;
	
}
//RESET BUTTON

public AdminUserPage newUserResetButton()
{
	newUserReset.click();	
	return this;
}


public boolean isAdminUsersTableDisplayed()
{
	return adminuserstableinreset.isDisplayed();
}

}
