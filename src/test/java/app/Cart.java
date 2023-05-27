package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Cart extends BaseTest {
    private By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private By element = By.id("com.androidsample.generalstore:id/productPrice");
    private By checkBox = By.xpath("(//android.widget.CheckBox)[1]");
    private By visitWebSite = By.id("com.androidsample.generalstore:id/btnProceed");
    private By totalAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");

    @Test
    public void compareTheSumFor2Element() throws InterruptedException {
        loginIn();
        /*
         * change to make it reusable functions
         * */
        addSpecficElementToCartByScrolling("Air Jordan 1 Mid SE");
        addSpecficElementToCartByScrolling("Jordan 6 Rings");

        WebElement cartLocation = driver.findElement(cartButton);
        cartLocation.click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(element);

        System.out.println(elements.get(0).getText());
        System.out.println(elements.get(1).getText());
        String first = elements.get(0).getText();
        Double firstPrice = Double.parseDouble(first.substring(1));
        String second = elements.get(1).getText();
        Double secondPrice = Double.parseDouble(second.substring(1));

        Double sum = (firstPrice + secondPrice);
        Assert.assertEquals(sum, driver.findElement(totalAmount).getText(), "There wrong in calculate ");
        driver.findElement(checkBox).click();
        driver.findElement(visitWebSite).click();
        Thread.sleep(4000);
    }

    @Test
    public void compareTheSum() throws InterruptedException {
        loginIn();
        /*
         * change to make it reusable functions
         * */
        addSpecficElementToCartByScrolling("Air Jordan 1 Mid SE");
        addSpecficElementToCartByScrolling("Jordan 6 Rings");

        WebElement cartLocation = driver.findElement(cartButton);
        cartLocation.click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(element);

        int count = elements.size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String total = elements.get(i).getText();
            Double price = getFormatAmount(total);
            sum = sum + price;
        }

        Double acutual = getFormatAmount(driver.findElement(totalAmount).getText());
        Assert.assertEquals(sum, acutual, "There wrong in calculate ");
        driver.findElement(checkBox).click();
        driver.findElement(visitWebSite).click();
        Thread.sleep(4000);
    }
}
