package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.Utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    // Implictly Wait==> Sayfadaki tüm webelementlerim yüklenebilmesi icin max. bekleme süresi

    // Explict Wait==> Belirli bir kosul gerceklesene kadar max sure boyunca
    // default olarak 500ms aralıklarla webelementi kontrol ederek bekler.
    // (sadece belirli bir webelement icin kullanılır)




    //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
    //==> Start buttonuna tıklayın
    //==> Hello World! yazısının görünürlügünü test edin
    @Test
    public void Test01() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
       driver.findElement(By.xpath("//button[text()='Start']")).click();
       // Duz mantik  //==> Hello World! yazısının görünürlügünü test edin
       /*
        bekle(10);
        WebElement helloGorunurluk= driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertTrue(helloGorunurluk.isDisplayed());

        */

        // WebElement helloworldYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        //diger yol
        WebElement helloGorunurluk= driver.findElement(By.xpath("//div[@id='finish']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloGorunurluk));

        Assert.assertTrue(helloGorunurluk.isDisplayed());
    }
}
