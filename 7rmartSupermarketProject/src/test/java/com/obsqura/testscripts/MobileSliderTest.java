package com.obsqura.testscripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.MobileSliderPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class MobileSliderTest extends Base
{
	@Test(description="Verify that the user is able to add new mobile slider",retryAnalyzer = Retry.class)
	@Parameters("fileName")
	public void verifyThatTheUserIsAbleToAddNewMobileSlider(String fileName)
	{
		LoginPage loginpage= new LoginPage(driver);
		MobileSliderPage mobilesliderpage= new MobileSliderPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		mobilesliderpage.scrollDown();
		mobilesliderpage.clickOnMobileSliderMoreInfoOption().clickOnNewIcon().selectCategory().chooseFile(fileName).clickOnSaveButton();
		boolean isAlertVisible=mobilesliderpage.checkWhetherSuccessAlertIsDisplayed();
		mobilesliderpage.closeAlertButton();
		
	}

}
