package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;

public class MobileSliderPage 
{

	public WebDriver driver;
	PageUtility pageutility= new PageUtility();
	public MobileSliderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") WebElement mobileSliderMoreinfoOpption;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newIcon;
	@FindBy(xpath="//select[@class='form-control selectpicker']") WebElement selectCategory;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//button[@class='close']") WebElement alertCloseButton;
	
	public MobileSliderPage scrollDown()
	{
		pageutility.scrollToElement(driver,mobileSliderMoreinfoOpption);
		return this;		
	}
	public MobileSliderPage clickOnMobileSliderMoreInfoOption()
	{
		pageutility.toClickButton(driver, mobileSliderMoreinfoOpption);
		return this;	
	}
	public MobileSliderPage clickOnNewIcon()
	{
		newIcon.click();
		return this;	
	}
	public MobileSliderPage selectCategory()
	{
		Select select=new Select(selectCategory);
		select.selectByIndex(3);
		return this;	
	}
	public MobileSliderPage chooseFile(String fileName)
	{
		chooseFile.sendKeys(fileName);
		return this;
	}
	public MobileSliderPage clickOnSaveButton ()
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
