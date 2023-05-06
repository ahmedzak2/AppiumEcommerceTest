package app;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest{
    private By countyMenu =By.id("com.androidsample.generalstore:id/spinnerCountry");
   private By countryChoise =By.xpath("(//android.widget.TextView)[6]");
   private By countryResult = By.id("android:id/text1");
   private By name = By.id("com.androidsample.generalstore:id/nameField");
   private By feamleOption= By.id("com.androidsample.generalstore:id/radioFemale");
   private By letShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(name).sendKeys("Aya");
        driver.findElement(feamleOption).click();
        driver.findElement(countyMenu).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();

       // driver.findElement(countryChoise).click();

        String Text = driver.findElement(countryResult).getText();
        Thread.sleep(2000);
        Assert.assertEquals(Text,"Egypt","there worng choise");
        driver.findElement(letShop).click();

        Thread.sleep(5000);

    }
    @Test
    public void makeError() throws InterruptedException {
        driver.findElement(feamleOption).click();
        driver.findElement(countyMenu).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();

        // driver.findElement(countryChoise).click();

        String Text = driver.findElement(countryResult).getText();
        Thread.sleep(2000);
        Assert.assertEquals(Text,"Egypt","there worng choise");
        driver.findElement(letShop).click();

        //Thread.sleep(5000);
/*
* to Know the Alert message and  use it
* beacuse it present on Toasat and i don't know to git it forms Ui
* */

     String ToastMessage=   driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
Assert.assertEquals(ToastMessage,"Please enter your name","There wrong message");
    }


}
