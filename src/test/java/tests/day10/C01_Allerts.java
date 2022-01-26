package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {


    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.



    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }

    @Test
    public void accepAlertTesti(){
        //● Bir metod olusturun: acceptAlert
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        //        “You successfully clicked an alert” oldugunu test edin.
   String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
   String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void dissmisAllertTesti(){

        //● Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

        //        “successfuly” icermedigini test edin.
    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    driver.switchTo().alert().dismiss();
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult));



    }
    @Test
    public void sendKeyAllet() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Murat");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="Murat";
        Assert.assertTrue(actualResult.contains(expectedResult));


    }


    @AfterClass
    public  void tearDown(){

            driver.close();


    }



}
