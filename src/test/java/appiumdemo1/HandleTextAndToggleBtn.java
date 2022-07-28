package appiumdemo1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class HandleTextAndToggleBtn {

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

	 /* public MobileElement getTextViewByContentDesc(String contentDesc) {
		  return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc +"\"]");
		  }
	  
	  
	  public MobileElement getCheckBoxByContentDesc(String contentDesc1)) { 
		  return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc1 +"\"]");
		  
	  }
	  public MobileElement getRadioButtonByContentDesc(String contentDesc2) {
		  return (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@content-desc=\""+ contentDesc2 +"\"]");
	  }
	  public MobileElement editText() {
		  return (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resourse-id='io.appium.android.apis:id/edit']");
	  }
	  public MobileElement offOn(String onOff) {
		  return (MobileElement) driver.findElementByXPath("//android.widget.ToggleButton[@resourse-id='io.appium.android.apis:id/toggle"+onOff+"']");
	  }
	 /*public void SwipeUpLong() {
			(new TouchAction(driver))
			  .press(PointOption.point(490, 1669))
			  .moveTo(PointOption.point(490, 280))
			  .release()
			  .perform();

		}
		public void SwipeUpSmall() {
			TouchAction perform = (new TouchAction(driver))
			  .press(PointOption.point(490, 1690))
			  .moveTo(PointOption.point(490, 500))
			  .release()
			  .perform();
		}
	  */
	  @Test
	  public void SampleTest()throws InterruptedException {
		  
	MobileElement el1 =  (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']"));
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']"));
		el2.click();
		  
		MobileElement el3 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Light Theme']"));
		el3.click();
		  //control +2,L
		  driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("supriya");
		  driver.hideKeyboard();
		  
	  for (int count = 0; count<40;count++) {
		  Thread.sleep(1000);
	  }
	  
	  }
	
	 @Test
	public void testToggleButton() throws InterruptedException {
		 MobileElement el1 =  (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']"));
			el1.click();
			MobileElement el2 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']"));
			el2.click();
			  
			MobileElement el3 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Light Theme']"));
			el3.click();
	  MobileElement ToggleButton = (MobileElement) driver.findElement(By.className("android.widget.ToggleButton"));
	  System.out.println(ToggleButton.getAttribute("text"));
	  ToggleButton.click();
	  System.out.println(ToggleButton.getAttribute("text"));
	}
 
	  /*@Test
	  public void sampleTest() throws throwable {
	  getTextViewByContentDesc("Views").click();
	  SwipeUpLong();
	  SwipeUpLong();
	  getTextViewByContentDesc1("Seek Bar").click();*/	  
	 
	@After
	public void tearDown()throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	}
	
	


