package app;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Appium extends BaseTest {
    // AppiumDriver driver2;
    /**
     * there 2 type of By one generic for appium and web
     * other only for appium  (AppiumBy)
     */

    private AppiumBy preference = (AppiumBy) AppiumBy.accessibilityId("Preference");

    @Test
    public void appiumTest() throws InterruptedException {

        /*to set and show the specification of app we use class UiAutomator2Options
         * */
        driver.findElement(preference).click();
        Thread.sleep(10000);
    }
}