package MobileTesting;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Miscellaneous_Topic extends BaseTest{
	
	
	@Test
	public void some_functions()  throws MalformedURLException, URISyntaxException, InterruptedException {
		

		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// DeviceRotation is a class
		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
		driver.rotate(rotation);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String text = driver.findElement(By.className("android.widget.TextView")).getText();
		
		assertEquals(text, "WiFi settings");
		
		//copy to clipboard
		driver.setClipboardText("Ashok wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
//		driver.findElement(By.id("android:id/edit")).sendKeys("Ashok wifi");
		driver.findElement(By.id("android:id/button1")).click();
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		
		
	}
	

}
