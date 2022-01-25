package tests.day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    WebElement dropdown;
    Select select;
    @BeforeClass
    public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");



        // - Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
    }
    @Test(priority = 1)
    public  void test01(){
        dropdown=driver.findElement(By.xpath("searchDropdownBox"));

       select=new Select(dropdown);

        List<WebElement> optionsList=select.getOptions();
        int expectedResult=45;
        int actualoptionsCount=optionsList.size();

        Assert.assertEquals(actualoptionsCount,expectedResult,"45 adet kategero yoktur");


    }
    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin


    @Test(priority = 2)
    public  void tets02(){
    dropdown=driver.findElement(By.xpath("searchDropdownBox"));
    select.selectByVisibleText("Books");
    WebElement seachBox = (WebElement) driver.findElements(By.id("twotabsearchtextbox"));
    seachBox.sendKeys("Java"+ Keys.ENTER);


}



}