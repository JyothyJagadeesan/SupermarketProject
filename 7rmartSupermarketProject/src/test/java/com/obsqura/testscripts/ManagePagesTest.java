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
	

	@Test(description="Verify that the user ia able to add new element",retryAnalyzer = Retry.class)
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
		boolean isAlertVisible=managepagespage.toCheckWhetherTheElementIsAdded();
		assertTrue(isAlertVisible,"Element is not added, successfull alert is not displayed");
	}
	
	@Test(description="Verify that the user ia able to search an element",retryAnalyzer = Retry.class)
	@Parameters("searchElement")
	public void verifyThatTheUserIsAbleToSearchTheElementsInTheList(String searchelement)
	{
		LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption();
		managepagespage.clickOnSerachIcon();
		managepagespage.enterTheElementOnSearchField(searchelement);
		managepagespage.clickOnSerachButton();
		boolean isElementVisible=managepagespage.toCheckIfTheElementFound(searchelement);
		assertTrue(isElementVisible,"the element that is searched is not found in the list");
		
	}
	
	@Test(description="Verify that the user ia able to edit an existing element",retryAnalyzer = Retry.class)
	@Parameters({"editElement","title","description","pagename","filename"})
	public void verifyThatTheUserIsAbleToEditAnElementInTheMangePages(String editElement,String title, String description, String pagename, String filename)
	{
		LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption();
		managepagespage.clickOnSerachIcon();
		managepagespage.enterTheElementOnSearchField(editElement);
		managepagespage.clickOnSerachButton();
		managepagespage.clickOnEditIconOfTheElementToBeEdited();
		managepagespage.clearTitleInputField();
		managepagespage.enterTitleOnTheTitleInputField(title);
		managepagespage.clearDescriptionInputField();
		managepagespage.enterDescriptionOnTheDescriptionInputField(description);
		managepagespage.clearPageNameTitlefield();
		managepagespage.enterPageNameOnPageNameTitleField(pagename);
		managepagespage.chooseFile(filename);
		managepagespage.scrollDown();
		managepagespage.clickOnUpdateIcon();
		boolean isAlertVisible=managepagespage.checkWhetherTheElementIsUpdated();
		managepagespage.closeAlertMessage();
		assertTrue(isAlertVisible,"Element is not updated, successfull alert is not displayed");
	}
	
	@Test(description="Verify that the user ia able to delete an existing element")
	@Parameters("deleteElement")
	public void verifyThatTheUserIsableToDeleteAnExistingElement(String deleteElement)
	{
        LoginPage loginpage= new LoginPage(driver);
		ManagePagesPage managepagespage= new ManagePagesPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managepagespage.clickOnManagePagesMoreInfoOption();
		managepagespage.clickOnSerachIcon();
		managepagespage.enterTheElementOnSearchField(deleteElement);
		managepagespage.clickOnSerachButton();
		managepagespage.clickOnDeleteIconOfTheElementToBeDeleted();
		managepagespage.handleAlert();
		boolean isElementDeleted=managepagespage.toCheckIfTheElementIsDeleted();
		assertTrue(isElementDeleted,"the given element is deleted from the list");
		
		
	}
}
