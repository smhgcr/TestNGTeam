package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
        *  @DataProvider istediğimiz test metoduna test datası sağlamak için kullanılır
        * sadece bir şarttı vardır.
        * iki katlı bir Object array'ı döndürmelidir.
        * */
        Object[][] amazonAranacakKelimelerArrayi =
                {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"armut"}};

        return amazonAranacakKelimelerArrayi;
    }

    // amazona gidelim
    // Nutella, Java, Apple, Samsung kelimeleri için arama yapalım
    // ve sonuçların bu kelimeleri içerdiğini test edelim

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);

        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));

        Driver.closeDriver();


    }
}
