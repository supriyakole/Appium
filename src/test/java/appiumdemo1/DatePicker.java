package appiumdemo1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class DatePicker {

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
	     
	        
	        	// Scrollup  
	 	        //PRINT THE VALES -> TOP LEFT
	 	   
	        	MobileElement MEListYEAR = (MobileElement) driver.findElement(By.id("android:id/date_picker_year_picker"));
	        	 int X = MEListYEAR.getLocation() .getX();
	        	 int Y = MEListYEAR .getLocation().getY();
	        	 // PRINT H & W (H=HEIGHT,W=WIDTH)
	        	 int H = MEListYEAR.getSize().getHeight();
	        	 int W = MEListYEAR.getSize().getWidth();
	        	 int startX = (int) (X+(W*0.5));            //50% of width = startpointX
	        	 int startY = (int) (X+(H*0.9));            // 90% of Height = startpointY  becoz 10% is whitespace of screenpointer so not considering 100%
	        	 int endX = startX;
	        	 int endY = (int) (Y+(H*0.1));               //10% only considering of Height 
	        	 TouchAction action = new TouchAction(driver);
	        	 action 
	        	 .longPress(PointOption.point(startX,startY))
	        	 .moveTo(PointOption.point(endX,endY))
	        	 .release()
	        	 .perform();
	        	 
	        	 
	        	 Thread.sleep(6000);
	        	 
	          if (reqYear > crYear)
		        	// Scrollup  
		 	        //PRINT THE VALES -> TOP LEFT
		 	  	{
	        	 Boolean flagFound = false;
	        	 while(!flagFound) {
	        		 List<MobileElement> allYears = driver.findElements(By.xpath("//android.widget.TextView"));
	        		 for (MobileElement year : allYears) {
	        			 System.out.println(year.getAttribute("text"));
	        		 }
	        		 
	        		List<MobileElement> firstReqYear = driver.findElements(By.xpath("//android.widget.TextView[@text='2028']"));
	        		if(firstReqYear.size()>0) {
	        			flagFound = true;
	        			break;
	        			
	        		}
	        		             
	        testScroll();
	        	 }
	        		
	        	 driver.findElement(By.xpath("//android.widget.TextView[@text='2028']"));
	        	 Thread.sleep(5000);
	        	 
	        	 }
	  }
	        	 
	       
	  private void ScrollUpYear() {
		// TODO Auto-generated method stub
		
	}

	@Test
	  public void tearDown() throws Throwable {
		  Thread.sleep(1000);
		  driver.quit();
	  }
	  } 
	  
	        
	  

