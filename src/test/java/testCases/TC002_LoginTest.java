	package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("****TC002_LoginTest started....*****");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetpage=ap.isMyAccPageExist();
		
//		Assert.assertEquals(targetpage, true,"Login failed");
		Assert.assertTrue(targetpage);
		
		logger.info("****TC002_LoginTest Ended....*****");
		}catch(Exception e) {
			Assert.fail();
		}
	}
}
