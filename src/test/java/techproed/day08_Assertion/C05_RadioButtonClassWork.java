package techproed.day08_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {
     /*
    -https://www.facebook.com adresine gidin
    -Cookies’i kabul edin
    -“Create an Account” button’una basin
    -“radio buttons” elementlerini locate edin
    -Secili degilse cinsiyet butonundan size uygun olani secin
     */
    //

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void test1() throws InterruptedException {
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//div/a)[3]")).click();
        Thread.sleep(3000);
        //-“radio buttons” elementlerini locate edin
        WebElement cinsiyetler = driver.findElement(By.xpath("(//*[@type='radio'])[1]" +
                "|(//*[@type='radio'])[2]|(//*[@type='radio'])[3]"));
        // -Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement erkek = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        if (!erkek.isSelected()) {
            erkek.click();
        }
    }
}
