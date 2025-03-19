package MobileTesting;

import java.io.File;
import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	 AppiumDriverLocalService service;
	
	@BeforeClass
	public void drivers() throws MalformedURLException, URISyntaxException {
		
		//AndroidDriver, IOS driver
		
				//Appiumcode ==> Appium Server ==> UI automation
				 service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ashok\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Pixel 3a");
//				options.setApp("C:\\Users\\ashok\\OneDrive\\Desktop\\ApiDemos-debug.apk");
				options.setApp("C:\\Users\\ashok\\OneDrive\\Desktop\\General-Store.apk");
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
		service.stop();
	}
	
	public void longpressmethod(WebElement peoplename) throws InterruptedException {
		// Java
				((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
						ImmutableMap.of("elementId",((RemoteWebElement) peoplename).getId(), "duration", 2000));
				Thread.sleep(2000);
	}
	
	
	public void scroll_to_end_action() {
		boolean canScrollMore;
		do 
		{ 
		canScrollMore =(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		} while (canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
//		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", direction,
		    "percent", 0.75
		));
		
	}
	
	public double getAmountFormated(String amonut) {
		
		double amounts = Double.parseDouble(amonut.substring(1));
		
		return amounts;
	}
	
}
