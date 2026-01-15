package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithIndex(WebElement element, int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	public void selectDropDrownWithSelectByVisibleText(WebElement dropdown,String VisibleText)
	{
		Select select=new Select(dropdown);
		select.selectByVisibleText(VisibleText);
	}
	
	public void javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;//JavascriptExecutor is an Interface, no obj creation. js: reference. The process is Casting [interface inside
		js.executeScript("arguments[0].click();", element);
		}
	public void userClick(WebElement element) {
		element.click();
	}
	
	public void sendTextToTextFieldElement(WebElement element,String text) 
	{
		element.sendKeys(text);
	}
	public void actionsDoubleClick(WebDriver  driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	public void actionsRightClick(WebDriver  driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
    public void actionDragAndDrop(WebDriver driver,WebElement sourceElement,WebElement destinationElement)
    
    {
  	  Actions actions=new Actions(driver);
  	  actions.dragAndDrop(sourceElement, destinationElement).build().perform();
    }
    public String getTextAlert(WebDriver driver)
    {
  	 String alertText=driver.switchTo().alert().getText();
	 return alertText; 
    }
    public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
    public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}    
    
}
