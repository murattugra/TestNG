package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HepsiBurada2 {


    SoftAssert softAssert;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }



    @Test
    public void bb(){
        //1. “https://www.hepsiburada.com/” Adresine gidin
        //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        driver.get("https://www.hepsiburada.com/");
        String actualTitle=driver.getTitle();
        String expectedReult="Turkiye’nin En Buyuk Alisveris Sitesi";
        softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedReult),"Title dogrulamasi yanlis");

    }

    @Test (dependsOnMethods ="bb" )
    public void  aaTest(){
        //3. search kutusuna araba yazip arattirin
          WebElement search=  driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']"));
          search.sendKeys("araba");
        //4. bulunan sonuc sayisini yazdirin
        System.out.println( "Bulunan sonuç sayısı: "
                + driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']")).getText() );

        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String actualSonuc=driver.findElement(By.xpath("//h1[@class='searchResultSummaryBar-bold']")).getText();
        String expectedResult="araba";
        softAssert.assertTrue(actualSonuc.contains(expectedResult),"araba yazisi icermiyor");
        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String expectedResul2="oto";
        softAssert.assertFalse(actualSonuc.contains(expectedResul2),"oto yazisi iceriyor");


        softAssert.assertAll();


    }


@AfterClass
    public void treaDown(){

        driver.close();


    }
}
