package MeineUbungen;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class WindowsHandle_Tk extends TestBase{

    // ● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test01(){
    driver.get("https://www.amazon.com");
    String amazonHandle=driver.getWindowHandle();
    Assert.assertTrue(driver.getTitle().contains("Amazon"));
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.techproeducation.com/");
    Assert.assertTrue(driver.getTitle().contains("TECHPROEDUCATION"));
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.walmart.com/");
    driver.switchTo().window(amazonHandle);
    Assert.assertTrue(driver.getTitle().contains("Amazon"));



    }

}
