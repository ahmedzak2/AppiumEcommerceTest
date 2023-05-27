package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases2 extends BaseTest {
    private By productName = By.id("com.androidsample.generalstore:id/productName");
    private By cart = By.id("com.androidsample.generalstore:id/toolbar_title");
    private By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    @Test
    public void testscannig() throws InterruptedException {
        loginIn();
        /*
         * change to make it reusable functions
         * */
        addSpecficElementToCartByScrolling("Jordan 6 Rings");

        String lastProduct = driver.findElement(productName).getText();

        WebElement cartLocation = driver.findElement(cartButton);
        cartLocation.click();
        Thread.sleep(3000);
        WebDriverWait wiat = new WebDriverWait(driver, Duration.ofSeconds(6));

        wiat.until(ExpectedConditions.visibilityOfElementLocated(cart));

// to check if the element which show is cart
        System.out.println(driver.findElement(cart).getText());
        wiat.until(ExpectedConditions.attributeContains(driver.findElement(cart), "text", "Cart"));
        Assert.assertEquals(lastProduct, "Jordan 6 Rings", "There wrong in part");

    }
}
