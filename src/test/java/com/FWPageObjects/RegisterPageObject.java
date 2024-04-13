package com.FWPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject {

	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"caret\"]")
	WebElement myAccount;
	
	@FindBy(linkText="Register")
	WebElement register;
	
	
	@FindBy(name="firstname")
	WebElement firstnamefield;
	
	@FindBy(id="input-email")
	WebElement emailfield;
	
	@FindBy(name="telephone")
	WebElement telephfield;
	
	@FindBy(name="lastname")
	WebElement lastnamefield;
	
	@FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(name="confirm")
	WebElement confirmPassfield;
	
	@FindBy(name="newsletter")
	WebElement yesSouscrib;
	
	@FindBy(name="agree")
	WebElement policyBox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	WebElement firstwarn;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	WebElement lastwarn;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	WebElement emailwarn;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	WebElement telwarn;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	WebElement passwarn;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement continueBox;
	
	public void enterFistname(String fstnam) {
		firstnamefield.sendKeys(fstnam);
		
	}
	
	public void enterLast(String lstnam) {
		lastnamefield.sendKeys(lstnam);
	}
	
	public void enterEmail(String email) {
		emailfield.sendKeys(email);
	}
	
	public void enterTeleph(String teleph) {
		telephfield.sendKeys(teleph);
	}
	
	public void enterPassword(String passw) {
		passwordfield.sendKeys(passw);
	}
	
	public void confirmPassw(String confPass) {
		confirmPassfield.sendKeys(confPass);
	}
	public void yesNewpaper() {
		yesSouscrib.click();
	}
	
	public void policyBox() {
		policyBox.click();
	}
	
	public void continueBox() {
		continueBox.click();
	}
	public void myAccountClick() {
		
		myAccount.click();
	}
	public void register() {
		register.click();
	}
	public String warningMessage() {
		String warn=warning.getText();
		return warn;
	}
	public String fistwarningMessage() {
		String warn0=firstwarn.getText();
		return warn0;
	}
	public String lastwarningMessage() {
		String warn1=lastwarn.getText();
		return warn1;
	}
	public String emailwarningMessage() {
		String warn2=emailwarn.getText();
		return warn2;
	}
	public String telewarningMessage() {
		String warn3=telwarn.getText();
		return warn3;
	}
	public String passwarningMessage() {
		String warn4=passwarn.getText();
		return warn4;
	}
}
