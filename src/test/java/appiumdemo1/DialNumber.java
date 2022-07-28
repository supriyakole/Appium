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

public class DialNumber {
	private AndroidDriver driver;
	 @Before 
	  public void setUp() throws MalformedURLException, InterruptedException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for X86");
	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.dialer");
	    desiredCapabilities.setCapability("appium:appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
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
	   public void DialNumberTest() {
		   
	MobileElement el1 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/floating_action_button"));
	el1.click();
	
	MobileElement el2 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/nine"));
	el2.click();
	
	MobileElement el3 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/six"));
	el3.click();
	
	MobileElement e14 =  (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/zero"));
	e14.click();	  
	 
	MobileElement el5 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/seven"));
	el5.click();
	
	MobileElement el6 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/one"));
	el6.click();
	
	MobileElement el7 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/one"));
	el7.click();
	
	MobileElement el8 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/one"));
	el8.click();
	
	MobileElement el9 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/zero"));
	el9.click();
	
	MobileElement el10 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/eight"));
	el10.click();
	
	MobileElement el11 = (MobileElement) driver.findElement(By.id("com.google.android.dialer:id/six"));
	el11.click();
	
	driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button")).click();
	
	try {
		Thread.sleep(60000);
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("com.google.android.dialer:id/incall_end_call")).click();	//To end call after 60 sec
	}
	
	
	@After
	public void tearDown(){
	
	driver.quit();
	}
	}
	 
	 
	

