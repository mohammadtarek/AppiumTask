package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Accounts extends BasePage{
    WebElement hassadAcc0056;
    public Accounts(AppiumDriver driver) {
        super(driver);
    }
    public void openAcc(){
        hassadAcc0056=driver.findElementByAccessibilityId("account-widget-1");
        UiActions.clickBtn(hassadAcc0056);
    }
}
