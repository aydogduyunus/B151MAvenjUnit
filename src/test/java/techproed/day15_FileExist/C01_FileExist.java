package techproed.day15_FileExist;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;

import java.nio.file.Paths;

public class C01_FileExist  {

    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));//    /Users/aydogduyunuss/Desktop/Software Testing/Project/B151MAvenUnit
        //bana icinde oldugum projenin dosya yolunu(path) verir



        System.out.println(System.getProperty("user.home"));//   /Users/aydogduyunuss
        //herkesin bilgisayarinda farkli olan kismi verir

        String isletimSistemiAdi = System.getProperty("os.name");
        System.out.println(isletimSistemiAdi);

        // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun



        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */

        ///Users/aydogduyunuss/Desktop
        Assert.assertTrue(Files.exists(Paths.get("/Users/aydogduyunuss/Desktop/text.txt")));

        //daha dinamik hale getirelim

        // "/Users/aydogduyunuss         /Desktop"

       String farkliKisim = System.getProperty("user.home");
       String ortakKisim = "/Desktop/text.txt";  // Herkesin bilgisayarinda ortak olan kisimdir.
       String dosyaYolu = farkliKisim + ortakKisim; // dosya uyolu olarak farkli kisim ve ortak kisimi aldik

       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
