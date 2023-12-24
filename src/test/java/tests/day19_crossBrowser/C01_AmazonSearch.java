package tests.day19_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void test01(){

        // amazon anasayfaya gidelim
        driver.get(ConfigReader.getProperty("amazonUrl"));

        // Nutella için arama yapalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuçların Nutella içerdiğini test edelim
        WebElement sonucYaziElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucYazisi = sonucYaziElement.getText();
        String expectedKelime = "Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}
