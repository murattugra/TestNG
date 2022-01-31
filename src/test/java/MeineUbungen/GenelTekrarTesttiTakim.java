package MeineUbungen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class GenelTekrarTesttiTakim extends TestBase {


    Select select;
    WebElement dropDownElement;
    WebElement searchBox;
    String urun2Title;
    String urun2Fiyat;
    String urunTitle1;
    String urun1Fiyat;
    @BeforeMethod
    public void setup01(){
        // amazona gidin
       driver.get("https://www.amazon.com");
        // Arama kutusunun solundaki dropdon menuyu handle edip listesini ekrana yazdirin
        WebElement dropDownElement=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropDownElement);
        searchBox=driver.findElement(By.id("twotabsearchtextbox"));
    }


    @Test
    public void test01(){

       List<WebElement> dropDownListesi= select.getOptions();
       dropDownListesi.stream().forEach(t-> System.out.println(t.getText()));
       // dropdown menusunde 40 eleman oldugunu dogrulayiniz
        Assert.assertTrue(dropDownListesi.size()==40);




    }

    @Test
    public  void test02(){
        //dorpdown menusunden elektronik bolumunu secin
        select.selectByValue("search-alias=electronics-intl-ship");
        //arama kutusunda iphone yazip arattirin bulunan sonuc sayisini yazdirin
        searchBox.sendKeys("iphone"+ Keys.ENTER);
        String sonucYazisiStr=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        //1-12 of 859 results for
        String arr[]=sonucYazisiStr.split(" ");
        System.out.println(arr[2]);

        // sonuc yazisi nin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisiStr.contains("iphone"));
        //ikinci urune Relativ locator kullanarak locate edin
        WebElement birinciUrun= driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement ucuncuUrun= driver.findElement(By.xpath("//img[@data-image-index='3']"));
        WebElement ikiciUrun=driver.findElement(RelativeLocator.with(By.className("s-image")).below(birinciUrun).above(ucuncuUrun));
        ikiciUrun.click();
        //urunbun title ve fiyatini assign edip sepete ekleyelim
         urunTitle1=driver.getTitle();
       urun1Fiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();


    }
    @Test
    public void test03(){
        // yeni bir sekme acarak amazon sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //dropdown dan bebek bolumunu secin
        WebElement dropDownElement=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropDownElement);
        select.selectByValue("search-alias=baby-products-intl-ship");
        //bebek puset aratip bulunan sonuc sayisini yazdirin
        searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Stroller"+Keys.ENTER);
        String sonucSayisi2Str=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String arr1[]=sonucSayisi2Str.split(" ");
        System.out.println(arr1[3]);
        //sonuc azisinin Stroller icerdigini test edin
        Assert.assertTrue(sonucSayisi2Str.contains("Stroller"));
        //ucuncu urune Relative locter kullanarak tiklayin
        WebElement ikinciUrun=driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement dorduncuUrun=driver.findElement(By.xpath("//img[@data-image-index='4']"));
        WebElement ucuncuUrun=driver.findElement(RelativeLocator.with(By.className("s-image")).below(ikinciUrun).above(dorduncuUrun));
        ucuncuUrun.click();
        //urunbun title ve fiyatini assign edip sepete ekleyelim
         urun2Title=driver.getTitle();
       urun2Fiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();



    }

    @Test
    public void test04(){
        //sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        String sepet1UrunTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();
        String sepet2UrunTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();

        String sepet1UrunFiyat=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).getText();
        String sepet2UrunFiyat=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")).getText();


        Assert.assertEquals(sepet1UrunFiyat,urun1Fiyat);
        Assert.assertEquals(sepet1UrunTitle,urunTitle1);
        Assert.assertEquals(sepet2UrunFiyat,urun2Fiyat);
        Assert.assertEquals(sepet2UrunTitle,urun2Title);

    }

}
