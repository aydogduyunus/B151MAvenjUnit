package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.Utilities.TestBase;

public class C03_NullPointerException extends TestBase {



    /*
    NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadıgımızda yada esitlemedigimizde
    NullPointerException hatası alırız.

     */


    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;


    @Test
    public void NullPointerExceptionTest1() {
        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        driver.get("https://amazon.com");
    }
}

