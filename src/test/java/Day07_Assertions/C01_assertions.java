package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_assertions {
    /*
    amazon anasayfaya gidin
    3 farklı test methodu olusturarak asağıdaki görevleri yapın
    1-url in amazon içerdğini test edin
    2-titlenin facebook içermedğini test edin
    3- sol üst kösede amazon logosu görundügünü test edin
     */


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
        driver.close();
    }

    @Test
    public void test1() {

        //1-url in amazon içerdğini test edin
        String arananKelime = "amazon";
        String actualurl = driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(arananKelime));
    }

    @Test
    public void test2() {
        //2-titlenin facebook içermedğini test edin
        String istenmeyenkelime = "facebook";
        String actualtitle = driver.getTitle();
        Assert.assertFalse(actualtitle.contains(istenmeyenkelime));
    }

    @Test
    public void test3() {
        // 3- sol üst kösede amazon logosu görundügünü test edin
        WebElement logoElement = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElement.isDisplayed());

    }
}
