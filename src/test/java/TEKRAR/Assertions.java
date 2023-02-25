package TEKRAR;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions {
    //amazon anasayfaya gidin
    //    3 farklı test methodu olusturarak asağıdaki görevleri yapın
    //    1-url in amazon içerdğini test edin
    //    2-titlenin facebook içermedğini test edin
    //    3- sol üst kösede amazon logosu görundügünü test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        // 1-url in amazon içerdğini test edin

        String exceptedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(exceptedUrl));
    }

    // 2-titlenin facebook içermedğini test edin
    @Test
    public void test2() {
        String istenmeyenKelime = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }

    // 3- sol üst kösede amazon logosu görundügünü test edin
    @Test
    public void test3() {
        WebElement logo = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
