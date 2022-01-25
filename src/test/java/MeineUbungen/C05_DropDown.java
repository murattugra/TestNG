package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DropDown {




    WebDriver driver;

@BeforeClass
public  void setup(){
    WebDriverManager.chromedriver().setup();
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



}
    @Test
public void test01(){
        // 1. http://zero.webappsecurity.com/ Adresine gidin
    driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
driver.findElement(By.className("icon-signin")).click();
        //3. Login kutusuna "username" yazin
driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password kutusuna "password." yazin
driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        //6. Pay Bills sayfasina gidin
driver.findElement(By.xpath("//button[@id='details-button']")).click();
driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
driver.findElement(By.linkText("Pay Bills")).click();

        //7. "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. "Currency" drop down menusunden Eurozone'u secin
        WebElement currentyDropDownElement= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(currentyDropDownElement);
        select.selectByValue("EUR");
        //9. "amount" kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("5");
        //10. "US Dollars" in secilmedigini test edin
        WebElement usDollarElement=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollarElement.isSelected());
        //11. "Selected currency" butonunu secin
   driver.findElement(By.id("pc_inDollars_false")).click();
        //12. "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. "Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin.
WebElement alert=driver.findElement(By.id("alert_content"));
Assert.assertTrue(alert.isDisplayed());
}





}
