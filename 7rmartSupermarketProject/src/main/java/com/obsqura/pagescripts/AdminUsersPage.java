package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import Utilities.RandomDataUtility;

public class AdminUsersPage 
{
	public WebDriver driver;
	PageUtility pageutility= new PageUtility();
	RandomDataUtility  randomdatautility= new RandomDataUtility ();
		
		public AdminUsersPage (WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement AdminUsersMoreInfoOPtion;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']" )WebElement newIcon;
	@FindBy(xpath="//input[@id='username']") WebElement userNameField;
	@FindBy(xpath="//input[@id='password']") WebElement passwordField;
	@FindBy(xpath="//select[@id='user_type']") WebElement selectUserType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::button") WebElement closeAlertButton ;
	
	public AdminUsersPage clickOnAdminUsersMoreInfoOption()
	{
		AdminUsersMoreInfoOPtion.click();
		return this;
	}
	public AdminUsersPage clickOnNewIcon()
	{
		newIcon.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnUserfield()
	{
		userNameField.sendKeys(randomdatautility.togetFullname());
		return this;
		
	}
	public AdminUsersPage  enterPasswordOnPasswordfield()
	{
		passwordField.sendKeys(randomdatautility.togetpass());
		return this;
		
	}
	
	public AdminUsersPage selectUserType()
	{
		Select select=new Select(selectUserType);
		select.selectByIndex(3);
		return this;
	}
	public AdminUsersPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean checkWhetherTheElementIAdded()
	{
		boolean isAlertDisplayed=alertMessage.isDisplayed();
		return isAlertDisplayed;
	}
	public void closeAlertMessage()
	{
		closeAlertButton.click();
	}
}