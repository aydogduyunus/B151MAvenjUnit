package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C03_File_Upload extends TestBase {
    @Test
    public void test() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        ///Users/betulsongul/Desktop/deneme.txt
        // dosya yolunu dinamik yapıyoruz
        String fakliKisim=System.getProperty("user.home");
        String ortakKisim="/Desktop/text.txt";
        String dosyaYolu=fakliKisim+ortakKisim;
        dosyaSec.sendKeys(dosyaYolu);

        // 'Upload' butonuna basın
         driver.findElement(By.xpath("/html//input[@id='file-submit']")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
       WebElement fileUpload =  driver.findElement(By.xpath("//h3"));

       Assert.assertTrue(fileUpload.isDisplayed());

    }
}
