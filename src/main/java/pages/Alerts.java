package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alerts extends BasePage{
    private WebElement afterlogin1Alert;
    private WebElement ignoreUpdateAlert;
    private WebElement donotRemindMe;
    private WebElement laterActivation;
    private  WebElement dismissBtnAftertransfer;
    public Alerts(AppiumDriver driver) {
        super(driver);
    }
    public void ignoreUpdateAlert(){
        ignoreUpdateAlert=driver.findElementByAccessibilityId("container-cancel");
        UiActions.clickBtn(ignoreUpdateAlert);

    }
    public void doNotRemindMe(){
        donotRemindMe=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]"));
        UiActions.clickBtn(donotRemindMe);
    }
    public void laterActivation(){
        laterActivation=driver.findElementByAccessibilityId("undefined-doubleButton-second");
        UiActions.clickBtn(laterActivation);
    }
    public void clickDismissAfterTran(){
        dismissBtnAftertransfer=driver.findElementByAccessibilityId("undefined-doubleButton-second");
        UiActions.clickBtn(dismissBtnAftertransfer);
    }
}
