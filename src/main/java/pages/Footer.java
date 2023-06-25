package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.UiActions.clickBtn;

public class Footer extends BasePage{
    public Footer(AppiumDriver driver) {
        super(driver);
    }

    private WebElement transferBtn;

    public void goToTransfer(){
        transferBtn=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Transfers, tab, 2 out of 5\"]"));
        clickBtn(transferBtn);
    }
}
