package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLoginTesti {

    // 3 test methodu olusturun
    // 1.de yanlıs email, dogru sifre
    // 2.de dogru email, yanlis sifre
    // 3. de yanlış email, yanlış şifre ile giriş yapmayı deneyin
    // giriş yapılamadığını test edin.

    QualitydemyPage qualitydemyPage = new QualitydemyPage();
    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(4);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.wait(1);
        Driver.closeDriver();

    }

    @Test
    public void yanlisPasswordTesti(){

        qualitydemyPage = new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(4);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.wait(1);
        Driver.closeDriver();

    }

    @Test
    public void yanlisEmailYanlisPasswordTesti(){

        qualitydemyPage = new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(4);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        ReusableMethods.wait(1);
        Driver.closeDriver();
    }

}

