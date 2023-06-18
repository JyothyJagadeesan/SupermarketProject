package com.obsqura.testscripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.ManageSliderPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class ManageSliderTest extends Base
{
	@Test(description="Verify that the user is able to add new slider to the list",retryAnalyzer = Retry.class)
	@Parameters({"fileName","link"})
	public void verifyThatTheUserIsAbleToAddNewSliderToTheList(String filename, String link)
	{
		LoginPage loginpage= new LoginPage(driver);
		ManageSliderPage managesliderpage= new ManageSliderPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
	    managesliderpage.clickOnManageSliderPageMoreInfoOption()
		.clickOnNewIcon()
	    .chooseFileName(filename)
		.enterTheLinkOnLinkfield(link).clickOnSaveButton();
		managesliderpage.checkWhetherSuccessAlertIsDisplayed();
		managesliderpage.closeAlertButton();
	}
}