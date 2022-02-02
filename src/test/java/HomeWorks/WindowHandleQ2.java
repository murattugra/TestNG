package HomeWorks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandleQ2 {
    // 1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
        System.out.println("TEST SUCCESSFUL!");
    }


    @Test
    public void windowHandleTest(){

        driver.get("http://webdriveruniversity.com/");
        String whnumber=driver.getWindowHandle();

        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();

        Set<String> whnumberAll=driver.getWindowHandles();
        String whnumberNew = "";
        for (String e:whnumberAll) {
            if (!(e.equals(whnumber))) {
                whnumberNew=e;
            }
        }

        driver.switchTo().window(whnumberNew);

        Faker faker=new Faker();

        WebElement user=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        action.click(user).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        String actualText=driver.switchTo().alert().getText();
        Assert.assertTrue(actualText.equals("validation failed") );

        driver.switchTo().alert().accept();

        driver.switchTo().window(whnumber);

        Assert.assertEquals(driver.getWindowHandle() , whnumber);

    }
}