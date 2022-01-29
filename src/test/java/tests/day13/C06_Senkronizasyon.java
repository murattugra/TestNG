package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {




    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        WebElement enableElement=driver.findElement(By.xpath("(//p)[2]/"));
        Thread.sleep(3000);
        Assert.assertTrue(enableElement.isDisplayed());



    }


}
