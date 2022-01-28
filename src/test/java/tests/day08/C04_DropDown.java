package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {


    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    // - Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    WebElement dropDowselement;
    Select select;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");

    }


    @Test(priority = 1)
    public void kategoriSayisiTesti(){
        //-Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        dropDowselement=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropDowselement);
        List<WebElement> optionsList=select.getOptions();
        int actualOptionsCount=optionsList.size();
        int expectedOptionsCount=45;
        Assert.assertEquals(actualOptionsCount,expectedOptionsCount,"Options sayisi beklenen degerde degil");

    }

    @Test(priority = 2)
    public  void booksDropDownTest(){
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        select.selectByValue("search-alias=stripbooks-intl-ship");
        //    2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+Keys.ENTER);
        //    3. Bulunan sonuc sayisini yazdirin
        WebElement resultTextElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultTextElement.getText());
        //    4. Sonucun Java kelimesini icerdigini test edin
        String  actualResultTextString=resultTextElement.getText();
        String expectedResult="Java";
        Assert.assertTrue(actualResultTextString.contains(expectedResult));

    }


    @AfterClass
    public void treaDown(){
        driver.close();

    }

   }

