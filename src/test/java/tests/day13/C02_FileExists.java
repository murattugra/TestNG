package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileExists {



    @Test
    public void test01(){

        System.out.println(System.getProperty("user.home"));

        // masaustundeki Deneme klasorunun Pathini istesem
        // "C:\Users\Dell\Desktop\Deneme\Selenium.ods"

        // yani dinamik olarak masa ustundeki deneme klasorunun Path ini yazmak istersem

        String path=System.getProperty("user.home")+"\\Desktop\\Deneme\\Selenium.ods";

        System.out.println(path);

        System.out.println("user.dir:  "+System.getProperty("user.dir"));

        // MASA USTUNDE DENEME klasoru icinde Selenium.ods isminde bir dosya oldugunu test edin

        // once bu dosyaya ulasmak icin gerekli dinamik path olusturulmali
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\Selenium.ods";

        System.out.println( Files.exists(Paths.get(dosyaYolu)));// boolean doner eger true ise dosya vardir demektir

        // C:\Users\Dell\IdeaProjects\com.TestNGBatch44\pom.xml pom.xml yolu

        System.out.println(System.getProperty("user.dir"));// bu bana projemin yolunu verir

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));




    }


}
