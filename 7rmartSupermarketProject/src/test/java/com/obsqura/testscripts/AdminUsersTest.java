package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.AdminUsersPage;
import com.obsqura.pagescripts.LoginPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
	@Test(retryAnalyzer = Retry.class)
	public void verifyThatTheUserIsAbleToAddANewUserToTheAdminUsersPage()
	{
		LoginPage loginpage= new LoginPage(driver);
		AdminUsersPage adminuserspage= new AdminUsersPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		adminuserspage.clickOnAdminUsersMoreInfoOption().clickOnNewIcon()
		.enterUsernameOnUserfield()
		.enterPasswordOnPasswordfield()
		.selectUserType().clickOnSaveButton();
		boolean isAlertVisible=adminuserspage.checkWhetherTheElementIAdded();
		assertTrue(isAlertVisible,"Element is not added, successfull alert is not displayed");
	}
	

}
