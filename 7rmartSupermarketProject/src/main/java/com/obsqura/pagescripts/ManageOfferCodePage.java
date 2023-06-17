package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.RandomDataUtility;
import Utilities.WaitUtility;

public class ManageOfferCodePage 
{
	public WebDriver driver;
	WaitUtility waitutility= new WaitUtility();
	RandomDataUtility randomdatautility= new RandomDataUtility();
	PageUtility pageutility= new PageUtility();
	public ManageOfferCodePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") WebElement ManageOfferCodeMoreInfoOption;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newIcon;
	@FindBy(xpath="//input[@id='offer_code']") WebElement offerCodeField ;
	@FindBy(xpath="//label[@class='radio-inline']//child::input[@value='yes']") WebElement yesRadioButton ;
	@FindBy(xpath="//input[@id='offer_per']") WebElement percentageField;
	@FindBy(xpath="//input[@id='offer_price']") WebElement amountField ;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	@FindBy(xpath="//button[@class='close']") WebElement alertCloseButton;
	
	public ManageOfferCodePage clickOnManageOfferCodePageMoreInfoOption()
	{
		ManageOfferCodeMoreInfoOption.click();
		return this;		
	}
	public ManageOfferCodePage clickOnNewIcon()
	{
		waitutility.fluentwaitForElementClickable(driver, newIcon);
		newIcon.click();
		return this;
	}
	public ManageOfferCodePage enterOfferCodeOnOfferCodeField(String offercode)
	{
		offerCodeField.sendKeys(offercode);
		return this;
	}
	public ManageOfferCodePage selectFirstOrderUser()
	{
		yesRadioButton.click();
		return this;
	}
	public ManageOfferCodePage enterPercentageOnPercentageField(String percentage)
	{
		percentageField.sendKeys(percentage);
		return this;
	}
	public ManageOfferCodePage enterAmountOnAmountField(String amount)
	{
		percentageField.sendKeys(amount);
		return this;
	}
	public ManageOfferCodePage scrollDown()
	{
		pageutility.scrollToElement(driver, saveButton);
		return this;		
	}
	public void clickOnSaveButton()
	{
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
