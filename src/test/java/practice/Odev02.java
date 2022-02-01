package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Odev02 extends TestBase {

    //2.soru :Ingilizce
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
//2.soru:Turkce



    @Test
    public void test01(){
        // url'ye gidin :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        // "Alert with OK"yi tıklayın ve 'click the button to display a confirm box' i tıklayın:'
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        // Uyarıyı kabul et(I am an alert box!) ve uyarıyı konsolda yazdır
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //  "Alert with OK & Cancel" ı tıklayın ve 'click the button to display a confirm box' i tıklayın
        driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        // Uyarıyı iptal et (Press a Button !)
        driver.switchTo().alert().dismiss();
        // "Alert with Textbox" ı tıklayın ve 'click the button to demonstrate the prompt box' tıklayın'
        driver.findElement(By.linkText("Alert with Textbox" )).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        // ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        // sonunda "Hello TechproEducation How are you today" mesajını konsola yazdır (edited)
        System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());

    }


}
