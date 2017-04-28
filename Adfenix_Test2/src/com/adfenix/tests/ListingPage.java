package com.adfenix.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adfenix.utils.helper;

public class ListingPage extends helper{
	
	@Test
	public void clicklisting(){
		//going to listing page by clicking Mina Listningar
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("i.zmdi.zmdi-view-list")));
	}
	
	@Test
	public void SearchPage(){
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='propertyad']/div[1]/div/div[2]/span/button")));
        //verify search page
		String text = driver.findElement(By.xpath(".//*[@id='propertyad']/div[1]/div/div[2]/span/button")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Search"));		
	}
	
	@Test
	public void search(){
	
		WebElement searchbox = driver.findElement(By.cssSelector("div.col-xs-8>.form-control"));
		searchbox.click();
		searchbox.sendKeys("tele");
	
		WebElement searchbutton = driver.findElement(By.xpath(".//*[@id='propertyad']/div[1]/div/div[2]/span/button"));
		searchbutton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='propertyad']/div[2]/div[2]/div")));
		String text = driver.findElement(By.xpath(".//*[@id='propertyad']/div[2]/div[2]/div")).getText();
		System.out.println(text);
		//verify if appropriate message shows
		Assert.assertTrue(text.equalsIgnoreCase("No Result Found"));		
	}
}
