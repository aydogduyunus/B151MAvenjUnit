package techproed.day08_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'tan önce BeforeClass Method'u bir kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'tan sonra AfterClass Method'u bir kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'tan önce Before methodu bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'tan sonra After(tearDown) methodu bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test 01 calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test 02 calisti");

    }

    @Test
    public void test03() {
        System.out.println("Test 03 calisti");

    }
}
