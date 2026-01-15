package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement newNewsbutton;
	@FindBy(xpath="//textarea[@id='news']") WebElement enterNewsField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveNewsButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newsSavedAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchNewNewsButton;
	@FindBy(xpath="//input[@class='form-control']") WebElement searchNewsField;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement seachNewsButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")List <WebElement> manageNewsTable;
	
	public ManageNewsPage clickNewNewsButton()
	{
		newNewsbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String news1value)
	{
		enterNewsField.sendKeys(news1value);
		return this;
	}
	
	public ManageNewsPage saveNewsButton()
	{
		saveNewsButton.click();
		return this;
	}
	//ALERT TO SAVE NEW NEWS
	
	public boolean isNewsSavedAlertDisplayed()
	{
		return newsSavedAlert.isDisplayed();
	}
	
	//SEARCH NEWS
	
	public ManageNewsPage searchNewNewsButtonClick()
	{
		searchNewNewsButton.click();
		return this;
	}	
	
	public ManageNewsPage enterNewsToSearch(String news1value)
	{
		searchNewsField.sendKeys(news1value);
		return this;
	}	
	
	public ManageNewsPage searchNewsButtonClick()
	{
		seachNewsButton.click();
		return this;
	}
	//ALERT AFTER THE SUCCESSFULL SEARCH FOR NEWS
	
	
    public int isNewsSearchFoundAlertDisplayed()
    {
    	int rowCount=manageNewsTable.size();
    	return rowCount;
    }

}
