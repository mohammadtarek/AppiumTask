package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;


import static pages.UiActions.clickBtn;

public class IntroPage extends BasePage{
    public IntroPage(AppiumDriver driver) {
        super(driver);
    }



    public WebElement skipButton;
    public WebElement loginBtn;

    public  void clickSkip(){
        skipButton =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button/android.widget.TextView"));
        clickBtn(skipButton);
    }
    public void navigateToLogin(){
        loginBtn= driver.findElementByAccessibilityId("undefined-doubleButton-first");
        clickBtn(loginBtn);

    }
}
