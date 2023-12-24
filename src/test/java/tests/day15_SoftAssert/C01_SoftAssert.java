package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssert {

    @Test(groups = {"minireg2"})
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // amazon anasayfaya gittiğinizi doğrulayın
        SoftAssert softAssert = new SoftAssert();
        String expectedUrlKelime = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        //softAssert.assertTrue(actualUrl.contains(expectedUrlKelime));
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon içermiyor");
        // Nutella aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuçlarının nutella içerdiğini doğrulayın
        String aramaSonuYazisi = amazonPage.aramaSonucuElementi.getText();
        //softAssert.assertTrue(aramaSonuYazisi.contains("Nutella"));
        softAssert.assertTrue(aramaSonuYazisi.contains("Nutella"),"Arama sonuçları Nutella içermiyor");

        // Java aratın
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java" + Keys.ENTER);
        ReusableMethods.wait(3);

        // arama sonuçlarını 1000'den fazla olduğunu doğrulayın

        // 1-48 of over 5,000 results for "Java"

        aramaSonuYazisi = amazonPage.aramaSonucuElementi.getText();
        String[] sonucArr = aramaSonuYazisi.split(" ");
        // [1-48, of, over, 5,000, results, for, "Java"]

        String javaSonucSayisiStr = sonucArr[3]; // 5,000

        javaSonucSayisiStr = javaSonucSayisiStr.replaceAll("\\W",""); // 5000

        int sonucSayisiInt = Integer.parseInt(javaSonucSayisiStr);

        //softAssert.assertTrue(sonucSayisiInt > 10000);
        softAssert.assertTrue(sonucSayisiInt > 1000,"Java için arama sayısı 1000'den çok değil ");

        softAssert.assertAll();
        Driver.closeDriver();

    }
}
