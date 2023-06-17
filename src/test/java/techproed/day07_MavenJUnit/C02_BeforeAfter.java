package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
     /*
        Notasyonlara sahip method'lar oluşturabilmek icin mouse+sağtik+generate yaparak after methodu için teardown'i seceriz
        before methodu icin setup'i seceriz.
        test methodu icin test'i seceriz.
        JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
        Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir
      */

    @After
    public void tearDown()  {
        System.out.println("Her test methodundan sonra 1 kez calisir.");
    }

    @Before
    public void setUp() {
        System.out.println("Her test methodundan önce 1 kez calisir.");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti");
    }


    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti");
    }
}
