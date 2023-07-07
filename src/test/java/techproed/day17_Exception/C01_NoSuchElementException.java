package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.Utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {


    @Test
    public void Test01() {


       /*
       NoSuchElementException:

       sayfada bulunmayan bir elemente erisim saglanmaya calısıldıgında
       NoSuchElementException hatası alırız.
        */

        // techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");
        bekle(3);


        // reklamı kapatınız
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // searchBox'a java yazıp aratınız
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("Java" + Keys.ENTER);

    }
}
