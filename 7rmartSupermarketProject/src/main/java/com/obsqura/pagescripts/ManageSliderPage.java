package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageSliderPage
{
	public WebDriver driver;
	RandomDataUtility randomdatautility= new RandomDataUtility();
	PageUtility pageutility= new PageUtility();
	WaitUtility waitutility= new WaitUtility();
	
	public ManageSliderPage  (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") WebElement manageSliderPageMoreInfoOption;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newIcon;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath="//input[@name='link']") WebElement linkField; 
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//button[@class='close']") WebElement alertCloseButton;
	
	public ManageSliderPage clickOnManageSliderPageMoreInfoOption()
	{
		manageSliderPageMoreInfoOption.click();
		return this;
	}
	public ManageSliderPage clickOnNewIcon()
	{
		newIcon.click();
		return this;
	}
	public ManageSliderPage chooseFileName(String fileName)
	{
		chooseFile.sendKeys(fileName);
		return this;
	}
	public ManageSliderPage enterTheLinkOnLinkfield(String link)
	{
		linkField.sendKeys(link);
		return this;
	}
	public ManageSliderPage clickOnSaveButton ()
	{
		saveButton.click();
		return this;	
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

