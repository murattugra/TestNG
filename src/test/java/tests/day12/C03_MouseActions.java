package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C03_MouseActions extends TestBase {

@Test
    public void test01(){
//2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");
    WebElement kutuElement=driver.findElement(By.id("hot-spot"));
    //3- Cizili alan uzerinde sag click yapalim
         Actions actions=new Actions(driver);
         actions.moveToElement(kutuElement).perform();
         actions.contextClick(kutuElement).perform();

    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //    test edelim.
    String allertStr=  driver.switchTo().alert().getText();
    Assert.assertEquals(allertStr,"You selected a context menu");
    //5- Tamam diyerek alert’I kapatalim
    driver.switchTo().alert().accept();
    //6- Elemental Selenium linkine tiklayalim
    String ilkSayfaHanlde=driver.getWindowHandle();
    driver.findElement(By.linkText("Elemental Selenium")).click();
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    Set<String> handles=driver.getWindowHandles();
    String ikincisayfaHandle = "";
    for (String each: handles
         ) {
        if (!(each.equals(ilkSayfaHanlde))){
            ikincisayfaHandle=each;
        }
    }

        driver.switchTo().window(ikincisayfaHandle);
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Elemental Selenium");



}

}
