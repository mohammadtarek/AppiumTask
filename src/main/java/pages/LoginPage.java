package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.UiActions.clickBtn;
import static pages.UiActions.setTxt;

public class LoginPage extends BasePage{
    private WebElement usernameField;
    private WebElement passworFeild;
    private WebElement loginBtn;
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void login(String userName,String password){
        usernameField=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"normal-login-form-usernameOrID\"]/android.view.ViewGroup/android.widget.EditText"));
        setTxt(usernameField,userName);
        passworFeild=driver.findElementByAccessibilityId("normal-login-form-password");
        setTxt(passworFeild,password);
        loginBtn= driver.findElementByAccessibilityId("normal-login-login-button");
        clickBtn(loginBtn);
    }

}
