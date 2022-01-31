package MeineUbungen;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class GenelTekrarTesti extends TestBase {

    Select select;
    WebElement dropDown;
  List<WebElement> dropDownlist;
   WebElement searchBox;
    String urunFiyat1;
    String urunTitle1;
    String urunTitle2;
    String urunFiyat2;
    @BeforeMethod
    public void setup01(){

        driver.get("https://www.amazon.com");
        dropDown=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        select=new Select(dropDown);
        dropDownlist=select.getOptions();
        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    }

    @Test
    public void test01(){
        // amazona gidin
        // Arama kutusunun solundaki dropdosn menuyu handle edip listesini ekrana yazdirin
        for (WebElement each: dropDownlist
             ) {
            System.out.println(each.getText());
        }
        // dropdown menusunde 40 eleman oldugunu dogrulayiniz
        int dropDownSayisi=dropDownlist.size();
        System.out.println(dropDownSayisi);
        Assert.assertTrue(dropDownSayisi==40);

    }

    @Test
    public void test02() throws InterruptedException {
        // dropdown menusunde elektronik bolumunu secin
        select.selectByValue("search-alias=electronics-intl-ship");
        // arama kutusuna iphone yazip aratin ve bulunan sonuc sayisini yazdirin
        searchBox.sendKeys("iphone"+ Keys.ENTER);
        String sonucSayisiYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String sayiBulma=sonucSayisiYazisi.substring(7,sonucSayisiYazisi.length()-1);
        System.out.println(sayiBulma);
        String sayiBulma2=sayiBulma.replaceAll("\\D","");
        System.out.println("Sonuc Sayisi : "+sayiBulma2);
        int sonucSayisi=Integer.parseInt(sayiBulma2);
        System.out.println("Sonuc Sayisi int olarak :"+sonucSayisi);
        //sonuc sayisinin yazisinin iphone icerdigini test edin
        Assert.assertTrue(sonucSayisiYazisi.contains("iphone"));
        //ikinci urune relative locater kullanarak tiklayin
        WebElement birinciUrun=driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement ucuncuUrun=driver.findElement(By.xpath("//img[@data-image-index='3']"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.className("s-image")).below(birinciUrun).above(ucuncuUrun));
        ikinciUrun.click();
        //urunun title 'si ve fiyatini variable'a assign edip urunu sepete ekleyelim
        urunFiyat1=driver.findElement(By.xpath("//span[@class='a-offscreen']")).getText();
        urunTitle1=driver.findElement(By.id("productTitle")).getText();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-button")).click();


    }

    @Test
    public void test03(){
        //yeni bir sekme acarak amazon anasayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //dropdown'dan bebek bolumunu secin
       dropDown=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
       Select select=new Select(dropDown);
        select.selectByValue("search-alias=baby-products-intl-ship");
        //bebek puset aratip bulunan sonuc sayisini yazdirin
        // ve puset icerdigini test edin
        WebElement searchBox= searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset"+Keys.ENTER);
        String sonucYazisiStr=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
        String arananKeleime="puset";
        Assert.assertTrue(sonucYazisiStr.contains(arananKeleime));
        String sonucSasiyi=sonucYazisiStr.replaceAll("\\D","");
        System.out.println(sonucSasiyi);
        //ucuncu urune relative locater kullanarak tiklayin
        WebElement ikinciUrun=driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement dorduncuUrun=driver.findElement(By.xpath("//img[@data-image-index='4']"));
        WebElement ucuncuUrun=driver.findElement(RelativeLocator.with(By.className("s-image")).above(dorduncuUrun)
                .below(ikinciUrun));
        ucuncuUrun.click();
        urunTitle2=driver.findElement(By.id("productTitle")).getText();
        urunFiyat2=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[3]")).getText();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
     //   driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();


    }
    @Test
    public void test04(){
//sepete ekledigimiz urunlerin ekledigimiz urunlerle ayni oldugunu title ve fiyat olarak dgrulatin
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        String sepetIlkUruntitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();
        String sepetIkinciUruntitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();

        String sepetIlkUrunFiyat=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).getText();
        String sepetIkinciUrunFiyat=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")).getText();

        Assert.assertEquals(urunFiyat1,sepetIlkUrunFiyat);
        Assert.assertEquals(urunTitle1,sepetIlkUruntitle);
        Assert.assertEquals(urunFiyat2,sepetIkinciUrunFiyat);
        Assert.assertEquals(urunTitle2,sepetIkinciUruntitle);



    }




}
