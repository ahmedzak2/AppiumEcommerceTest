package app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobBrowserTestBase {
    public String url2 = "http://localhost:4723";

    public AndroidDriver driver;

    @BeforeMethod(groups = { "browser" })
    public void createBrowserTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setDeviceName("sdk_gphone64_x86_64");
        options.setDeviceName("sdk_gphone64_x86_64");
        //options.setPlatformName("Android");

        //to make chrome work in mobile

        options.setChromedriverExecutable("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\resources\\chromedriver.exe");
        // to tell it what and which  browser we use and set it
        options.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL(url2), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @AfterMethod(groups = { "browser" })
    public void tearDown() {
        driver.quit();
    }


}
