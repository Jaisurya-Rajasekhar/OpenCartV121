package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid- login success-test pass-logout
 * Data is valid -- login failed- test fail
 * 
 * Data is invalid-- login success--test fail--logout
 * Data is invalid -- login failed--test pass--logout
 
 * */

public class TC003_LoginDDT extends BaseClass {
	
	
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
		public void verify_loginDDT(String email,String password,String expected) {
			try {
			logger.info("*****Starting TC003_LoginDDT*****");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login Page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage ap=new MyAccountPage(driver);
			boolean targetpage=ap.isMyAccPageExist();
			
			if(expected.equalsIgnoreCase("valid")) {
				if(targetpage==true) {
					ap.clickLogout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
					
				}
			}
			if(expected.equalsIgnoreCase("Invalid")) {
				if(targetpage==true) {
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);	
				}
			}
			
			}
			catch(Exception e) {
				Assert.fail();
			}
			logger.info("*****End of TC003_LoginDDT*****");
			
		}
 
}
