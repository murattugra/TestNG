package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IframeTest {

    //● Bir class olusturun: IframeTest



    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @Test
    public void iframeTest(){

        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/iframe");

        //   ● Bir metod olusturun: iframeTest

        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu
        //        test edin ve  konsolda    yazdirin.
        WebElement istenilenYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(istenilenYaziElementi.isEnabled());
        System.out.println(istenilenYaziElementi.getText());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.


        //yazi yazmak istedigimiz iframe in icnde oldugundan direk ulasamiyoruz
        //once iframe yi locate edip onun icine switch yapmaliyiz
        WebElement iFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);


        WebElement textBoxElement=driver.findElement(By.tagName("p"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini
        // Yukarida iFramenin icine switch yaptigimizdan yeniden disari cikmak istedigimizde
        // ana sayfaya donmeliyiz

        driver.switchTo().defaultContent();
        // driver.switchTo().parentFrame(); burada buda olur cunku bir tane iFramenin icine \
        // girdik bir ustte donunce en basa donmus olur

        WebElement elemenSeleniumELment=driver.findElement(By.linkText("Elemental Selenium"));
        elemenSeleniumELment.click();


        //        textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

        // Elemental Selenium yazisi yeni sayfada oldugundan
        // ve drive reski sayfada kaldigindan
        // o yuzden locate edemedik
        WebElement textSon=driver.findElement(By.tagName("h1"));

        softAssert.assertTrue(textSon.isDisplayed());



        softAssert.assertAll();




    }


    @AfterClass
    public void treaDown(){



    }

}
