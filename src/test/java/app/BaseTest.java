package app;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public String url = "http://localhost:4723/wd/hub";
    public String url2 = "http://localhost:4723";



    private By countyMenu =By.id("com.androidsample.generalstore:id/spinnerCountry");
    private By countryChoise =By.xpath("(//android.widget.TextView)[6]");
    private By countryResult = By.id("android:id/text1");
    private By name = By.id("com.androidsample.generalstore:id/nameField");
    private By feamleOption= By.id("com.androidsample.generalstore:id/radioFemale");
    private By letShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    @BeforeMethod

    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setDeviceName("sdk_gphone64_x86_64");
        options.setDeviceName("sdk_gphone64_x86_64");
        //options.setPlatformName("Android");
        options.setPlatformVersion("12");
        // options.setAutomationName("Appium");
        options.setApp("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\appLocation\\General-Store.apk");
        //options.setApp(System.getProperty("C:\\Users\\20112\\IdeaProjects\\appium\\src\\test\\resources\\ApiDemos-debug.apk"));
        //  driver2 = new AppiumDriver(new URL(url),options);
        driver = new AndroidDriver(new URL(url2), options);
        /*different locator appium surrport
         * ID -Name -Class Name - Accessibility ID - Xpath - ccs clestor -UIAUtomator */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void loginIn() throws InterruptedException {
        driver.findElement(name).sendKeys("Aya");
        driver.findElement(feamleOption).click();
        driver.findElement(countyMenu).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();
        driver.findElement(letShop).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /*
     * to scroll to end of page
     * */

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }

}
