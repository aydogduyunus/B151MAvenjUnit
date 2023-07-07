package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDowload extends TestBase {

    @Test
    public void name() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //"b10 all test cases" dosyasını indirin
        WebElement indirilenDosya = driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        indirilenDosya.click();
        bekle(5);


        File silinecekDosya = new File("/Users/aydogduyunuss/Downloads/b10 all test cases, code.docx");
       silinecekDosya.delete();

        /*
      File silinecekDosya=new File("/Users/betulsongul/Downloads/b10 all test cases, code.docx") ;
silinecekDosya.delete();

Eğer  localinizden otomasyon ile dosya silmek için File class ından obje oluşturup dosya yolunu içine yerleştiririz.
 Ve oluşturduğumuz obje ile delete() methodunu kullanarak silebiliriz.
 Bunu yapma sebebimiz test classımızı çalıştırmada yeni bir dosya indireceği için oradaki dosya kalabalığını önlemiş oluruz
 Aynı zamananda doğrulama yaparken işimizi garantiye almış oluyoruz
 Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
 o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz
         */

        // Dosyanın başarıyla indirilip indirilmediğini test edin.

         /*
        dosyanın, bilgisayarımda dowloads'a basarıyla indirilip indirilmedigini
        java ile test edecegim.
        cünkü selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki dowloads'a müdahele edemez.
         */

        bekle(3);

        Assert.assertTrue(Files.exists(Paths.get("/Users/aydogduyunuss/Downloads/b10 all test cases, code.docx")));

        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/Downloads/b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
