package MobileTesting;

import java.io.File;
import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void drivers() throws MalformedURLException, URISyntaxException {
		
		//AndroidDriver, IOS driver
		
				//Appiumcode ==> Appium Server ==> UI automation
				 service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ashok\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Pixel 7 Pro");
				options.setApp("C:\\Users\\ashok\\OneDrive\\Desktop\\ApiDemos-debug.apk");
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
//				driver.manage().timeouts().implicitlyWait()  withSeconds(10);
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
		service.stop();
	}
	
	
}
