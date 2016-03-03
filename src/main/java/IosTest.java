import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
public class IosTest {

    AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        driver = getPerfectoMobileIos();
    }

    public static IOSDriver getPerfectoMobileIos() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "PUBLIC:IosTestExample.ipa");
        capabilities.setCapability("bundleId", "com.bounty.iostestexample");
        capabilities.setCapability("udid", "8BC9B549940E154E2BF6F703541E6D524A757D51");
        capabilities.setCapability("platformVersion", "9.0.2");
        capabilities.setCapability("deviceName", "iPad Air 2");

        capabilities.setCapability("user", "username");
        capabilities.setCapability("password", "password");

        URL url = new URL("https://credit-suisse.perfectomobile.com/nexperience/perfectomobile/wd/hub");
        IOSDriver driver = new IOSDriver(url, capabilities);
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
