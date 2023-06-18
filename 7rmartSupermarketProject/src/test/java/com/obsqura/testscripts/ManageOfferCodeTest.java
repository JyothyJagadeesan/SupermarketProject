package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.ManageOfferCodePage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base
{
	
	@Test(description="Verify that the user is able to add new offercode",retryAnalyzer = Retry.class)
	public void verifyThatTheuserIsAbleToAddNewOfferCode()
	{
		LoginPage loginpage= new LoginPage(driver);
		ManageOfferCodePage manageoffercodepage= new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		manageoffercodepage.clickOnManageOfferCodePageMoreInfoOption()
		.clickOnNewIcon().enterOfferCodeOnOfferCodeField(ExcelUtility.getString(1, 0, "ManageOfferCodePage")).selectFirstOrderUser()
		.enterPercentageOnPercentageField(ExcelUtility.getString(1, 1, "ManageOfferCodePage")).enterAmountOnAmountField(ExcelUtility.getString(1, 2, "ManageOfferCodePage"))
		.scrollDown().clickOnSaveButton();
		boolean isAlertVisible=manageoffercodepage.checkWhetherSuccessAlertIsDisplayed();
		assertTrue(isAlertVisible,"success alert is not displayed");
		manageoffercodepage.closeAlertButton();
	}
}
