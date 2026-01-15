package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']") WebElement adminprofile;	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']") WebElement manageNewsMoreInfo;
	
	
	public HomePage adminClick()
	{
		adminprofile.click();
		return this;
	}
	
	public LoginPage adminLogoutClick()
	{
		logout.click();
		return new LoginPage(driver);
	}
	
	public AdminUserPage adminUsersMoreInfoClick()
	{
		adminUsersMoreInfo.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage manageNewsMoreInfoClick()
	{
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
}
