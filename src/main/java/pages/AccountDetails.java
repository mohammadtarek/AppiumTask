package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AccountDetails extends BasePage{
   private String balance;
    public AccountDetails(AppiumDriver driver) {
        super(driver);
    }
    public String getAccBalance(){
        balance=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")).getText();
        return balance;
    }
}
