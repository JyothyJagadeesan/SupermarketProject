package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.ManageUsersPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class ManageUsersTest extends Base
{
	ManageUsersPage manageuserspage= new ManageUsersPage(driver);
	
	
	@Test(description="Verify that password detail is visible",retryAnalyzer = Retry.class)
	public void verifyThatOnClickingShowDetailsPasswordIsVisible()
	{
		ManageUsersPage manageuserspage= new ManageUsersPage(driver);
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		manageuserspage.clickOnManageUsersMoreInfoOption();
		manageuserspage.clickOnShowDetailsButton();
		boolean isPasswordVisible=manageuserspage.toViewThePasswordDetailsOfTheUser();
        assertTrue(isPasswordVisible,"password detaiils is not displayed");
		
	}
	

}
