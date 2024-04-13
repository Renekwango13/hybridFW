
package com.FWTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.FWPageObjects.RegisterPageObject;
import com.FWUtilities.Utilities;

public class RegisterTest extends Base{

	RegisterPageObject pr;

	
	@Test(priority=1)
	public void registerWithPersonalDetails() {
		
		 pr= new RegisterPageObject(driver);
		 pr.myAccountClick();
		 pr.register();
		 pr.enterFistname("biby");
		 pr.enterLast("nzuzi");
		 pr.enterEmail(Utilities.generateRandomEmail());
		 pr.enterTeleph("2173055249");
		 pr.enterPassword(config.getValidPassworld());
		 pr.confirmPassw(config.getValidPassworld());
		 pr.policyBox();
		 pr.continueBox();
		 log.info("register completed");
		
	}
	@Test(priority=2)
	public void registerFillingAllDetails() {
		
		 pr= new RegisterPageObject(driver);
		 pr.myAccountClick();
		 pr.register();
		 pr.enterFistname("biby");
		 pr.enterLast("nzuzi");
		 pr.enterEmail(Utilities.generateRandomEmail());
		 pr.enterTeleph("2173055249");
		 pr.enterPassword(config.getValidPassworld());
		 pr.confirmPassw(config.getValidPassworld());
		 pr.yesNewpaper();
		 pr.policyBox();
		 pr.continueBox();
		 log.info("register all details completed");
		
	}
	@Test(priority=3)
	public void registerWithExistingCredentials() {
		
		 pr= new RegisterPageObject(driver);
		 pr.myAccountClick();
		 pr.register();
		 pr.enterFistname("biby");
		 pr.enterLast("nzuzi");
		 pr.enterEmail(config.getValidUsernam());
		 pr.enterTeleph("2173055249");
		 pr.enterPassword(config.getValidPassworld());
		 pr.confirmPassw(config.getValidPassworld());
		 pr.policyBox();
		 pr.continueBox();
		 Assert.assertTrue(pr.warningMessage().contains("Warning: E-Mail Address is already registered!"), "not mutch");
		 log.info("register with valid credentials completed");
		
	}
	@Test(priority=4)
	public void registerWithoutProvidingCredentials(){
		
		 pr= new RegisterPageObject(driver);
		 pr.myAccountClick();
		 pr.register();
		 pr.continueBox();
		 Assert.assertEquals(pr.fistwarningMessage(),"First Name must be between 1 and 32 characters!");
		 Assert.assertEquals(pr.lastwarningMessage(),"Last Name must be between 1 and 32 characters!");
		 Assert.assertEquals(pr.emailwarningMessage(),"E-Mail Address does not appear to be valid!");
		 Assert.assertEquals(pr.telewarningMessage(),"Telephone must be between 3 and 32 characters!");
		 Assert.assertEquals(pr.passwarningMessage(),"Password must be between 4 and 20 characters!");
		
		 log.info("register without providing credentials completed");
		
	}
}
