package techproed.day20_WebTables_Exel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import techproed.Utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {


    @Test
    public void exelReadTest1() throws IOException {

       //exel dosyasindan veri okuyabilmemiz icin;
        //1 - dosya yolunu aliriz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        //2 - Capitals dosyasini sistemimize getirlmeliyiz. Dosyayi okuyabilmek icin akisa almakiyiz
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3 - dosyayi workbook'a atamaliyiz. java orttaminda bir exel dosyasi olusturmaliyiz.
        Workbook wokrbook = WorkbookFactory.create(fis);

        //4 - sayfayi (sheet) secmeliyiz
        Sheet sheet = wokrbook.getSheet("Sheet1");

        // satiri(row) sevmeliyiz
        Row row = sheet.getRow(0); // 1. satir, index 0 dan baslar.

        //hucreyi(cell) secmeliyiz
        Cell cell = row.getCell(0); // 1. sutun, index 0 dan baslar




    }

    @Test
    public void exelReadTest2() throws IOException {
        // KISA YONTEM

        //1. satir 1/ sutunda ki bilgiyi yazdiriniz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook wokrbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = wokrbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(satir1Sutun1);

    }


    @Test
    public void exelReadTest3() throws IOException {
        //1. satir 2. sutunda ki hucreyi yazdirin
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook wokrbook = WorkbookFactory.create(fis);

        String satir1Sutun2 = wokrbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);

    }
}
