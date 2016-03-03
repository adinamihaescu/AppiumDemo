import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
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
        capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
        //required for native and hybrid testing
        capabilities.setCapability("deviceName", "Android");
        //specify apk path to install the application, if not specify uses the already installed app if any
        capabilities.setCapability("app", "D:\\AppiumTest\\app-debug.apk");
        //application package
        capabilities.setCapability("appPackage", "com.endava.tobetested");
        //main Activity - used to start the application
        capabilities.setCapability("appActivity", ".MainActivity");
        //udid of the device
        capabilities.setCapability("udid", "08b001d200740ce0");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        return driver;
    }

    @Test
    public void appiumExampleTest() throws Exception {
        performTouchAction();
        driver.quit();
    }

    public void performTouchAction() {
        TouchAction action = new TouchAction(driver);
        action.press(208, 361).release().perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

}
