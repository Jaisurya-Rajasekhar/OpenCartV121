package testCases;



import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regression","Master"})
	public void verify_accreg() {
		try {
		logger.info("****Starting TC001_AccountRegistrationTest****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		logger.info("Providing customer details....");
		ar.setFirstName(randomeString().toUpperCase());
		ar.setLastName(randomeString().toUpperCase());
		ar.setEmail(randomeString()+"@gmail.com");
		ar.setMobileNumber(randomeInt());
		String pass=randomeAlphaNumeric();
		ar.setPassword(pass);
		ar.setRepass(pass);
	
		ar.clickPolicy();
		ar.clickCtn();
		logger.info("Validation expected message...");
		String confmsg=ar.getConfirmmsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed...");
			logger.debug("Debug Logs...");
			Assert.assertTrue(false);
			
		}
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	
	}
	catch(Exception e) {
		
		Assert.fail();
	}
		logger.info("****Finished TC001_AccountRegistrationTest****");
		

	}
	
	
	



}
