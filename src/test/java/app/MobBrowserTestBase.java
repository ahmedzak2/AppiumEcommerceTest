package app;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

public class MobBrowserTest {

    @Test
    public void createBrowserTest(){
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setDeviceName("sdk_gphone64_x86_64");
        options.setDeviceName("sdk_gphone64_x86_64");
        //options.setPlatformName("Android");

        //to make chrome work in mobile

        options.setChromedriverExecutable("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\resources\\chromedriver.exe");
        options.setPlatformVersion("12");

    }
}
