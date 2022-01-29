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
        driver.findElement(By.xpath("//button[.='Allow All Cookies']")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[.='Create new account']")).click();
       //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement nameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);

        actions.click(nameBox).click().sendKeys("Murat").sendKeys(Keys.TAB).sendKeys("TUGRA").sendKeys(Keys.TAB)
                .sendKeys("mrt@gmail.com").sendKeys(Keys.TAB).sendKeys("bnmc123-").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Feb").sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("1991").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //4- Kaydol tusuna basalim


    }
}
