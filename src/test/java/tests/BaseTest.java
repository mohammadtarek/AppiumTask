package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Pixel 4 API 30");
        caps.setCapability("appPackage", "com.alrajhiretailapp");
        caps.setCapability("appActivity", ".MainActivity");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        if (driver!=null){
            driver.quit();
        }
    }
}
