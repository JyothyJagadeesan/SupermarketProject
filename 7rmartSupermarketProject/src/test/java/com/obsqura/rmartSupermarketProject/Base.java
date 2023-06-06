package com.obsqura.rmartSupermarketProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base 
{
    public WebDriver driver;
    public void initializeBrowser()
    {
        driver =new ChromeDriver();
        //driver =new FirefoxDriver();
        //driver =new EdgeDriver();
        driver.get("https://groceryapp.uniqassosiates.com/admin");
        driver.manage().window().maximize();
    }
    public void driverClose()
    {
        driver.close();
    }
    public void driverQuit()
    {
        driver.quit();
    }

    public static void main(String args[])
    {
        Base base=new Base();
        base.initializeBrowser();
        
        base.driverQuit();
    }
}
