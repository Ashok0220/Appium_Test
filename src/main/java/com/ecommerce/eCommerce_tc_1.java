package com.ecommerce;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MobileTesting.BaseTest;
import io.appium.java_client.AppiumBy;


public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void filltheform() throws InterruptedException {
		
		Thread.sleep(5000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashok");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bulgaria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bulgaria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		//Toast error message validate 
		
		String toastmessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
		Assert.assertEquals(toastmessage, "Please enter your name");
//		
		
	}

}
