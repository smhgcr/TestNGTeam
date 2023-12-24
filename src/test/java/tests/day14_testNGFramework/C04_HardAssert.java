package tests.day14_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_HardAssert {

    /*
    testNG'de 2 tane assert class'ı vardır.
    1: JUnit'deki assert class'ı ile aynı methodlara sahiptir.
    ilk faild olan assert işleminde calısmayı durdurur ve hata mesajı verir.

    2.assert class'ının adı SoftAssert oldugu için ilkine Hard assert denmiştir

    2: Assert class'ı ise SoftAssert class'ıdır.
    SoftAssert biz dur raporla deyinceye kadar assertionları faild olsa bile
    calıstırmaya devam eder. Biz raporlar dediğimizde calısan assertionlardan
    kacının faild oldugunu söyler ve faild olan assertion varsa raporla dedigimiz
    satırda calısmayı durdurur.
     */

    @Test
    public void test01(){

        Assert.assertTrue(6>4);
        System.out.println("Birinci Assertion sonrası");
        Assert.assertTrue(6>14);
        System.out.println("İkinci Assertion sonrası");
        Assert.assertEquals(6,6);
        System.out.println("Ücüncü Assertion sonrası");

    }
}
