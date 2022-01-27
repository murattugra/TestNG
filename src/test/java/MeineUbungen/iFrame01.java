package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class iFrame01 {


    // ● Bir class olusturun: IframeTest02
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz


WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iFrame);
        //driver.findElement(By.xpath("(//button[@id='save']")).click();
        driver.findElement(By.id("save")).click();
    }



    @Test
    public void test(){
//2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=driver.findElements(By.tagName("iframe"));
        System.out.println("iframeList sayisi= " + iframeList.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.findElement(By.tagName("iframe")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız

    }






    @AfterClass
    public void tearDown(){


    }


}
