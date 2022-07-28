package appiumdemo1;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Seekbar {
private AndroidDriver driver;
TouchAction touchAction;
@Before
public void setUp() throws MalformedURLException, InterruptedException {
DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
desiredCapabilities.setCapability("platformName", "Android");
desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
// either install app or use appActivity.appPackage
desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
// desiredCapabilities.setCapability("appium:app", "C:\\Users\\Supriya Kole\\Downloads\\ApiDemos.apk");
desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

URL remoteUrl = new URL("http://localhost:4723/wd/hub");
driver = new AndroidDriver(remoteUrl, desiredCapabilities);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
touchAction = new TouchAction(driver);
Thread.sleep(1000);
}

public MobileElement getTextViewByContentDesc(String contentDesc) { 
return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']");
}

public void SwipeUpLong() { 

	(new TouchAction(driver))
	  .press(PointOption.point(733, 1901))
	  .moveTo(PointOption.point(755, 281))
	  .release()
	  .perform();

}
public void SwipeUpSmall() {
	(new TouchAction(driver))
	  .press(PointOption.point(714, 1939))
	  .moveTo(PointOption.point(717, 707))
	  .release()
	  .perform();
	  
}
public void Move() throws InterruptedException {
	  Thread.sleep(2000);
	  MobileElement seekBar = (MobileElement) driver.findElementByAccessibilityId("Seek Bar");
	  seekBar.click();

		  MobileElement Seekbar = (MobileElement) driver.findElementById("io.appium.android.apis:id/seek");
		  Seekbar.click();
		  
		 Thread.sleep(1000); 
		int startXPos = Seekbar.getLocation().getX();
		int startYPos = Seekbar.getLocation().getY();
		int lastXPos = startXPos + Seekbar.getSize().getWidth();
		int centerXPos = (Seekbar).getCenter().getX();
		System.out.println("startXPos= "+startXPos);
		System.out.println("startYPos= "+startYPos);
		System.out.println("lastXPos= "+lastXPos);
		System.out.println("centerXPos= "+centerXPos);
		
		//move to start position =0
				touchAction.press(ElementOption.element(Seekbar))
				.moveTo(PointOption.point(startXPos,startYPos))
				.release()
				.perform();

				Thread.sleep(1000);

				//move to last position
				touchAction.press(ElementOption.element(Seekbar))
				.moveTo(PointOption.point(lastXPos,startYPos))
				.release()
				.perform();

				// wnat to move to to 30th postion
				int delta= 40;
				int point30 = 30* (startXPos+ Seekbar.getSize().getWidth() / 100)+delta;

				touchAction.press(ElementOption.element(Seekbar))
				.moveTo(PointOption.point(point30,startYPos))
				.release()
				.perform();

				int point70 = 70* (startXPos+ Seekbar.getSize().getWidth() / 100)+delta;

				touchAction.press(ElementOption.element(Seekbar))
				.moveTo(PointOption.point(point70,startYPos))
				.release()
				.perform();

	}
@Test	
public void SampleTest() throws InterruptedException {
	
getTextViewByContentDesc("Views").click();
SwipeUpLong();
SwipeUpLong();
SwipeUpSmall();
Move();
}
@After
public void tearDown( ) throws Throwable {

Thread.sleep(2000);
driver.quit();
}
}


