package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Iframe extends TestBase {



    @Test
    public void test01() throws InterruptedException {

        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("Our Products")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
        //4. Popup mesajini yazdirin
        Thread.sleep(3000);
        WebElement yazi=driver.findElement(By.xpath("//div[@class='modal-body']"));
        String yaziTextStr=yazi.getText();
        System.out.println(yaziTextStr);
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[.='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        // tek iframe girildiyse driver.switchTo().parentFrame();   buda olur
        driver.findElement(By.id("nav-title")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(actualUrl,expectedUrl, "URL TEST failed");



    }

}
