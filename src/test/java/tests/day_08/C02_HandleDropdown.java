package tests.day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {


    WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void dropdownTesti() throws InterruptedException {
        //Dropdown da var olan seceneklerden birini secmek icin
        //1. adim Dropdown webelemen tininlocate edip bir degiskene atiyoruz

        driver.get("https://www.amazon.com");

        WebElement dropdownElement=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2. adim Select class sindan bir obje olusturalim
        // ve  parametre olarak       webelementi yazalim

        Select select=new Select(dropdownElement);
        // ***********************
        //3. adim select objesini kullanara, select class indan var olan  3 secim method'undan
        //istedigimizi kullanarak dropdows da var olan option lardan birini secebiliriz
        //secim yapmamiza yardim eden bu 3 metot void dir dolayisiyla bize birsey dondurmezler
            select.selectByIndex(3);// option indexsi ile secme

        // eger sectigimiz option degerini yazdirmamk istersek *********
        System.out.println(select.getFirstSelectedOption().getText());// Baby verir
            //getFirstSelectedOption() methodu en son select edilen option u alir
            Thread.sleep(3000);
        select.selectByVisibleText("Deals");// option ismi ile secme

        select.selectByValue("search-alias=arts-crafts-intl-ship");// value ile secme

        List<WebElement> optionList=select.getOptions();// Tum option listesini getirip yazdirma

        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
        }




    }



    public  void treadown(){


        driver.close();
    }


}
