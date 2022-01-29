package MeineUbungen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;



    //1- Bir Class olusturalim KeyboardActions2
    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin
    public class KeyboardActions02 extends TestBase {


        @Test
        public void test(){

            //2- https://html.com/tags/iframe/ sayfasina gidelim
            driver.get("https://html.com/tags/iframe/");
            //3- video’yu gorecek kadar asagi inin
            Actions actions=new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            //4- videoyu izlemek icin Play tusuna basin
            WebElement youtubeIframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
            driver.switchTo().frame(youtubeIframe);
            WebElement clickYeri=driver.findElement(By.xpath("//a[@class='ytp-title-channel-logo']"));
            WebElement ikinciYer=driver.findElement(By.xpath("//div[@class='ytp-watch-later-icon']"));
            actions.dragAndDrop(clickYeri,ikinciYer);
            actions.sendKeys(Keys.TAB).
                    sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
            //5- videoyu calistirdiginizi test edin
            WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Pause (k)']"));
            Assert.assertTrue(pauseButton.isEnabled());



        }

    }





