package tests.day15_SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifLoginTesti {

    @Test(groups = {"smoke"})
    public void test01(){

        // 1- https://www.qualitydemy.com/ sayfasına gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // 2- login linkine tıklayın
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // 3- Kullanıcı email'i olarak valid email girin
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");

        // 4- Kullanıcı şifresi olarak valid şifre girin
        qualitydemyPage.passwordKutusu.sendKeys("31488081");

        qualitydemyPage.cookie.click();
        ReusableMethods.wait(3);

        // 5- Login butonuna basarak login olun.
        qualitydemyPage.loginButonu.click();

        // 6- Başarılı olarak giriş yapılabildiğini kontrol edin.
        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());


        Driver.closeDriver();


    }
}
