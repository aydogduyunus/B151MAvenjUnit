package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sag tıklayın
        WebElement kutu =driver.findElement(By.cssSelector("[id='hot-spot']"));
        //sag click yapabilmek icin oncelikle Actions clas'ından bir obje olusturmaliyiz
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).//sag click yapma methodu kullandık.argüman ıcın webelementin locatini yazdık
                perform();//actions objemizle yapacagımız islemi uygulaması ıcın veya sonlandirmasi icin perform() kullaniriz
        bekle(2);
        // Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText()); methodsuz
        Assert.assertEquals("You selected a context menu",getTextAlert());//testBase deki method ıle cozumu
        bekle(2);
        // Tamam diyerek alert’i kapatın
        acceptAlert();//-->TestBase' deki methodu kullandık --> driver.switchTo().alert().accept();

    }
}
