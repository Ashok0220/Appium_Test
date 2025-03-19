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


public class eCommerce_tc_3 extends BaseTest{
	
	@Test
	public void filltheform() throws InterruptedException {
		
		
		// verify the total sum of price
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashok");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bulgaria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bulgaria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		// verify the the select product available in the add to cart page
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/productName")), "text", "Cart"));
	
		List<WebElement> productpricelist = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int size = productpricelist.size();
		
		double totalSum = 0;
		
		for (int i=0; i<size; i++) {
			
			String price = productpricelist.get(i).getText();
			 double amount = Double.parseDouble(price.substring(1));
			 
			 totalSum = totalSum + amount;
		}
		
		System.out.println(totalSum);
		
		String Totalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double TotalDisplyamount = getAmountFormated(Totalamount);
		
		System.out.println(TotalDisplyamount);
		
		Assert.assertEquals(totalSum, TotalDisplyamount);
	}

}
