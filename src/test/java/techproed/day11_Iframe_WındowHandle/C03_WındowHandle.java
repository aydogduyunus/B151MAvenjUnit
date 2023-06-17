package techproed.day11_Iframe_WındowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.Utilities.TestBase;

public class C03_WındowHandle extends TestBase {
    @Test
    public void windowHandle() {

                 /*
        Eger sayfaya gittikten sonra yeni sekme ya da yeni bir pencere ıle baska sayfaya gittikten sonra
        tekrar ilk actıgınız sayfaya donmek ıstersenız, ilk sayfaya driverç.get() methodu ıle gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acılan sayfaya dönmek istediğinizde
        driver.switchTo().window(ilksayfaHandleDegeri) ıle geciş yapabilirsiniz.
                 */

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com ");
        String techproEdWindowHandle= driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle =driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.
                switchTo().//geciş yap
                newWindow(WindowType.WINDOW);// --> yeni bir pencereye driver'i tasir
       //WindowType.TAB dersem yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedInWindowHandle = driver.getWindowHandle();
        bekle(3);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproEdWindowHandle);
        bekle(3);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindowHandle);
        bekle(3);
    }

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com ");
        String techproEdWindowHandle= driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle =driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.
                switchTo().//geciş yap
                newWindow(WindowType.TAB);// --> yeni bir pencereye driver'i tasir
        //WindowType.TAB dersem yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedInWindowHandle = driver.getWindowHandle();
        bekle(3);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproEdWindowHandle);
        bekle(3);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindowHandle);
        bekle(3);
    }
}
