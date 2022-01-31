package tests.day14;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {


    @Test
    public  void test() throws InterruptedException {
        // "https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[.='Allow All Cookies']")).click();
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[.='Create new account']")).click();
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        WebElement nameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(nameBox).click().sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys("Feb").sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("1991").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement male=driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(male.isSelected());
        WebElement female=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(female.isSelected());
        //Sayfayi kapatin

    }
}
