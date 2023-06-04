package app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleBrowser extends MobBrowserTestBase{
    @Test(groups = {"browser"})
    public void browserTest() throws InterruptedException {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("ahmedziko");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }

    @Test(groups = {"browser"})
    public void testHumgerMenu() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/nav/button ")).click();
        driver.findElement(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.active > a")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to scroll down
        js.executeScript("window.scrollBy(0,250)", "");
          driver.findElement(By.xpath("//*[contains(text(), 'Devops')]")).click();

        WebElement text =  driver.findElement(By.xpath("//*[contains(text(), 'Devops')]"));
        Assert.assertEquals(text.getText(),"DEVOPS","there wrong in message");
        Thread.sleep(3000);


        //
    }

}
