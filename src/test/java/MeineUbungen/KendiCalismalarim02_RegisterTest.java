package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class KendiCalismalarim02_RegisterTest {


    // 1) Open the browser




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
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
    driver.get("http://practice.automationtesting.in/");
    driver.findElement(By.linkText("My Account")).click();

    }

    @Test
    public void test02(){
        //4) Enter empty Email Address in Email-Address textbox
        //5) Enter empty password in password textbox
        //6) Click on Register button
        //7) Registration must fail with a warning message(Please provide valid email address)

        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("");
        driver.findElement(By.xpath("(//input[@class='woocommerce-Button button'])[2]")).click();

        String actualErorMessage=driver.findElement(By.xpath(" //li[text()=' Please provide a valid email address.']")).getText();
        String expectedResul="Error: Please provide a valid email address.";

        Assert.assertEquals(actualErorMessage,expectedResul);

    }




    @AfterClass
    public void treaDown(){
 driver.close();


    }


}
