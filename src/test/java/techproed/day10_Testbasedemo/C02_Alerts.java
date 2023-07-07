package techproed.day10_Testbasedemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.Utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
     Eğer bir sayfadaki bir button'a tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye
     sağ click yapip locate alamiyorsak bu bir js Alert'tür.
     js Alert'ü handle edebilmek icin driver'imizi o pencereye gecirmemiz gerekir.Bunun icin
     driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e gecis yapmis oluruz.
     accept() ya da dismiss() methodlariyla js Alert'ü onaylar ya da iptal ederek kapatiriz.
     accept()  ==> onaylar
     dismiss() ==> iptal eder
      */

    @Test
    public void acceptAlert() {
        //Bir metod olusturun: acceptAlert

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(3);
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().  //gecmek icin kullanilan method
                alert().    //alert'a gecis yapar
                accept();   //cikan alert'te ok ya da tamam butonuna basar
        bekle(3);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).isDisplayed());



    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        bekle(2);

        //ve result mesajının “successfuly” icermedigini test edin.
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='result']")).
                getText().contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(3);

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Yunus");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='result']")).getText().contains("Yunus"));
    }
}
