package com.obsqura.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;
import com.obsqura.pagescripts.MobileSliderPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class MobileSliderTest extends Base
{
	@Test(description="Verify that the user is able to add new mobile slider",dataProvider="MobileSliderProvider",retryAnalyzer = Retry.class)
	public void verifyThatTheUserIsAbleToAddNewMobileSlider(String file)
	{
		LoginPage loginpage= new LoginPage(driver);
		MobileSliderPage mobilesliderpage= new MobileSliderPage(driver);
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage"));
		loginpage.clickOnSignInButton();
		mobilesliderpage.scrollDown();
		mobilesliderpage.clickOnMobileSliderMoreInfoOption().clickOnNewIcon().selectCategory().chooseFile(file).clickOnSaveButton();
		boolean isAlertVisible=mobilesliderpage.checkWhetherSuccessAlertIsDisplayed();
		mobilesliderpage.closeAlertButton();
		
	}
	@DataProvider(name="MobileSliderProvider")
	public Object[][] getDataFromTestData()
	{
		return new Object[][]
				{
		        	{"C:\\Users\\Joe\\Pictures\\others\\photography\\IMG_20190621_192052-01.jpeg"}
			
				};
		
	}; 
	 
}
