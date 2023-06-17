package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.Utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
         /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        //Congratulations! yazısının çıktıgını dogrulayınız
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));
        //Elemental Selenium yazısına tıklayalım

        driver.findElement(By.xpath("(//a)[2]")).click();//--> yeni bir pencere actıgı ıcın switch yapacagız
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//acılan yenii pencereye geçtik
        //Basligin Elemental Selenium olmadığını dogrulayin
        System.out.println(driver.getTitle());//--> Elemental Selenium | Elemental Selenium
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //DDM' den Java secelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        //Select select = new Select(ddm);
        //select.selectByVisibleText("Java");

        selectVisibleText(ddm,"Java");//--> method ıle yapılmıs hali


    }
}
