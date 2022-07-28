package appiumdemo1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class DragAndDrop {
	
	
	 private AndroidDriver driver;
	 TouchAction touchaction ;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for X86");
	    desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
	    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    System.out.println(driver.getSessionId());
	  }
	  
	  
	  @Test
	  public void testDragAndDrop()throws InterruptedException {
		  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();
		  
		  MobileElement SRC = (MobileElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	        MobileElement TGT = (MobileElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
	        
	        TouchAction action =  new TouchAction (driver);
	        Point pntSRC = SRC.getCenter();
	        Point pntTGT = TGT. getCenter();
	      
	        action 
	        .longPress(PointOption.point(pntSRC))
	        .moveTo(PointOption.point(pntTGT))
	        .release()
	        .perform();
	        
	  }

	  /*@Test
	  public void testScroll() throws InterruptedException {
	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
//	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
	        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Dialog']")).click();
//	        
//	        io.appium.android.apis:id/pickDate
	        driver.findElement(By.id("io.appium.android.apis:id/pickDate")).click();
	        driver.findElement(By.id("android:id/date_picker_header_year")).click();
	        MobileElement MEYear = (MobileElement) driver.findElement(By.id("android:id/date_picker_header_year"));
	        String strCrYear = MEYear.getAttribute("text");
	        int crYear = Integer.parseInt(strCrYear);
	        String strReqYear = "2028";
	        int reqYear = Integer.parseInt(strReqYear);
	        
	        if (reqYear > crYear) {
	        	
	        }
//	            Scroll Up
//	            PRINT THE VALES -> TOP LEFT
	  
	  
	  
	  
	        }
	  */

@After
public void tearDown() throws Throwable {
	Thread.sleep(1000);
driver.quit();
}
}
