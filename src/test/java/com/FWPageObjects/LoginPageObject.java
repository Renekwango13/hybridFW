package com.FWPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject {

	WebDriver driver;
	public LoginPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	
	
	@FindBy(xpath="//span[@class=\"caret\"]")
	WebElement myAccount;
	
	@FindBy(id="input-email")
	WebElement usernamField;
	
	@FindBy(id="input-password")
	WebElement PassWordField;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement button;
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	WebElement Display;

	
	@FindBy(linkText="Login")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement alert1;
	
	public String getAlert()
	{
		String alert=alert1.getText();
		return alert;
	}
	
	public void myAccountClick() {
		
		myAccount.click();
	}
	public void loginButtonClick() {
			
		LoginButton.click();
	}
	
	public void setUserName(String username) {
		
		usernamField.sendKeys(username);
	}
	
	public void setPassWold(String PassWord) {
		
		PassWordField.sendKeys(PassWord);
	}
	
	public void buttonClick() {
		
		button.click();
	}
	public String Displayed() {
		
		String disp=Display.getText();
		return disp;
	}	
}
