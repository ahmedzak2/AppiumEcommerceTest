package app;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class ScrollScanProduct extends BaseTest {
    private By airJorden = By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']");
private By productName = By.id("com.androidsample.generalstore:id/productName");
private  By addToCart = By.id("com.androidsample.generalstore:id/productAddCart");
   private By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    @Test
    public void Scroll() throws InterruptedException {
        loginIn();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));")).click();

 /*
 * beascue we have more than one element have same i use for loop git the text and index of
 * element to compare it with the required text if match get the index to pass it to click on it
 * */
  int productCount= (driver.findElements(productName)).size();
for (int i =0;i<productCount;i++){

   String product= driver.findElements(productName).get(i).getText();
if (product.equalsIgnoreCase("Jordan 6 Rings")){
    driver.findElements(addToCart).get(i).click();
}
}
driver.findElement(cartButton).click();
Thread.sleep(2000);

    }

}
