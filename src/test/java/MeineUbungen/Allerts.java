package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Allerts {

    // https://the-internet.herokuapp.com/javascript_alerts sitesine gidiniz
    //● Bir metod olusturun: acceptAlert





    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert=new SoftAssert();


    }
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert

    @Test
    public void test01(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="You successfully clicked an alert";
        softAssert.assertEquals(actualResult,expectedResult,"Beklenen sonuc dogrulanamadi ");


    }
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
   @Test
    public void test02(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected="successfuly";
        softAssert.assertFalse(actualResult.contains(expected),"succesfuly icerir");

    }

    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void test03() throws InterruptedException {
    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    driver.switchTo().alert().sendKeys("Murat");
    driver.switchTo().alert().accept();
    WebElement actualResultElement=driver.findElement(By.xpath("//p[@id='result']"));
    String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
    String expectedResult="Murat";
    softAssert.assertTrue(actualResult.contains(expectedResult));
    softAssert.assertTrue(actualResultElement.isDisplayed());



    }





    @AfterClass
    public void tearDown(){
    softAssert.assertAll();
    driver.close();
    }




}
