package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    /*
    1.http://zero.webappsecurity.com sayfasina gidin
    2.Signin buttonuna tiklayin
    3.Login alanine “username” yazdirin
    4.Password alanine “password” yazdirin
    5.Sign in buttonuna tiklayin
    6.Pay Bills sayfasina gidin
    7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
    8.tarih kismina “2020-09-10” yazdirin
    9.Pay buttonuna tiklayin
    10.“The payment was successfully submitted.” mesajinin ciktigini control edin
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1.http://zero.webappsecurity.com sayfasina gidin
        myDriver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        myDriver.findElement(By.xpath("(//*[@id='signin_button'])[1]")).click();

        //Login alanine “username” yazdirin,Password alanine “password” yazdirin
        WebElement login = myDriver.findElement(By.xpath("//*[@id='user_login'][1]"));
        login.sendKeys("username", Keys.TAB, "password");
        Thread.sleep(3000);

        //Sign in buttonuna tiklayin
        myDriver.findElement(By.cssSelector("input[type='submit']")).click();

        myDriver.navigate().back();


        Thread.sleep(3000); //Pay Bills sayfasina gidin
        myDriver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        Thread.sleep(3000);
        //myDriver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        myDriver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();
        Thread.sleep(3000);

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = myDriver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("200", Keys.TAB, "2020-09-10");
        Thread.sleep(3000);

        //Pay buttonuna tiklayin
        myDriver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(3000);

        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        //WebElement successfully = myDriver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        WebElement successfully =myDriver.findElement(By.cssSelector("span[title='$ 200 payed to payee sprint']"));
        String basariliYazisi = successfully.getText();
        if (basariliYazisi.equals("The payment was successfully submitted.")) {
            System.out.println("Tebrikler başarıyla ödeme gerçekleşti");
        } else {
            System.out.println("Test FAILED");
        }

        myDriver.close();


    }
}
