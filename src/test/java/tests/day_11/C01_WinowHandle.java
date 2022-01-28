package tests.day_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WinowHandle {


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https:/www.amazon.com");
        String winwowHandleDegeri1 = driver.getWindowHandle();
        System.out.println(" ilk sayfanin handle degeri" + driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.WINDOW);//yENI BIR PENCEREDE acilir
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getWindowHandle());

        Set<String> handleDegerleri = driver.getWindowHandles();

        System.out.println(handleDegerleri);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");


        // amazon un acik oldugu sayfaya gecin ve nutella icin arama yapin

        driver.switchTo().window("");


        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
