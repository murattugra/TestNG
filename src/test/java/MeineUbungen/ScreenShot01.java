package MeineUbungen;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class ScreenShot01 extends TestBase {


    @Test
    public void test() throws IOException {

        //Yeni bir class olusturun : amazonNutellaSearch
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

        TakesScreenshot ts=(TakesScreenshot) driver;
        File tumSayfa=new File("target/screenShot/tumSayfa.png");
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
        //3- Nutella icin arama yapin
        WebElement seacrhBox=driver.findElement(By.id("twotabsearchtextbox"));
      seacrhBox.sendKeys("Nutella"+Keys.ENTER);
        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
WebElement sonucYAzisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File sonucYazisiss=new File("target/screenShot/nutellaSonucYAzisi.png");
        File geciciSS=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciSS,sonucYazisiss);



    }




}
