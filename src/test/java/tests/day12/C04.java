package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C04 extends TestBase {

 // Yeni bir class olusturalim: MouseActions2



    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[.='Drag me']"));
        WebElement tasinacakHedefElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacakElement,tasinacakHedefElement).perform();//bu sekilde tasinacak elementi tasidik
        //dranAndDrop=> sürükle ve bırak demek
        Thread.sleep(7000);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropYazisi=tasinacakHedefElement.getText();
        String expectedDroppedYazisi="Dropped!";
        Assert.assertEquals(actualDropYazisi,expectedDroppedYazisi);

    }
}