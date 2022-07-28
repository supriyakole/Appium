package appiumdemo1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MessagingApp {
	 private AndroidDriver driver;
	 @Before 
	  public void setUp() throws MalformedURLException, InterruptedException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for X86");
	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.apps.messaging");
	    desiredCapabilities.setCapability("appium:appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    System.out.println(driver.getSessionId());
	   
	  }
	 
@Test
public void testMsg () throws InterruptedException {
MobileElement el1 =  (MobileElement) driver.findElement(By.id ("com.google.android.apps.messaging:id/start_new_conversation_button"));
el1.click(); 
 
Thread.sleep(3000);
//send Message to EMULATOR-5554
 MobileElement el2 = (MobileElement) driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view"));
 el2.sendKeys("5554");
 
 //Press ENTER for click Action-by key
((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
 
 MobileElement el4 = (MobileElement) driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text"));
 el4.sendKeys("hi...WELCOME");
 
 //press send BUtton 
 MobileElement el5 = (MobileElement) driver.findElement(By.id("com.google.android.apps.messaging:id/send_message_button_icon"));
 el5.click();
 
}
@After
public void tearDown() throws Throwable {
Thread.sleep(5000);
driver.quit();
}
}







