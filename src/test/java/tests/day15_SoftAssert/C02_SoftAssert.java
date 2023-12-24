package tests.day15_SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {

    @Test(groups = {"minireg1","minireg2"})
    public void test01(){

        // 1. "https://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basın
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();

        // 3. Login kutusuna "username" yazın
        zeroWebAppPage.usernameKutusu.sendKeys("username");

        // 4. Password kutusuna "password" yazın
        zeroWebAppPage.passwordKutusu.sendKeys("password");

        // 5. Sign in tuşuna basın
        zeroWebAppPage.signInSubmitButonu.click();

        // 6. Online banking menüsü içinde Pay Bills sayfasına gidin
        Driver.getDriver().navigate().back();
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBillLinki.click();

        // 7. "Purchase Foreign Currency" tuşuna basın
        zeroWebAppPage.purchaseFCButonu.click();

        // 8. "Currency" drop down menüsünden Eurozone'u seçin
        Select select = new Select(zeroWebAppPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" seçildiğini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualDropDownSecim = select.getFirstSelectedOption().getText();
        String expectedDropDownSecim = "Eurozone (euro)";

        softAssert.assertEquals(actualDropDownSecim,expectedDropDownSecim,"eurozone seçimi testi failed");

        // 10. soft assert kullanarak DropDown listesinin şu seçenekleri olduğunu test edin ******
        // "Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
        // "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)",
        // Mexico (peso)", "Norway (krone), "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)",
        // "Thailand (baht)"

        List<WebElement> optionsElementListesi = select.getOptions();
        List<String> actualOptionsListesiStr = new ArrayList<>();

        for (WebElement each: optionsElementListesi
             ) {
            actualOptionsListesiStr.add(each.getText());
        }

        String[] arr = {"Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)",
                "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)",
                "Thailand (baht)"};
        List<String> expectedOptionsListesi = Arrays.asList(arr);

        Collections.sort(actualOptionsListesiStr);
        Collections.sort(expectedOptionsListesi);

        softAssert.assertEquals(actualOptionsListesiStr,expectedOptionsListesi);

        ReusableMethods.wait(3);
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
