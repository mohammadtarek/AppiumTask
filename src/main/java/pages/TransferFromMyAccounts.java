package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TransferFromMyAccounts extends BasePage{
    WebElement dropDownIcon;
    WebElement fromAccount;

    public TransferFromMyAccounts(AppiumDriver driver) {
        super(driver);
    }
    public void openDropDownList(){
        dropDownIcon=driver.findElementByAccessibilityId("BeneficiaryTransferAmount-accountSelector");
        UiActions.clickBtn(dropDownIcon);
    }
    public void chooseFromAcc(){
       fromAccount =driver.findElementByAccessibilityId("AccountList-AccountSelected-5");
       UiActions.clickBtn(fromAccount);
    }
}
