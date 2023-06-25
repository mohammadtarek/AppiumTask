package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import reader.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TransferScenarioTest extends BaseTest {
IntroPage intrObj;
LoginPage loginObj;
Footer footerObj;
TransferPage transferObj;
TransferToPage transferToObj;
Alerts alertsObj;
TransferToMyAccounts transToMyObj;
TransferFromMyAccounts transFromObj;
ConfirmTransfer confirmTransferObj;
HomePage homePageObj;
Accounts accountsObj;
AccountDetails accountDetailsObj;

String balanceBeforTransfer;
String balanceAfterTransfer;
String transferedAmount="200";
    @DataProvider(name="exelData")
    public  String[][] userRegisterData() throws IOException
    {
        ExcelReader er=new ExcelReader();
        return  er.readDataFromExcel();
    }
    @Test(dataProvider ="exelData" ,priority = 0)
    public void loginWithExcelData(String userName,String pass, String otp, String sit, String marketPlace, String accountNo, String amount) throws InterruptedException {
transferedAmount=amount;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        intrObj=new IntroPage(driver);

        intrObj.clickSkip();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        intrObj.navigateToLogin();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginObj=new LoginPage(driver);
        loginObj.login(userName,pass);

        //send OTP
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.getKeyboard().sendKeys("1111");

        Thread.sleep(10000);
        alertsObj=new Alerts(driver);
        alertsObj.ignoreUpdateAlert();
        Thread.sleep(3000);
        alertsObj.doNotRemindMe();
        Thread.sleep(2000);
        alertsObj.laterActivation();
    }
    @Test (priority = 1)
    public  void makeTransfer() throws InterruptedException {

        homePageObj=new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        homePageObj.clickSeeAll();

        accountsObj=new Accounts(driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        accountsObj.openAcc();

        accountDetailsObj =new AccountDetails(driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        balanceBeforTransfer= accountDetailsObj.getAccBalance();
        System.out.println("this the balance Before: "+balanceBeforTransfer);
        //click back

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"header-leftPress\"]/android.view.ViewGroup/android.widget.ImageView")).click();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"header-leftPress\"]/android.view.ViewGroup/android.widget.ImageView")).click();


        footerObj=new Footer(driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        footerObj.goToTransfer();


        transferObj=new TransferPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        transferObj.goToTransfers();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        transferToObj =new TransferToPage(driver);
        transferToObj.goToMyAccounts();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        transToMyObj=new TransferToMyAccounts(driver);
        transToMyObj.chooseaccount();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.getKeyboard().sendKeys(transferedAmount);

        transFromObj=new TransferFromMyAccounts(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(2000);
        transFromObj.openDropDownList();
        transFromObj.openDropDownList();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
        transFromObj.chooseFromAcc();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        confirmTransferObj=new ConfirmTransfer(driver);
        confirmTransferObj.clickNext();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        confirmTransferObj.confirmTran();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.getKeyboard().sendKeys("1111");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
        confirmTransferObj.goToDashBoard();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        alertsObj.clickDismissAfterTran();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePageObj.clickSeeAll();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        accountsObj.openAcc();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        balanceAfterTransfer= accountDetailsObj.getAccBalance();

        balanceBeforTransfer = balanceBeforTransfer.replace(",", ""); // Remove the comma
        balanceAfterTransfer=balanceAfterTransfer.replace(",","");
        int before=0;
        int after=0;
        try {
             before = Integer.parseInt(balanceBeforTransfer);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + balanceBeforTransfer);
        }
        try {
             after = Integer.parseInt(balanceAfterTransfer);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + balanceAfterTransfer);
        }
        int trans=Integer.parseInt(transferedAmount);
        int expected= before + trans;
        Assert.assertEquals(after,expected);
        Thread.sleep(5000);


    }
//
//        @Test
//    public void login() throws InterruptedException {
//
//        //click skip
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button/android.widget.TextView\n")).click();
//
//        //click login
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElementByAccessibilityId("undefined-doubleButton-first").click();
//
//        //set username
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        WebElement username=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"normal-login-form-usernameOrID\"]/android.view.ViewGroup/android.widget.EditText"));
//        username.sendKeys("u3055037x");
//
//        //set password
//        WebElement password=driver.findElementByAccessibilityId("normal-login-form-password");
//        password.sendKeys("test1234");
//
//        //perform login
//        driver.findElementByAccessibilityId("normal-login-login-button").click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        //set OTP
//        driver.getKeyboard().sendKeys("1111");
//
//
//
//    }
}