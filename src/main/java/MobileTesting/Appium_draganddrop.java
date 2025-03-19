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

public class Appium_draganddrop extends BaseTest {

		
		@Test
		public void drag_Drop() throws InterruptedException {
			
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
			WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
			
			// Java
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 630,
			    "endY", 586
			));
			
			
			Thread.sleep(2000);
			
			String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
			
			Assert.assertEquals(text, "Dropped!");
}

	}

