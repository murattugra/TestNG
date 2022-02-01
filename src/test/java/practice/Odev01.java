package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Odev01  {

  //  soru :ingilizce
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
//click on action dialog button
    //if need use explicitly wait
//click on the ok button
//accept the iframe message
 WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void test01(){
        //1.soru :Turkce
        //web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        // pencereyi büyüt
        driver.manage().window().maximize();
        // eylem diyalog düğmesine tıklayın
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='action']"))).click();
        // kullanmanız gerekiyorsa açıkça bekleyin
        // tamam butonuna tıklayın
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dialog-mycodemyway-action']"))).click();
        // iframe mesajını kabul et
        driver.switchTo().alert().accept();


    }


}
