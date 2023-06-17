package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.ManageDeliveryBoyPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	@Test(description="Verify that the user is able to add new delivery boy",retryAnalyzer = Retry.class)
	public void verifyThatTheUserIsAbleToAddANewDeliveryBoy()
	{
		LoginPage loginpage= new LoginPage(driver);
		ManageDeliveryBoyPage managedeliveryboypage= new ManageDeliveryBoyPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		managedeliveryboypage.clickOnManageDeliveryboyMoreInfoOption()
		 .clickOnNewIcon()
		 .enterTheNameOnNameField()
		 .enterTheEmailIDOnEmailField()
		 .enterThePhoneNumberOnPhoneNumberField()
		 .enterTheAddressOnAddressField()
		 .enterTheUserNameOnUserNameField()
		 .enterThePasswordOnPasswordField()
		 .scrollDown()
		 .clickOnSaveButton();
		boolean isAlertVisible=managedeliveryboypage.checkWhetherSuccessAlertIsDisplayed();
		assertTrue(isAlertVisible,"success alert is not displayed");
		managedeliveryboypage.closeAlertButton();
		
	}

}
