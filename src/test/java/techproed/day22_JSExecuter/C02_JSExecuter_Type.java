package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.*;
import techproed.Utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {


    // https://techproeducation.com sayfasına gidin
    // Arama kutusuna "QA" yazıp aratın


    @Test
    public void typeTest() {

        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(2);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // reklam

        bekle(4);

        // Arama kutusuna "QA" yazıp aratın

       /*
       1. yol

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);

        sendKeysJS(aramaKutusu,"QA");

        */

        //NOT:
        //arama kutusunun HTML kodlari arasinda value attribute vardir. Bu HTML kodlarinin son kelimesidir.
        //Value degerine QA yazdirmis oluyoruz.
        //Arguments[0] ise origin'i temsil etmektedir.

        //2. yol

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);



    }
}
