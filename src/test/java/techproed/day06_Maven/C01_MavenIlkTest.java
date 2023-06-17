package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C01_MavenIlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        myDriver.get("https://amazon.com");

        //arama kutusunu locate edelim.
        WebElement aramaKutusu = myDriver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //"Samsung headphones" ile arama yapalım.
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayısını yazdıralım.
        WebElement sonuc = myDriver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        //1-16 of 199 results for "Samsung headphones"

        String sonucYazisi = sonuc.getText();
        String[] arr = sonucYazisi.split(" ");
        System.out.println("Sonuc Sayısı= " + arr[2]);

        //ilk ürünü tıklayalım
        myDriver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki Tüm Basliklari Yazdiralim           !!!!!!!çoooook işime yarar!!!!!!!!!
        List<WebElement> sayfaBasliklari = myDriver.findElements(By.xpath("//h1|//h2|//h3|//h4|//h5|//h6"));
        sayfaBasliklari.forEach(t -> System.out.println(t.getText()));

    }
}
