package MeineUbungen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class KendiCalismam01 {

    // 1) Tarayıcıyı açın




    //9) Hindistan için vergi oranı diğer ülkelere göre değişmektedir.
    //10) Vergi oranı Hintliler için %2, yurt dışı için %5 olmalıdır.

    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        softAssert=new SoftAssert();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }
    //2) “http://practice.automationtesting.in/” URL'sini girin
    //3) Mağaza Menüsüne tıklayın

    @Test(priority = 1)
    public void adreseGidisTesti(){
        driver.get("http://practice.automationtesting.in");
        driver.findElement(By.xpath("//a[text()='Shop']")).click();
    }

    //4) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın.
    //5) Kullanıcı o Kitabı Menü öğesinde fiyat ile görüntüleyebilir.
    @Test(priority = 2)
    public void basketTest(){
    driver.findElement(By.xpath("//a[@data-product_id='170']")).click();
    String expecedPreis=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[3]")).getText();
    String actualPreisImBasket=driver.findElement(By.xpath("//span[@class='amount']")).getText();
    softAssert.assertEquals(actualPreisImBasket,expecedPreis,"Preis Vergleihung Failed");

    }

    //6) Şimdi, kontrol sayfasına geçmek için gezinen Öğe bağlantısına tıklayın.
    //7) Artık kullanıcı, Ödemeye Devam Et düğmesinin hemen üzerindeki toplam ve ara toplam değerlerini bulabilir.
    @Test(priority = 3)
    public void basketControlTest(){
    driver.findElement(By.xpath("//a[@title='View your shopping cart']")).click();
    boolean subTotal=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[3]")).isDisplayed();
    boolean total=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[5]")).isDisplayed();

    softAssert.assertTrue(subTotal);
    softAssert.assertTrue(total);
        //8) Toplam her zaman < ara toplam, çünkü vergiler ara toplama eklenir
        String steuerElement=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[4]")).getText();
        String subTotalElement=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[3]")).getText();
        String totalElement=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[5]")).getText();
        steuerElement=steuerElement.replace("₹","");
        subTotalElement=subTotalElement.replace("₹","");
        totalElement=totalElement.replace("₹","");

        double steuerElementDouble=Double.parseDouble(steuerElement);
        double subTotalDouble=Double.parseDouble(subTotalElement);
        double totalElementDouble=Double.parseDouble(totalElement);

       boolean toplamSaglama=(steuerElementDouble+subTotalDouble==totalElementDouble);
        softAssert.assertTrue(toplamSaglama);
    }

    @AfterClass
public  void treaDown(){
      driver.close();

}

}
