package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

public class C04_ExplicitWait extends TestBase {

    @Test
    public void Test01() {
        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //==>  "It's gone!" yazısının görünür oldugunu test edin.
        WebElement yazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
