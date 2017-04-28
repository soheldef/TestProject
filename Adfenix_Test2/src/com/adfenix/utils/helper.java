package com.adfenix.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class helper {
	
public WebDriver driver = null;
	
	@BeforeClass
	public void initializeDriver(){	
        System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\eclipse\\ChromeDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://order.adfenix.com/#/lansfast/?id=4ask4hk5ab2jksv6&token=kocLK8xBrk6PHJU9hUBD8Q");
	}
	
	@AfterClass
	public void destroyDriver(){
		driver.quit();
	}
	}

