package com.FWTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FWPageObjects.LoginPageObject;

import com.FWUtilities.Utilities;


public class LoginTest extends Base{

	 LoginPageObject pg;

	
	
	@Test(priority = 1)
	public void verifyLoginwithValidCredentials() {
		
	
		pg=new LoginPageObject(driver);
		pg.myAccountClick();
	
		pg.loginButtonClick();
	
		pg.setUserName(config.getValidUsernam());
	
		pg.setPassWold(config.getValidPassworld());
	
		pg.buttonClick();
		
		Assert.assertEquals(pg.Displayed(), "Edit your account information");
		
	}
	@Test(priority = 2)
	public void verifyLoginwithInValidEmailAndValidPassword() {
		
		
		pg=new LoginPageObject(driver);
		pg.myAccountClick();
		log.info("account clicked");
		pg.loginButtonClick();
		log.info("login clicked");
		pg.setUserName(Utilities.generateRandomEmail());
		log.info("Random username set");
		pg.setPassWold(config.getValidPassworld());
		log.info("Valid password set");
		pg.buttonClick();
		log.info("final login clicked");
		Assert.assertEquals(pg.getAlert(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test(priority = 3)
	public void verifyLoginwithInValidCredentials() {
		
		
		pg=new LoginPageObject(driver);
		pg.myAccountClick();
		log.info("account clicked");
		pg.loginButtonClick();
		log.info("login clicked");
		pg.setUserName(Utilities.generateRandomEmail());
		log.info("Random username set");
		pg.setPassWold("Kwango3");
		log.info("InValid password set");
		pg.buttonClick();
		log.info("final login clicked");
		Assert.assertEquals(pg.getAlert(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test(priority = 4)
	public void verifyLoginwithValidEmailAndInValidPassword() {
		
		
		pg=new LoginPageObject(driver);
		pg.myAccountClick();
		log.info("account clicked");
		pg.loginButtonClick();
		log.info("login clicked");
		pg.setUserName(Utilities.generateRandomEmail());
		log.info("Random username set");
		pg.setPassWold("Kwango1@");
		log.info("InValid password set");
		pg.buttonClick();
		log.info("final login clicked");
		Assert.assertEquals(pg.getAlert(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test(priority = 5)
	public void verifyLoginwithoutProvidingCredentials() {
		
		
		pg=new LoginPageObject(driver);
		pg.myAccountClick();
		log.info("account clicked");
		pg.loginButtonClick();
		log.info("login clicked");
		pg.buttonClick();
		log.info("final login clicked");
		Assert.assertEquals(pg.getAlert(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
}
