package MeineUbungen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class KendiTestCase extends TestBase {

    @BeforeMethod
    public void setup01(){
        driver.get("https://www.amazon.com/");

    }


    // test01
    // https://www.amazon.com/ adresine gidilir
    // Search yanindaki All butonuna tiklanir
    // Oradaki seceneklerden "Computers" bolumu secilir
    // arama kotusuna mouse yazili ve aratilir
    //  Cikansonuc yazisi yazdirilir ve "mouse" icerdigi test edilir
    // ve sayfa kapatilir
    @Test
    public void test01(){
        WebElement allKategosiElement=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(allKategosiElement);
        select.selectByIndex(7);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse"+ Keys.ENTER);
        WebElement sonucyazisiElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr=sonucyazisiElementi.getText();
        System.out.println(sonucYazisiStr);
        String expectedResult="mouse";
        Assert.assertTrue(sonucYazisiStr.contains(expectedResult));

    }


    // test02
    // https://www.amazon.com/ adresine gidilir
    // Oradaki dilsecenekleri butonu ustune gidilir
    // Dil secenegi Ingilizce secilir
    // Sayfa dilinin Ingilizce oldugu test edilir
    // ve sayfa kapatilir
    @Test
    public void test02(){
       WebElement dilSecenegi= driver.findElement(By.xpath("//span[@class='nav-icon nav-arrow']"));
      Actions actions=new Actions(driver);
       /*
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN);   burada sayfanin asagisina gitmedi */

        actions.moveToElement(dilSecenegi);
        driver.findElement(By.xpath("//span[.='English']")).click();
        driver.findElement(By.xpath("//input[@aria-labelledby='icp-btn-save-announce']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Today's Deals")).getText(),"Today's Deals");


    }

    //test03
    // https://www.amazon.com/ adresine gidilir
    // aramakutusuna "sefiller victor hugo" yazdirilip aratilir
    // Acilan sayfada en solda Customer Review kismi 4 ildiz secilir
    // cikan ilk kitabin yildiz seviyesi 4 ve ustu oldugu test edilir
    // sayfa kapatilir

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sefiller victor hugo"+Keys.ENTER);
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']")).click();
        WebElement yildizElement=driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom']"));
       Actions actions=new Actions(driver);
       actions.moveToElement(yildizElement);
       Thread.sleep(3000);
        String yildizStr=driver.findElement(By.xpath("//span[@class='a-icon-alt']")).getText();
        System.out.println(yildizStr);
        Thread.sleep(2000);
        Assert.assertTrue(yildizStr.substring(0,1).equals("4"));




    }

}
