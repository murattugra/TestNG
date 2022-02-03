package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q7 extends TestBase {


    @Test
    public void test01(){
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. CLICK ME of JavaScript Alert e tıklayın
        driver.findElement(By.id("button1")).click();
        // 3. pop up text i alın
        String popText=driver.switchTo().alert().getText();

        // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
        SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals(popText,"I am an alert box!");
        // 5. pop up i kabul edin
        driver.switchTo().alert().accept();
        softAssert.assertAll();

    }


    @Test(dependsOnMethods = "test01")
    public void test02(){
        // Yine ayni class da baska test methodu olusturun
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
        driver.findElement(By.xpath("//span[@id='button4']")).click();
        // 3.  pop up text i alın
          Alert alert=driver.switchTo().alert();// bu sekildede kullanimi mevcut
        String popText=alert.getText();  // buda meccut  bircok alert islemi varsa mantikli

       // String popText=driver.switchTo().alert().getText();
        // 4. Mesajın "Press a button!" olduğunu doğrulayın
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(popText,"Press a button!");
        // 5. Açılır pencereyi kapat
              // 6. pop up i iptal edin,
        driver.switchTo().alert().dismiss();
        // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
        WebElement yaziElment=driver.findElement(By.xpath("//p[@id='confirm-alert-text']"));
        softAssert.assertTrue(yaziElment.isDisplayed());
        // 8. alert1'e göre dependsOnMethods kullanın
        softAssert.assertAll();


    }

/*
Alert alert = driver.switchTo().alert();  //bu sekilde de kullanimi mevcuttur
driver.switchTo().alert();     yerine    Alert data turundeki alert variable ini kullandik.
alert variable ile methodlara ulasilabilir
    alert.dismiss();
    alert.accept();  vb
    bu kullanim sayesinde switchto() yazmamiza gerek kalmaz
 */

}
