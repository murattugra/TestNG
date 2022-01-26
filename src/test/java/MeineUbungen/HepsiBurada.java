package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HepsiBurada {


    // Yeni bir Class Olusturun : D11_SoftAssert1



    WebDriver driver;

@BeforeMethod
     public void setup(){
    WebDriverManager.chromedriver().setup();
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


     }

     @Test
     public void test01(){
         //1. “   https://www.hepsiburada.com/” Adresine gidin
         driver.get("https://www.hepsiburada.com/");
         //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
         SoftAssert softAssert=new SoftAssert();
         String actualTitle= driver.getTitle();
         String expectedResult="Turkiye’nin En Buyuk Alisveris Sitesi";
         softAssert.assertTrue(actualTitle.contains(expectedResult),"Title dogrulamasi failed");

         //3. search kutusuna araba yazip arattirin
         driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);
         //4. bulunan sonuc sayisini yazdirin
         String sonucSayisi=driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']")).getText();
         System.out.println("sonucSayisi = " + sonucSayisi);
         //5. sonuc yazisinin "araba" icerdigini dogrulayin
         String sonucSayisiYazisi=driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']")).getText();
         String expectedResul2="araba";
         softAssert.assertTrue(sonucSayisiYazisi.contains(expectedResul2),"araba yazisi dogrulamasi failed");
         //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayi
         softAssert.assertTrue(sonucSayisiYazisi.contains("oto"),"Oto yazisi dogrulamasi failed");

         softAssert.assertAll();


     }



     @AfterMethod
     public void treaDown(){


     }


}
