package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static pages.UiActions.clickBtn;

public class TransferPage extends BasePage{
    private WebElement transferBtn;
    public TransferPage(AppiumDriver driver) {
        super(driver);
    }

    public void goToTransfers(){
        transferBtn=driver.findElementByAccessibilityId("transfer-newTransferBox");
        clickBtn(transferBtn);
    }
}
