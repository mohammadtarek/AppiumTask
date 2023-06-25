package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TransferToMyAccounts extends BasePage{
    WebElement hassadAcc0056;
    public TransferToMyAccounts(AppiumDriver driver) {
        super(driver);
    }
    public void chooseaccount(){
        hassadAcc0056=  driver.findElementByAccessibilityId("AccountList-AccountSelected-0");
        UiActions.clickBtn(hassadAcc0056);
    }
}
