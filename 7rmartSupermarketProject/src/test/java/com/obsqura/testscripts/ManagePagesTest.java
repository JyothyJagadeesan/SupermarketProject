package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.ManagePagesPage;

import Retry.Retry;
import Utilities.ExcelUtility;


public class ManagePagesTest extends Base
{
	

	@Test(description="Verify that the user is able to add new element",retryAnalyzer = Retry.class)
	public void verifyThatTheUserIsAbleToAddANewElementToTheManagePages()
	{
		LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption()
		.clickOnAddIcon()
		.enterTitleOnTheTitleInputField(ExcelUtility.getString(4, 0, "ManagePagesPage"))
		.enterDescriptionOnTheDescriptionInputField(ExcelUtility.getString(4, 1, "ManagePagesPage"))
		.enterPageNameOnPageNameTitleField(ExcelUtility.getString(4, 2, "ManagePagesPage"))
		.scrollDownPage();
		managepagespage.clickOnSaveIcon();
		boolean isAlertVisible=managepagespage.checkWhetherTheElementIsAdded();
		assertTrue(isAlertVisible,"Element is not added, successfull alert is not displayed");
	}
	
	@Test(description="Verify that the user is able to search an element",retryAnalyzer = Retry.class)
	@Parameters("searchElement")
	public void verifyThatTheUserIsAbleToSearchTheElementsInTheList(String searchelement)
	{
		LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption().clickOnSerachIcon().enterTheElementOnSearchField(searchelement).clickOnSerachButton();
		boolean isElementVisible=managepagespage.checkIfTheElementFound(searchelement);
		assertTrue(isElementVisible,"the element that is searched is not found in the list");
		
	}
	
	@Test(description="Verify that the user is able to edit an existing element",retryAnalyzer = Retry.class)
	@Parameters({"editElement","title","description","pagename","filename"})
	public void verifyThatTheUserIsAbleToEditAnElementInTheMangePages(String editElement,String title, String description, String pagename, String filename)
	{
		LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption()
		.clickOnSerachIcon().enterTheElementOnSearchField(editElement).clickOnSerachButton().clickOnEditIconOfTheElementToBeEdited()
		.clearTitleInputField().enterTitleOnTheTitleInputField(title).clearDescriptionInputField().enterDescriptionOnTheDescriptionInputField(description)
	    .clearPageNameTitlefield().enterPageNameOnPageNameTitleField(pagename).chooseFile(filename).scrollDown().clickOnUpdateIcon();
		boolean isAlertVisible=managepagespage.checkWhetherTheElementIsUpdated();
		managepagespage.closeAlertMessage();
		assertTrue(isAlertVisible,"Element is not updated, successfull alert is not displayed");
	}
	
	@Test(description="Verify that the user is able to delete an existing element")
	@Parameters("deleteElement")
	public void verifyThatTheUserIsableToDeleteAnExistingElement(String deleteElement)
	{
        LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption().clickOnSerachIcon().enterTheElementOnSearchField(deleteElement).clickOnSerachButton();
		managepagespage.checkIfTheElementFound(deleteElement);
		managepagespage.clickOnDeleteIconOfTheElementToBeDeleted();
		managepagespage.handleAlert();
		boolean isElementDeleted=managepagespage.checkIfTheElementIsDeleted();
		assertTrue(isElementDeleted,"The given element doesnot found in the list");
		
		
	}
}
