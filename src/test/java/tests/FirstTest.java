package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class FirstTest {

    private AppiumDriver<MobileElement> driver;
    public WebDriverWait wait ;
    DesiredCapabilities caps = new DesiredCapabilities();
    @BeforeTest
    public void demoTestConfig() throws MalformedURLException {


        caps.setCapability("platformName", "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        caps.setCapability("appPackage", "com.alrajhiretailapp");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait= new WebDriverWait(driver,20);
}


    @Test
    public void clickListDemoElement() {
        // Launch the app
        //driver.startActivity(new Activity("io.cloudgrey.the_app", ".MainActivity"));


        driver.context("NATIVE_APP");
        WebDriverWait wait = new WebDriverWait(driver, 10);

//        MobileElement listDemoElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"normal-login-form-usernameOrID\"]/android.view.ViewGroup/android.widget.EditText\n")));
        MobileElement listDemoElement = driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\\\"normal-login-form-usernameOrID\\\"]/android.view.ViewGroup/android.widget.EditText\\n"));
        listDemoElement.sendKeys("u3055037x");

        //MobileElement altoElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Altocumulus\"]")));

       // altoElement.click();

        //MobileElement cloudtext = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")));
        //Assert.assertEquals(cloudtext.getText(),"Your Cloud Selection");



    }

    @AfterTest
    public void terminate() throws MalformedURLException {
        driver.quit();
    }

    private void waitForVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private  void scrollIntoView(AppiumDriver mobileObject,String txt)
    {
        mobileObject.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
                + ".instance(0)).scrollIntoView(new UiSelector().textMatches(\""+txt+"\").instance(0))"));
    }
    private void scroll(String element){
        driver.executeScript("mobile: scroll", ImmutableMap.of("strategy","accessibility id","selector",element));
    }
    private  void customClick(AppiumDriver driver,String locator){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(MobileBy.xpath(locator)));
        action.click();
        action.perform();
    }
    public static void CoordinateSwipe(AppiumDriver driver, int startXMargin, int startYMargin, int endXMargin, int endYMargin)  throws Exception {

        new TouchAction<>(driver).press(PointOption.point(startXMargin, startYMargin)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endXMargin, endYMargin)).release().perform();

    }

    //    @Test
//    public void login() throws InterruptedException {
//
//        //click skip
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button/android.widget.TextView\n")).click();
//
//        //click login
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("undefined-doubleButton-first").click();
//
//        //set username
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        WebElement username=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"normal-login-form-usernameOrID\"]/android.view.ViewGroup/android.widget.EditText"));
//        username.sendKeys("u3055037x");
//
//        //set password
//        WebElement password=driver.findElementByAccessibilityId("normal-login-form-password");
//        password.sendKeys("test1234");
//
//        //perform login
//        driver.findElementByAccessibilityId("normal-login-login-button").click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        //set OTP
//        driver.getKeyboard().sendKeys("1111");
//
//

//    }
//{
//    "platformName": "Android",
//        "automationName": "UiAutomator2",
//        "platformVersion": "11",
//        "deviceName": "Pixel 4 API 30",
//        "appPackage": "com.alrajhiretailapp",
//        "appActivity": ".MainActivity"
//}
}
