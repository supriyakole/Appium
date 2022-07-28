package appiumdemo1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RadioButton {

  private AndroidDriver driver;

  @Before
public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for X86");

 //===============================*to get App Package & App Activity*=================================
    desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
    
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  public MobileElement getTextViewByContentDesc(String contentDesc) { 
	  return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']");
	  }
 
  public void SwipeUpLong() {
        (new TouchAction(driver))
      .press(PointOption.point(720, 1914))
      .moveTo(PointOption.point(707,701))
      .release()
      .perform();
  }
  
  public void SwipeUpSmall() {
    (new TouchAction(driver))
      .press(PointOption.point(644, 1920))
      .moveTo(PointOption.point(695, 284))
      .release()
      .perform();
    
  }
  
 public void RadioButtons() {
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Radio Group");
    el2.click(); 
  
    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Breakfast");
    el3.click();
    String isChecked = el3.getAttribute("checked");
    System.out.println(" Breakfast is checked by default? =" +isChecked);

    
    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("All of them");
    el4.click();
    String isChecked1 = el4.getAttribute("checked");
    System.out.println("All of them is checked by default? =" +isChecked1);

 } 

 @Test
 public void Sampletest()throws InterruptedException {
	 getTextViewByContentDesc("Views").click();
	 SwipeUpLong();
	 SwipeUpSmall();
	 RadioButtons();
 }
	 
@After
public void tearDown() throws InterruptedException {
	  Thread.sleep(1000);
    driver.quit();
  }
}


		
	  