package com.obsqura.rmartSupermarketProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base
{

	public void loginPage()
	{
		WebElement userName= driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin");
		WebElement signIn=driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn.click();
	}
	public static void main(String[] args) 
	{
		LoginPage loginpage=new LoginPage();
		loginpage.initializeBrowser();
		loginpage.loginPage();
       // loginpage.driverQuit();
	}

}
