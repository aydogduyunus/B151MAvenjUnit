package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.Utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
     driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cookileri listelemek istersek
        driver.manage().getCookies() methodu ile bir Set ya da ArrayList'e atarak listeleyebiliriz
         */
       // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);--> lambda ile cookie leri yazdırdık
        Set<Cookie> cookieSet= driver.manage().getCookies();
       int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+". cookie"+w);
            System.out.println(sayac+". cookieName :"+w.getName());//-->Sadece cookie lerin isimlerini aliriz
            System.out.println(sayac+". cookieValue :"+w.getValue());//-->Sadece cookie lerin degerlerini/value larını aliriz
            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("cookilerin sayisi"+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gerçek degerini
        // actualCookieValue degiskenine assign ettik.
        String expectedCookieVae="USD";
        Assert.assertEquals(expectedCookieVae,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);

        }
        Assert.assertEquals("cikolatali",driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("cookie sayısı :"+cookieSet.size());
        System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("silinmeden once cookie sayisi"+ silinmedenOnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//--> ismi skin olan cookie sildik
        bekle(2);
        cookieSet=driver.manage().getCookies();
        for (Cookie each: cookieSet) {
            System.out.println(each);

        }
        int silindiktenSonra =cookieSet.size();
        System.out.println("Silindikten sonra cookie set"+silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//--> tum cookileri sildik
        cookieSet= driver.manage().getCookies();//-->Tekrar cookieSet2i guncelledik
        Assert.assertTrue(cookieSet.isEmpty());//-> ve cookiSet'in icinin bos oldugunu ısEmpty() methodu ıle test ettik
    }
}
