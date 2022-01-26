package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork_Q7 {

    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    // https://www.n11.com/ SAYFASINA GiDİN.
    @Test(priority = 1)
    public  void n11Test(){
        driver.get("https://www.n11.com/");

    }
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    @Test(priority = 2)
    public  void gittigidiyorTest(){
    driver.navigate().to("https://www.gittigidiyor.com/");

    }
    // https://getir.com/ SAYFASINA GiDiN
    @Test(priority = 3)
    public  void getirTest(){
    driver.navigate().to("https://getir.com/");

    }
    // https://www.sahibinden.com/ SAYFASINA GiDiN
    @Test(priority = 4)
    public  void sahibindenTest(){
        driver.navigate().to("https://www.sahibinden.com/");

    }

    @AfterClass
    public void treaDown(){
        driver.close();


    }
}
