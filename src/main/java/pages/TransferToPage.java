package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static pages.UiActions.clickBtn;

public class TransferToPage extends BasePage{

    private WebElement myAccounts;
    public TransferToPage(AppiumDriver driver) {
        super(driver);
    }

    public void goToMyAccounts(){
        myAccounts=driver.findElementByAccessibilityId("transfers-tabs-betweenMyAcclounts");
        clickBtn(myAccounts);
    }
}
