package techproed.day11_Iframe_WındowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C01_Iframe extends TestBase {
  /*
        Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline frame yani IFRAME denir.
    Bir sayfada iframe varsa iframe içindeki webelementi handle edebilmek için switchTo() methoduyla iframe'e
    geçiş yapmamız gerekir. Eğer geçiş yapmazsak nosuchelementexception alırız.
        Alert'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. Iframe olsada locate ederiz fakat
    handle edemeyiz
     */

    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->geçiş yapmazsak Nosuchelementexception hatası alırız
        String ApplicationslistsYazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(ApplicationslistsYazisi);
        Assert.assertEquals("Applications lists",ApplicationslistsYazisi);

        //Son olarak sayfa baslıgında iframe yazısının görünür oldugunu test ediniz
        //driver.switchTo().defaultContent();
        //driver.get(driver.getCurrentUrl());//sayfayı yenıler anasayfaya gerı doner
        driver.navigate().refresh();// bu da sayfayı yenıler
        WebElement iframeYazisi =driver.findElement(By.xpath("//h3"));
       Assert.assertTrue(iframeYazisi.isDisplayed());
       /*
       Eger ıkı tane ıframe olsaydı ve ıkıncı frame'e gecmek ısteseydık ındex'i 1 almam gerekecekti.
             <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frameWe = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frameWe) geçiş yapabiliriz.
        */

        //driver.get(driver.getCurrentUrl());
        //driver.switchTo().parentFrame();
        //driver.navigate().refresh();
        //Usttekilerin hepsi iframe'den ana sayfaya donmek icin kullanilir

         /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */


    }
}
