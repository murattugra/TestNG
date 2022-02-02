package HomeWorks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class IframeQ2 extends TestBase {
    // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edi


    @Test
    public void iframe() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        WebElement frame=driver.findElement(By.xpath("//iframe[@id='frame']"));

        driver.switchTo().frame(frame);  // içerideyiz.
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        driver.findElement(By.xpath("//img[@id='camera-img']")).click();
        String text=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//button[text()='Close']")).click();
        driver.switchTo().defaultContent();
        // driver.switchTo().parentFrame();

        driver.findElement(By.id("nav-title")).click();

        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl, "URL test FAİLED,It doesnt match");

    }
}