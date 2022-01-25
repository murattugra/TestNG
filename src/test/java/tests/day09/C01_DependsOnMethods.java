package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {

    // ● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.





    WebDriver driver;

@BeforeClass
    public void setup(){

    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @Test
    public void logoTest(){
        //    1. Test : Amazon ana sayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }


    @Test(dependsOnMethods = "logoTest")// Bunu yazarak calisma bu testi logoTest e bagliyoruz
                                        // once logo tst calisir eger hta olursa ilk teste bu testi ignor eder ve zaman kazniriz
                                        // Tek bu testi calistirmak istersek te yine once logo testi calistirir sonra bunu
    public  void aramaTest(){
        //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //    arama yapin ve aramanizin gerceklestigini Test edin
    WebElement aramakUtusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramakUtusu.sendKeys("Nutella"+ Keys.ENTER);
    String actualTitle=driver.getTitle();
    String arananKelime="Nutella";

    Assert.assertTrue(actualTitle.contains(arananKelime));


    }


@Test(dependsOnMethods = "aramaTest")
    public void fiyatTesti(){
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $14.99 oldugunu test edin
    driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).click();
        WebElement fiyatElement=driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        String actualFiyat=fiyatElement.getText();
        String expectedResult="$14.99";
        Assert.assertEquals(actualFiyat,expectedResult);


}


    @AfterClass
    public void treaDown(){

driver.close();
    }


}
