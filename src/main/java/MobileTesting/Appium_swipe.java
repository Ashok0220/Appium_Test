package MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Appium_swipe extends BaseTest {

		
		@Test
		public void swipeGesture() throws InterruptedException {
			
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
			WebElement element = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
			
			Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"), "true");
			
			
			swipeAction(element, "left");
			
			// Java
//			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//					"elementId", ((RemoteWebElement) element).getId(),
////			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "left",
//			    "percent", 0.75
//			));
			
			Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"), "false");
			
			Thread.sleep(2000);
}

	}

