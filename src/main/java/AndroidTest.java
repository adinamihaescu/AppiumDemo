import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by amihaescu on 3/1/2016.
 */
public class AndroidTest {

    AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        driver = getLocalAndroid();
    }

    public AndroidDriver getLocalAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //required for native and hybrid testing
        capabilities.setCapability("deviceName", "Android");
        //specify apk path to install the application, if not specify uses the already installed app if any
        capabilities.setCapability("app", "D:\\EndavaTime\\PracticeMeetup\\AndroidPracticeMeetup\\app\\build\\outputs\\apk\\app-debug.apk");
        //application package
        capabilities.setCapability("appPackage", "com.endava.practicemeetup");
        //main Activity - used to start the application
        capabilities.setCapability("appActivity", ".activity.NavigationActivity");
        //udid of the device
        capabilities.setCapability("udid", "08b001d200740ce0");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        return driver;
    }

    @Test
    public void appiumExampleTest() throws Exception {
        List<WebElement> meetupList = driver.findElements(By.id("cv_meetup_item"));
        meetupList.get(0).click();
        //use xPath
       // Assert.assertEquals("Animation", el.getText());
        /*el = driver.findElementByClassName("android.widget.TextView");
        Assert.assertEquals("API Demos", el.getText());
        el = driver.findElement(By.name("App"));
        el.click();
        List<WebElement> els = driver.findElementsByClassName("android.widget.TextView");
        assertEquals("Activity", els.get(2).getText());*/

        driver.quit();
    }

    public void performTouchAction() {
        TouchAction action = new TouchAction(driver);
        action.press(208, 361).release().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

}
