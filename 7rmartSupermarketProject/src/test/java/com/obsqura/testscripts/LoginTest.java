package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pagescripts.LoginPage;

import Retry.Retry;
import Utilities.ExcelUtility;

public class LoginTest extends Base
{
	// to give priority
	@Test(retryAnalyzer = Retry.class,priority = 1,enabled = true,description = "TC006_Verify home page title",groups = {"Regression"})

    public void verifyTheUserCanAbletoLoginwithValidusernameandValidPasswordWhileClickonSignInButton()
    {
		LoginPage loginpage= new LoginPage(driver);
		//chaining of pages
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordfield(ExcelUtility.getString(1, 1,"LoginPage")).clickOnSignInButton();
	    boolean isHomePageElementVisible=loginpage.toCheckWhetherTheElementExist();
		assertTrue(isHomePageElementVisible,"Unable to login with valid username and correct password");
	}

	@Test
	public void verifyThatTheUserWontBeAbletoLoginwithValidusernameandIncorrectPasswordWhileClickonSignInButton()
    {
		String expectedMessage="Sign In";
		LoginPage loginpage= new LoginPage(driver);
        String actualMessage=loginpage.toCheckWhetherWeAreStillOnLoginPage();
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(2, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordfield(ExcelUtility.getString(2, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		assertEquals(expectedMessage,actualMessage,"able to login with valid username and incorrect password");
	}
	
	@Test
	public void verifyThatTheUserWontBeAbletoLoginwithInvalidusernameandcorrectPasswordWhileClickonSignInButton()
    {
		String expectedMessage="Sign In";
		LoginPage loginpage= new LoginPage(driver);
		String actualMessage=loginpage.toCheckWhetherWeAreStillOnLoginPage();
		loginpage.enterUsernameOnUserfield(ExcelUtility.getString(3, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordfield(ExcelUtility.getString(3, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		assertEquals(expectedMessage,actualMessage,"able to login with invalid username and correct password");
	}
	
	@Test
	@Parameters({"username","password"})
	public void verifyThatTheUserWontBeAbletoLoginwithInvalidusernameandIncorrectPasswordWhileClickonSignInButton(String username, String password)
    {
		String expectedMessage="Sign In";
		LoginPage loginpage= new LoginPage(driver);
		String actualMessage=loginpage.toCheckWhetherWeAreStillOnLoginPage();
		loginpage.enterUsernameOnUserfield(username);
		loginpage.enterPasswordOnPasswordfield(password);
		loginpage.clickOnSignInButton();
		assertEquals(expectedMessage,actualMessage,"able to login with invalid username and incorrect password");
	}
}
