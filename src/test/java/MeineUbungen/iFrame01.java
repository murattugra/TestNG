package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void youtubeFrame(){
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> frameSize= driver.findElements(By.tagName("iframe"));
        System.out.println("IFrame sum: " + frameSize.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.  // Test sırası youtube videosu bozuk, gitmedi.!
        WebElement firstFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(firstFrame);
        // firstFrame.click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement secondFrame=driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(secondFrame);
        WebElement link = driver.findElement(By.tagName("a"));  // With .click() method u can run but
        link.click();                                            // ı want to see that is enabled or disabled..
        Assert.assertTrue(link.isEnabled() , "Link is DİSABLED");
    }                  // click mehodu ile tek satırda da siteye gidilebilir 5.görevde ancak ben
    // kodun çalıştıgını görmek için uzattım
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}