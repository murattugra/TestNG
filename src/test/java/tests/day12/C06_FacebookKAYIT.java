package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKAYIT extends TestBase {


    // Yeni bir class olusturalim: D15_MouseActions4



    @Test
    public void test(){
//1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.linkText("Create new account")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
       // WebElement isim= driver.findElement(By.id("u_3_b_SQ"));
        Actions actions=new Actions(driver);
        actions.sendKeys("Murat").sendKeys(Keys.TAB).sendKeys("Aslan").
                sendKeys(Keys.TAB).sendKeys("saaska").sendKeys(Keys.TAB).sendKeys("56789").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB);



        //4- Kaydol tusuna basalim


    }
}
