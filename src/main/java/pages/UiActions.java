package pages;

import org.openqa.selenium.WebElement;

public class UiActions {

    public static void clickBtn(WebElement btn){
        btn.click();
    }
    public static void setTxt(WebElement textFeild,String value){
        textFeild.sendKeys(value);
    }
}
