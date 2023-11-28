package com.testng.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testng.base.BaseTest;
import com.testng.log.Log;
import com.testng.pages.UserMenupage;
import com.testng.pages.LoginPage;

public class LoginTest extends BaseTest {
	WebDriver driver;
	LoginPage loginpage;
	
	
	@BeforeMethod
	public void beforemethod()
	{
		driver = getDriver();
		launchapp(driver);
		 loginpage = new LoginPage(driver);  // Passing the driver to find element
		
	}
	
    @Test(priority=1)
	public void Loginvalid() {
		//Sequence of steps / sequence of actions
		Log.startTestCase("Login");
		loginpage.enterintoUsername("charan@singh.com");
		Log.info("Successfully Entered Username");
		loginpage.enterintoPassword("Qwerty321");
		loginpage.clicklogin();
		Log.info("Successfully Logged");
		Log.endTestCase("Login");
	}
	 
	
	@Test(priority=2)
	public void logininvalid() {
		//Sequence of steps / sequence of actions with the valid input 
		Log.startTestCase("Login Invaid");
		loginpage.enterintoUsername("charan@singh.com");
		loginpage.enterintoPassword(" ");
		loginpage.clicklogin();
		Log.info("Login Failed");
		Log.endTestCase("Login Invalid");
	}
	@Test(priority=3)
	
	public void rememberme() {
		Log.startTestCase("RememberUN");
		loginpage.enterintoUsername("charan@singh.com");
		Log.info("Successfully Entered Username");
		loginpage.enterintoPassword("Qwerty321");
		loginpage.clickRememberme();
		loginpage.clicklogin();
		loginpage.clickUMDD();
		loginpage.clicklogoutbutt();
		Log.info("UN saved");
		Log.endTestCase("RememberUN");
	}
	
	@Test(priority=4)
	public void forgetpassword() {
		Log.startTestCase("passwordreset");
		loginpage.clickforgetpass();
		loginpage.Un();
		loginpage.clickcontinuebutt();
		Log.info("password reset email is sent");
		Log.endTestCase("passswordreset");
	}
	
	@Test(priority=5)
		public void Error() {
			
			Log.startTestCase("WrongCred");
			loginpage.enterintoUsername("charan@singh.com12");
			Log.info("Successfully Entered Username");
			loginpage.enterintoPassword("Qwerty");
			loginpage.clicklogin();
			Log.info("Error message shown");
			Log.endTestCase("WrongCred");
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver,"Salesforce");
		close();
		
	}




	

}
