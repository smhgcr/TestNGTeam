package tests.day14_testNGFramework;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

import java.security.Key;

public class C03_NutellaTesti {


    @Test(groups = {"minireg1","minireg2","smoke"})
    public void test01(){

        // amaozon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // nutella için arama yapın
        // WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuçların Nutella içerdiğini test edin.
        WebElement aramaSonucuElementi = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedKelime = "Nutella";
        String actualAramaSonuc = aramaSonucuElementi.getText();

        Assert.assertTrue(actualAramaSonuc.contains(expectedKelime));

        Driver.closeDriver();

    }
}
