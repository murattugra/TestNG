package MeineUbungen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class KeyboardBaseActions extends TestBase {


  // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test(){
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverButton=driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverButton);
        //3- Link 1" e tiklayin
        WebElement link1Button=driver.findElement(By.xpath("//a[.='Link 1']"));
        actions.click(link1Button).perform();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clicjkHoltButton=driver.findElement(By.xpath("//p[.='Click and Hold!']"));
        actions.clickAndHold(clicjkHoltButton).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElements(By.id("click-box")));
        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.tagName("h2"))).perform();

    }


}



