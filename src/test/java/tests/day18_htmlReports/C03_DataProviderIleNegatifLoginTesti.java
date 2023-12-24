package tests.day18_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderIleNegatifLoginTesti {


    // qualitydemy ana sayfaya gidin
    // verilen yanlış kullanıcı adı ve password kombinasyonları için
    // giriş yapılamadığını test edin.
    // username    password
    // A11         A12345
    // B12         B12345
    // C13         C12345
    // D14         D12345
    // E15         E12345


    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArr =
                {{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};

        return kullaniciBilgileriArr;


    }


    @Test(dataProvider = "kullaniciBilgileri")
    public void negatifLoginTest(String username, String password) {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        if(qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
            ReusableMethods.wait(3);
        }

        qualitydemyPage.loginButonu.click();


        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


    }


}
