package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmTransfer extends BasePage{
    WebElement nextBtn;
    WebElement confirmBtn;
    WebElement goToDashBoardBtn;
    public ConfirmTransfer(AppiumDriver driver) {
        super(driver);
    }
    public  void clickNext(){
        nextBtn=driver.findElementByAccessibilityId("BeneficiaryTransferAmount-form-submit");
        UiActions.clickBtn(nextBtn);
    }
    public void confirmTran(){
        confirmBtn=driver.findElementByAccessibilityId("BeneficiaryTransferConfirm-confirmButton");
        UiActions.clickBtn(confirmBtn);
    }
    public  void goToDashBoard(){
        goToDashBoardBtn=driver.findElementByAccessibilityId("BeneficiaryTransferConfirm-success-goToDashboard");
        UiActions.clickBtn(goToDashBoardBtn);
    }
}
