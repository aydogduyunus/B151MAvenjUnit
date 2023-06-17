package techproed.day10_Testbasedemo;

import org.junit.Assert;
import org.junit.Test;
import techproed.Utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim.
        driver.get("https://techproeducation.com");
        bekle(2);
        //Basligin Bootcamp icerdigini test edelim.
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
