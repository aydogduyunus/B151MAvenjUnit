package techproed.day10_Testbasedemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println(getTextAlert()); //getTextAlert ==> TestBase class'inda oluşturmuş olduğumuz method...
        Assert.assertEquals("You clicked a button", getTextAlert());
        //Ve alert'ü kapatalım
        acceptAlert();//TestBase class'inda oluşturmuş olduğumuz method...
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(2);
        //On button click, confirm box will appear karşısındaki button'a basalim.
        driver.findElement(By.xpath("(//*[@type='button'])[4]")).click();
        bekle(3);
        //Cikan Alert'te İptal'e basalim.
        dismissAlert();
        bekle(3);

        //Sonuc yazisinda You selected Cancel yazdigini dogrulayalim.
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel", sonucYazisi);

    }

    @Test
    public void test03() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        bekle(3);
        //On button click, prompt box will appear karşısındaki button'a tiklayalim.
        driver.findElement(By.xpath("(//*[@type='button'])[5]")).click();
        bekle(3);
        //Cikan alert'e isminizi giriniz.
        sendKeysAlert("Baho Baba");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım.
        WebElement isimDogrulama = driver.findElement(By.id("promptResult"));
        System.out.println(isimDogrulama.getText());
        Assert.assertTrue(isimDogrulama.isDisplayed());
    }
}
