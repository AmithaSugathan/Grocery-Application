package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
public WebDriver driver;//Instance Variable
WaitUtility waitutility=new WaitUtility();//Global declaration to make it accessible for every method
	
	
	public LoginPage(WebDriver driver) //Create Constructor with parameter WebDriver driver: local variable
	{
		this.driver=driver; //this used as Instance and Local variables are same
		PageFactory.initElements(driver, this);//PageFactory class has initElements class to initialize Elements
	}
	
	
	@FindBy(name="username") WebElement username;// Page Annotation to Find WebElement provided by POM with Page Factory
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement signinpage;
	
	
	public LoginPage enterUserNameToUserNameField(String usernamevalue) //Create methods for each actions
	{
		username.sendKeys(usernamevalue);//Valid Username. usernamevalue: to store excel read data
		return this;
	}
	
	public LoginPage enterPasswordToPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);//Valid Password. passwordvalue: to store excel read data
		return this;
	}
	
	public HomePage clickLoginButton()//As clicking on Login button will redirect to HomePage, return type is HomePage
	{
		waitutility.waitUntilElementToBeClickable(driver, loginButton);//Applying Wait
		loginButton.click();
		return new HomePage(driver);//To pass the control of driver to HomePage
	}
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
   public String isSigninPageTextReturned()
   {
	   return signinpage.getText();// get text "7rmart supermarket"
   }

}
