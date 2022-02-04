package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q10 extends TestBase {

    //twitter a faker class kullanarak kayit olmaya calisiniz

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://twitter.com/");
        driver.findElement(By.xpath("(//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0'])[2]")).click();

        Faker faker=new Faker();
        driver.findElement(By.xpath("//span[.='Use email instead']")).click();
        WebElement isimElement=driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[1]"));
        WebElement emailElement=driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));

        isimElement.sendKeys(faker.name().name());
        emailElement.sendKeys(faker.internet().emailAddress());


        WebElement next=driver.findElement(By.xpath("(//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0'])[2]"));
        //Ay girin
        WebElement ayElement=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
        Select selectAy=new Select(ayElement);
        selectAy.selectByIndex(faker.random().nextInt(1,12));
        //gun girin
        WebElement gunElement=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        Select selectGun=new Select(gunElement);
        selectGun.selectByIndex(faker.random().nextInt(1,30));
        //yıl girin
        WebElement yilElement=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
        Select selectYil=new Select(yilElement);
        selectYil.selectByIndex(faker.random().nextInt(20,90));
        driver.findElement(By.xpath("(//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0'])[2]")).click();
         WebElement sendCodeelement=driver.findElement(By.xpath("//span[.='We sent you a code']"));
        Assert.assertTrue(sendCodeelement.isDisplayed());


    }






}
