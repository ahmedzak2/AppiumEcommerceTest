package app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class HybridApp extends BaseTest {
    private By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private By element = By.id("com.androidsample.generalstore:id/productPrice");
    private By checkBox = By.xpath("(//android.widget.CheckBox)[1]");
    private By visitWebSite = By.id("com.androidsample.generalstore:id/btnProceed");
    private By totalAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");
    // private By termButton = By.id("com.androidsample.generalstore:id/termsButton");
    private AppiumBy termsButton = (AppiumBy) AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    private AppiumBy closeTerms = (AppiumBy) AppiumBy.id("android:id/button1");
    private AppiumBy alertMessage = (AppiumBy) AppiumBy.id("android:id/message");
    private AppiumBy alerHeader = (AppiumBy) AppiumBy.id("com.androidsample.generalstore:id/alertTitle");





    @Test
    public void loadBrowser() throws InterruptedException {
        loginIn();
        /*
         * change to make it reusable functions
         * */

        addSpecficElementToCartByScrolling("Jordan 6 Rings");

        WebElement cartLocation = driver.findElement(cartButton);
        cartLocation.click();

        preesLongTouch(termsButton);
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(alerHeader).getText(), "Terms Of Conditions", "There wrong in calculate ");
        Assert.assertTrue(driver.findElement(alertMessage).getText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting in"), "There wrong in calculate ");
        driver.findElement(closeTerms).click();

        List<WebElement> elements = driver.findElements(element);

        driver.findElement(checkBox).click();
        driver.findElement(checkBox).click();
        driver.findElement(visitWebSite).click();
        Thread.sleep(6000);

        /*
        * to get all context (2  app-website)
        * the app is one context and
        * website which google open is another one
        * */

        // to save all context name in list
        Set<String> context=  driver.getContextHandles();
// then print all name and choose the web
        // it can be different depend on the developer of app

        for (String contrextname:context){
    System.out.println(contrextname);
            System.out.println("ahmed");

        }

        driver.context("WebView");
driver.findElement(By.name("q")).sendKeys("ahmedZiko");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
   driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


}
