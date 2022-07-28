package appiumdemo1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Demo1 {  
  private AndroidDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for X86");
    //=========================================================== * App Package and App Activity * =========================================================================================================
    desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
    
    //============================================== * App location/path * ======================================================================================
    desiredCapabilities.setCapability("appium:app", "C:\\Users\\Supriya Kole\\Downloads\\ApiDemos-debug.apk");
    
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
  }

  @Test
  public void sampleTest() {
    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Views");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Buttons");
    el4.click();
    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Small");
    el5.click();
  }

  @After
  public void tearDown() throws Throwable { 
	  Thread.sleep(10000);
    driver.quit();
  }
}

	