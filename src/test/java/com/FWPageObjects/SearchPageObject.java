package com.FWPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObject{
	
	WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(name="search")
	WebElement search;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement searchIcon;
	
	@FindBy(linkText="HP LP3065")
	WebElement product;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	WebElement invalidProductWarn;
	
	public void searchBox(String name) {
		search.sendKeys(name);	
	}
	public void searchIcon() {
		searchIcon.click();	
	}
	public String productDisplay() {
		String productName=product.getText();	
		return productName;
	}
	public String invalidProductWarnMessage() {
		String message=invalidProductWarn.getText();
		return message;
	}
}
