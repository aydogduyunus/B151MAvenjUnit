package techproed.day08_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {

    @Test
    public void test01() {
        Assert.assertEquals(2, 2);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test02() {
        Assert.assertEquals(3, 3);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5, 4);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test04() {
        String actualName = "Erol";
        String expectedName = "Erol";
        Assert.assertEquals(actualName, expectedName);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test05() {
        int yas = 50;
        int emekliYas = 65;
        Assert.assertTrue(yas<emekliYas);
        System.out.println("Test basarili");
    }
    @Test
    public void test06() {
        int yas = 50;
        int emekliYas = 65;
        Assert.assertFalse(yas>emekliYas);
        System.out.println("Test basarili helalll");
    }
}
