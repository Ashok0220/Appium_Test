package MobileTesting;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Appium_Scrolldown_up extends BaseTest {

		
		@Test
		public void scrollIntoView() throws InterruptedException {
			
			//Where to scroll known  prior
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			//Instead of using appium method we can use another shortcut method using UIAutomator
			
			driver.findElement(AppiumBy.androidUIAutomator
					("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
//			 This scrollable class expect as an argument of UiSelector class.
			
			
			
			// Another methods
//			scroll_to_end_action(); 

			
			Thread.sleep(2000);
			
			// No prior idea
			// Java
			
}

	}

