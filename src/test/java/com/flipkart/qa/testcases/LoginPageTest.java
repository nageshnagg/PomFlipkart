package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage LoginPage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		LoginPage =new LoginPage();
	}
	
	@Test(priority=1)
	public void RequestvalidationTest() {
		boolean y=LoginPage.Requestvalidation();
		Assert.assertTrue(y);
	}
	@Test(priority=2)
	public void signupvalidationTest() {
	boolean z=LoginPage.signupvalidation();
	Assert.assertTrue(z);
	}
	@Test(priority=3)
	public void LoginvalidationTest() throws InterruptedException {
		Thread.sleep(2000);
		homepage=LoginPage.loginvalidation(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
