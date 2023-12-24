package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGIlkTest {

    /*
    * TestNG test methodlarını isim sirasina göre çalıştırır.
    * priority değeri verilen method'lar priority değeri küçükten büyüğe göre çalışır.
    * eşite olan priority'de harf sırasına göre çalışır
    * eğer priority değeri yazmazsak priority=0  kabul edilir.
    * */

    @Test (priority = 6)
    public void ilkTest(){

        System.out.println("Ilk test çalıştı");

    }

    @Test
    public void ikinciTest(){

        System.out.println("ikinci test çalıştı");

    }

    @Test (priority = -9)
    public void ucuncuTest(){

        System.out.println("üçüncü test çalıştı");

    }

}
