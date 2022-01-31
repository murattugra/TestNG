package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {

    // amazon anasayfaya gidin
    // sag ustte hello,signIn elementinin uzerinde mouse'u bekletin
    // acilan menude new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin


    @Test
    public void test01() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("https://www.amazon.com");
        WebElement helloElement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(helloElement).perform();


        driver.findElement(By.xpath("//span[.='Create a List']")).click();

        String actualTitle= driver.getTitle();
        String expectedTitle="Your List";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }



}
