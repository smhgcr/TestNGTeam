package tests.day15_SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegatifLoginTesti {

    // 3 test methodu olusturun
    // 1.de yanlıs email, dogru sifre
    // 2.de dogru email, yanlis sifre
    // 3. de yanlış email, yanlış şifre ile giriş yapmayı deneyin
    // giriş yapılamadığını test edin.

    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("semih@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("31488081");

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(3);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void yanlisPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(3);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisEmailYanlisPasswordTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@semih.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(3);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }

}
