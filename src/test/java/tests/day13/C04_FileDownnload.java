package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownnload extends TestBase {




    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:


    @Test
    public void isExistTesti(){
        //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        //"C:\Users\Dell\Downloads\sample.png"
        String downloadDosya=System.getProperty("user.home")+"\\Downloads\\sample.png\\";
        Assert.assertTrue(Files.exists(Paths.get(downloadDosya)));

    }


    @Test
    public void downloadTesti() throws InterruptedException {
        //        - https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get(" https://the-internet.herokuapp.com/download");
        //        - sample.png dosyasını indirelim
        driver.findElement(By.linkText("sample.png")).click();

        Thread.sleep(5000);




    }

}
