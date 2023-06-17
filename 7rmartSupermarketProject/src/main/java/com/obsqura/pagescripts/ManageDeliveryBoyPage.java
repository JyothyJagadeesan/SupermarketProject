package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage 
{
public WebDriver driver;
RandomDataUtility randomdatautility= new RandomDataUtility();
PageUtility pageutility= new PageUtility();
WaitUtility waitutility= new WaitUtility();
	
	public ManageDeliveryBoyPage  (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement manageDeliveryBoyMoreInfoOption;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newIcon;
	@FindBy(xpath="//input[@id='name']") WebElement nameField ;
	@FindBy(xpath="//input[@id='email']") WebElement emailField;
	@FindBy(xpath="//input[@id='phone']") WebElement phoneNumberField; 
	@FindBy(xpath="//textarea[@id='address']") WebElement addressfield;
	@FindBy(xpath="//input[@id='username']") WebElement userNameField ;
	@FindBy(xpath="//input[@id='password']") WebElement passwordField ;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//button[@class='close']") WebElement alertCloseButton;
	
	public ManageDeliveryBoyPage clickOnManageDeliveryboyMoreInfoOption()
	{
		manageDeliveryBoyMoreInfoOption.click();
		return this;
	}
	public ManageDeliveryBoyPage clickOnNewIcon()
	{
		newIcon.click();
		return this;
	}
	public ManageDeliveryBoyPage enterTheNameOnNameField()
	{
		nameField.sendKeys(randomdatautility.togetFullname());;
		return this;
	}
	public ManageDeliveryBoyPage enterTheEmailIDOnEmailField()
	{
		emailField.sendKeys(randomdatautility.togetemail());;
		return this;
	}
	public ManageDeliveryBoyPage enterThePhoneNumberOnPhoneNumberField()
	{
		emailField.sendKeys(randomdatautility.togetPhoneNo());;
		return this;
	}
	public ManageDeliveryBoyPage enterTheAddressOnAddressField ()
	{
		addressfield.sendKeys(randomdatautility.togetstreetAddress());	
		return this;
	}
	public ManageDeliveryBoyPage enterTheUserNameOnUserNameField()
	{
		userNameField.sendKeys(randomdatautility.togetFirstname());
		return this;
	}
	public ManageDeliveryBoyPage enterThePasswordOnPasswordField()
	{
		passwordField.sendKeys(randomdatautility.togetpass());
		return this;
	}
	public ManageDeliveryBoyPage scrollDown()
	{
		pageutility.scrollToElement(driver, saveButton);
		return this;		
	}
	public void clickOnSaveButton()
	{
		waitutility.fluentwaitForElementClickable(driver,saveButton );
		pageutility.toClickButton(driver, saveButton);
		
	}
	public boolean checkWhetherSuccessAlertIsDisplayed()
	{
		boolean isAlertDisplayed=alertMessage.isDisplayed();
		return isAlertDisplayed;
	}
	public void closeAlertButton()
	{
		alertCloseButton.click();	
	}
}
