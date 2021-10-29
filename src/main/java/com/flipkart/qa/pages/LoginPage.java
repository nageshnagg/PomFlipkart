package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {

	// pagefacotory and object repository(or)
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement login;

	@FindBy(xpath = "//button[contains(text(),'Request OTP')]")
	WebElement RequestOTPbtn;

	@FindBy(linkText = "New to Flipkart? Create an account")
	WebElement sinupbtn;

	// intilization of page page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	// actions
	
	public boolean Requestvalidation() {
		return RequestOTPbtn.isDisplayed();
	}

	public boolean signupvalidation() {
		return sinupbtn.isDisplayed();
	}

	public HomePage loginvalidation(String unn, String pass) {
		username.sendKeys(unn);
		password.sendKeys(pass);
		login.click();
		return new HomePage();

	}
	

}
