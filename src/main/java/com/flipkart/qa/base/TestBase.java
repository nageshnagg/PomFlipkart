package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.utiles.Testutils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		try {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void intialization() {
		String bname = prop.getProperty("browser");
		if (bname.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D://venkatesh//chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (bname.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "D://venkatesh//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutils.PAGE_L0AD_TIMEOUT, TimeUnit.SECONDS);//supose if u r application is slow incase u have to change any timeout it will take some time thats why u have to mention separate class that wiil be helpfull for u
		driver.manage().timeouts().implicitlyWait(Testutils.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
