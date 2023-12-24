package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("Nutella Testi", "Kullanıcı amazonda Nutella arayabilmeli");
        // amazona git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi.");
        AmazonPage amazonPage = new AmazonPage();

        // nutella arat
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazılıp, arama yapıldı");
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        String expectedKelime = "Nutella";
        extentTest.info("Arama sonuçları kaydedildi");

        // sonuçların nutella içerdiğini test et.
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuçlarının Nutella içerdiği test edildi.");
    }
}
