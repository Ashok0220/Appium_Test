package com.ecommerce;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MobileTesting.BaseTest;
import io.appium.java_client.AppiumBy;


public class eCommerce_tc_2 extends BaseTest{
	
	@Test
	public void filltheform() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashok");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bulgaria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bulgaria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		// Scroll in product list and addtocart 
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		
		int productlist = driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();
		
		for (int i=0; i<productlist; i++) {
			
			String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if (productname.equalsIgnoreCase("Air Jordan 9 Retro")) {
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
					
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		// verify the the select product available in the add to cart page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/productName")), "text", "Cart"));
	
		String text = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(text, "Air Jordan 9 Retro");
	}

}
