package tests.day09.HomeWork;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {


    @Test
    public void test01() {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN);
        //3."Login Portal" a tiklayin
        String ilkSayfaHandle = driver.getWindowHandle();
    //    System.out.println(ilkSayfaHandle);
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        Set<String> alleHAndles = driver.getWindowHandles();
        String ikinciHandle = "";
        for (String each : alleHAndles
        ) {
            if (!each.equals(ilkSayfaHandle)) {
                ikinciHandle = each;
            }
            for (String e:alleHAndles
                 ) {
                System.out.println(e);
            }
          //  System.out.println(ikinciHandle);
          driver.switchTo().window(ikinciHandle);

            //5."username" ve "password" kutularina deger yazdirin
            Faker faker = new Faker();
            driver.findElement(By.xpath("//input[@id='text']")).click();
            Actions actions = new Actions(driver);
            actions.sendKeys(faker.name().firstName()).perform();
            //6."login" butonuna basin
            //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
            //8.Ok diyerek Popup'i kapatin
            //9.Ilk sayfaya geri donun
            //10.Ilk sayfaya donuldugunu test edin


        }
    }
}
