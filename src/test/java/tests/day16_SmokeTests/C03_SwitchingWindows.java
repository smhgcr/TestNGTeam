package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/iframe adresine git
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkine tıklayın
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        // title'i "Elemental Selenium | Elemental Selenium" olan yeni window'a geçiş yapın
        ReusableMethods.switchToWindow("Elemental Selenium | Elemental Selenium");

        // ve sayfa üzerinde h1 tag'ında "Make sure your code lands" yazısı olduğunu test edin.
        String expectedYazi="Make sure your code lands";
        String actualYazi = Driver.getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualYazi,expectedYazi);


        Driver.quitDriver();


    }
}
