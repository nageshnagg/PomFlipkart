package com.flipkart.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class HomepageTest extends TestBase{
	LoginPage LoginPage;
	HomePage homepage;
	public HomepageTest() {
		super();
	}
     //----for every test case browser willbe lanch login into application,exeution,close/this is best partice
	// if u r not closing the browser and the same browser execting 100 test cases,your browser will be exhusted and blank page coming;
	
	
	//test cases should be separated -----independent with each other
	//before each testcase ------------lanch the browser and login
	//after each test case ----------------close browser
	@BeforeMethod
	public void setup() {
		intialization();
		LoginPage =new LoginPage();
		homepage=LoginPage.loginvalidation(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void flipkarttitletest() {
		String flipkarttitle=homepage.gettitle();
		Assert.assertEquals(flipkarttitle, "flipkart plus","home page title not matched");
	}
	@Test(priority=2)
	public void myaccountchecktest() {
		homepage.myAccountCheck();
	}
	@Test(priority=3)
	public void mobiledisplayingtest() {
	boolean d=	homepage.mobileDisplaying();
	System.out.println(d);
	}
	@Test
	public void fashionoptionclicktest() {
		homepage.fashionClick();
	}@Test
	public void electronicschecktest() {
		boolean b=homepage.eletronicsCheck();
		System.out.println(b);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
