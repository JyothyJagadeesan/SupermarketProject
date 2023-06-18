package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage 
{
public WebDriver driver;
	
	public ManageUsersPage (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user']") WebElement manageUsersMoreInfoOption;
	@FindBy(xpath="//td[text()='03-Jun-2023']//preceding::td[@align='center']//child::div") WebElement showDetailsButton;
	@FindBy(partialLinkText="123")	WebElement passwordDetails;	
	@FindBy(xpath="//span[@class='badge bg-success']") WebElement activeButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::button") WebElement alertMessage;
	
	public void clickOnManageUsersMoreInfoOption()
	{
		manageUsersMoreInfoOption.click();
	}
	
	public void clickOnShowDetailsButton()
	{
		showDetailsButton.click();;
	}
			
	public boolean toViewThePasswordDetailsOfTheUser()
	{
		boolean passwordIsDisplayed=passwordDetails.isDisplayed();
        return passwordIsDisplayed;
	}
	
	public void toDismissAlert()
	{
		alertMessage.click();
	}
	
}
