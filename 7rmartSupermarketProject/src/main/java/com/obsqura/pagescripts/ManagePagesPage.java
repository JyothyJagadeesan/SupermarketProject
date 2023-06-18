package com.obsqura.pagescripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtility;

public class ManagePagesPage
{
public WebDriver driver;
PageUtility pageutility= new PageUtility();
	
	public ManagePagesPage (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement managePagesMoreInfoOption;
	@FindAll({@FindBy(xpath="//tbody//child::tr//td")}) List<WebElement> tableElement;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement editButton;	
	@FindBy(xpath="//input[@id='title']") WebElement titleInputField;
	@FindBy(xpath="//div[@class='note-editable card-block']") WebElement addDescription;
	@FindBy(xpath="//a[@role='button']") WebElement deleteButtonOfFile;
	@FindBy(xpath="//div[@class=' form-group']//child::input[@type='file']") WebElement chooseFile ;
	@FindBy(xpath="//button[@type='submit']") WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::button") WebElement closeAlertButton ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement addNewElementButton ;
	@FindBy(xpath="//input[@id='page']") WebElement pageName;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertMessage2;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton1;
	@FindBy(xpath="//input[@class='form-control']") WebElement searchTitleField;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement searchButton2;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deleteButton ;


	
	public ManagePagesPage clickOnManagePagesMoreInfoOption()
	{
		managePagesMoreInfoOption.click();
		return this;
	}
	
	public ManagePagesPage clickOnEditIconOfTheElementToBeEdited()
	{
		editButton.click();
		return this;
	}
	public ManagePagesPage clearTitleInputField()
	{
		titleInputField.clear();
		return this;
	}
	public ManagePagesPage enterTitleOnTheTitleInputField(String titleField)
	{
		
		titleInputField.sendKeys(titleField);
		return this;
	}
	public ManagePagesPage clearDescriptionInputField()
	{
		addDescription.clear();
		return this;
	}
	public ManagePagesPage enterDescriptionOnTheDescriptionInputField(String description )
	{
		addDescription.sendKeys(description);
		return this;
	}
	public ManagePagesPage chooseFile(String fileName)
	{
		chooseFile.sendKeys(fileName);
		return this;
	}
	public ManagePagesPage scrollDown()
	{
		pageutility.scrollToElement(driver, updateButton);
		return this;		
	}
	public void clickOnUpdateIcon()
	{
		pageutility.toClickButton(driver, updateButton);
		
	}
	public boolean checkWhetherTheElementIsUpdated()
	{
		boolean isAlertDisplayed=alertMessage.isDisplayed();
		return isAlertDisplayed;
	}
	public void closeAlertMessage()
	{
		closeAlertButton.click();
	}
	
	public ManagePagesPage clickOnAddIcon()
	{
		addNewElementButton.click();
		return this;
	}
    public ManagePagesPage enterPageNameOnPageNameTitleField(String pagename)
    {
    	pageName.sendKeys(pagename);
    	return this;
    }
    public ManagePagesPage clearPageNameTitlefield()
    {
    	pageName.clear();
    	return this;
    	
    }
    public ManagePagesPage scrollDownPage()
    {
    	pageutility.ScrollBy(driver);
    	return this;
    	
    }
    public ManagePagesPage clickOnSaveIcon()
    {
    	pageutility.toClickButton(driver, saveButton);	
    	return this;
    }
    public ManagePagesPage navigateBackToPreviousPage()
    {
    	driver.navigate().back();
    	return this;
    }
	
	public boolean checkWhetherTheElementIsAdded()
	{
		boolean isAlertDisplayed=alertMessage2.isDisplayed();
		return isAlertDisplayed;
	}
	
	public ManagePagesPage clickOnSerachIcon()
	{
		searchButton1.click();
		return this;
	}
	public ManagePagesPage enterTheElementOnSearchField(String searchElement)
	{
		searchTitleField.sendKeys(searchElement);
		return this;
	}
	public ManagePagesPage clickOnSerachButton()
	{
		searchButton2.click();
		return this;
	}
	boolean isElementFound=false;
	public boolean checkIfTheElementFound(String searchElement)
	{
		
		for(WebElement element:tableElement)
		{
			String actualElement=element.getText();
		    if(searchElement.equals(actualElement))
		    {
		    	isElementFound=true;
		    	break;
		    }  
		}
		return isElementFound;
	}
	
	public void deleteAnExistingElementInTheList(String elementToBeDeleted)
	{
	if(isElementFound==true)
	{	
		for(WebElement element:tableElement)
		{
			String actualElement=element.getText();
		    if(elementToBeDeleted.equals(actualElement))
		    {
		    	pageutility.getClickElement(element);
				driver.switchTo().alert().accept();
		    	break;
		    }
		
		}
	}
	}
	public void clickOnDeleteIconOfTheElementToBeDeleted()
	{
		if(isElementFound==true)
		{
		    deleteButton.click();
		}  
	}
	public void handleAlert()
	{
		if(isElementFound==true)
		{
		    driver.switchTo().alert().accept();
		}  
	}
	public boolean checkIfTheElementIsDeleted()
	{
		if(isElementFound==true)
		{
            boolean isAlertDisplayed=alertMessage.isDisplayed();
		    return isAlertDisplayed;
		}
		else
		{
			boolean isAlertDisplayed=false;
			return isAlertDisplayed;
		}
	}
	
}
