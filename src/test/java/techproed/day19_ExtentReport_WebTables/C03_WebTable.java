package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.Utilities.TestBase;

import java.util.List;

public class C03_WebTable extends TestBase {

    public void printData (String rowNumber,String columnNumber){
        List<WebElement> table1 = driver.findElements(By.xpath("//table[1]//td"));

    }
    /*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
                <th> table head
                    <td> basliktaki veriler
                <tbody> basliklar altindaki verileri temsil eder
                        <tr> table row(satir)
                            <td> table data(tablodaki veri)
 */

    @Test
    public void Test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println(table1.getText());
        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*************************************");
        System.out.println(ucuncuSatir.getText());
        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir= driver.findElement(By.xpath("(//table)[1]//tr[4]"));
        System.out.println("sonSatir");
        System.out.println( ucuncuSatir.getText());
        System.out.println("****************************");
        //    Task 4 : 5. Sütun verilerini yazdırın
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//table[1]//td[5] | //table[1]//td[11] |//table[1]//td[17] |//table[1]//td[23]"));
        besinciSutun.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println("*************************************");
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        //printData(2, 3);
    }
}
