package com.FWTestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.FWPageObjects.SearchPageObject;

public class SearchTest extends Base {

	
	SearchPageObject sp;
	
	
	@Test(priority=1)
	public void searchValidProduct() {
		sp=new SearchPageObject(driver);
		sp.searchBox("hp");
		sp.searchIcon();
		Assert.assertTrue(sp.productDisplay().contains("HP LP3065"));
	}
	@Test(priority=2)
	public void searchInValidProduct() {
		sp=new SearchPageObject(driver);
		sp.searchBox("biere");
		sp.searchIcon();
		Assert.assertTrue(sp.invalidProductWarnMessage().contains("There is no product that matches the search criteria."));
	}
	@Test(priority=3)
	public void searchwithoutPrividinganyName() {
		sp=new SearchPageObject(driver);
		sp.searchIcon();
		Assert.assertTrue(sp.invalidProductWarnMessage().contains("There is no product that matches the search criteria."));
	}
}
