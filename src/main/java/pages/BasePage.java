package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Common methods that can be used across multiple page classes

    public void openPage(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    // Other common methods...

    // Common properties that can be used across multiple page classes

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Other common properties...
}

