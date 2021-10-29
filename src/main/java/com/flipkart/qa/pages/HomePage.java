package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'My Account')")
	WebElement myaccount;
	@FindBy(xpath = "//Img[@alt='Mobiles']")
	WebElement mobile;
	@FindBy(xpath = "	//Img[@alt='Fashion']")
	WebElement fashion;
	@FindBy(xpath = "//Img[@class='_396cs4 _3exPp9']")
	WebElement eletronics;
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle() {
		return driver.getTitle();
	}
	public void myAccountCheck() {
		myaccount.click();
	}
	public boolean mobileDisplaying() {
		return mobile.isDisplayed();
	}
	public void fashionClick() {
		fashion.click();
	}
	public boolean eletronicsCheck() {
		return eletronics.isDisplayed();
	}
 
}

	
	
	
	
	
	
	
	
	

