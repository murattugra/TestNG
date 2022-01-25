package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_HomeWork06 {



    WebDriver driver;
@BeforeMethod
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



}
@Test
public  void  test01(){
    //● https://the-internet.herokuapp.com/windows adresine gidin.
   driver.get("https://the-internet.herokuapp.com/windows");

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    String actualtextStr1=driver.findElement(By.tagName("h3")).getText();
    String expectedResult1="Opening a new window";
    Assert.assertEquals(actualtextStr1,expectedResult1);

    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String actualTitle1=driver.getTitle();
    String expectedTitle1="The Internet";
    Assert.assertEquals(actualTitle1,expectedTitle1);



    //● Click Here butonuna basın.
    driver.findElement(By.linkText("Click Here")).click();

    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    String actualTitle2=driver.getTitle();
    String expectedTitle2="New Window";
    Assert.assertEquals(actualTitle2,expectedTitle2);

    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    String actualTextStr2=driver.findElement(By.tagName("h3")).getText();
    String expectedResult2="New Window";
    Assert.assertEquals(actualTextStr2,expectedResult2);

    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    //driver.navigate().
   // Assert.assertEquals(actualTitle1,expectedTitle1);





}




}
