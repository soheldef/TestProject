package com.adfenix.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adfenix.utils.helper;

public class LoginPage extends helper {
	
	@Test
	public void testone(){
	    //wait for the element
		WebDriverWait wait=new WebDriverWait(driver, 60);
	    WebElement LogoutButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sign-out")));
		//verify if the element is present
		String text = LogoutButton.getText();
		Assert.assertTrue(text.equalsIgnoreCase("LOGGA UT"));
	}
	
	@Test
	public void testtwo(){
		
		WebElement element = driver.findElement(By.cssSelector("span.sign-out"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-flat.btn")));

		String text = driver.findElement(By.cssSelector(".btn.btn-flat.btn-primary")).getText();
		Assert.assertTrue(text.equalsIgnoreCase("GET ACCESS?"));		
	}
	@Test
	public void testthree() throws InterruptedException{

		WebElement element = driver.findElement(By.cssSelector(".btn.btn-flat.btn"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-flat.btn-primary")));
        //verify if current url is the expected url
		String url = "http://order.adfenix.com/#/generate-password";
		String text1 = driver.getCurrentUrl();
		Assert.assertTrue(text1.equalsIgnoreCase(url));	
	}

}
