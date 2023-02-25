package TEKRAR;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dropdown {
    /*
    https://www.bestbuy.com adresine giden farklı test methodları olusturarak asağidaki testleri yapın
    - sayfa url nin " https://www.bestbuy.com a esit oldugunu test edin
    -titleTest** sayfa başlıgının "rest" içermediğini test edin
    -logo test** bestbuy logosunun göruntulendiğni test edin
    -francaisLinkTest** fransızca lınkın göruntulendğini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        // https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");
        // - sayfa url nin " https://www.bestbuy.com a esit oldugunu test edin
        String exceptedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(exceptedUrl, actualUrl);
    }

    //sayfa başlıgının "rest" içermediğini test edin
    @Test
    public void test1() {
        String istenmeyenKelime = "Rest";
        String actualkelime = driver.getTitle();
        Assert.assertFalse(actualkelime.contains(istenmeyenKelime));
    }

    //-logo test** bestbuy logosunun göruntulendiğni test edin
    @Test
    public void test2() {
        WebElement logo = driver.findElement(By.xpath("(//img[@class=\"logo\"])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    // -francaisLinkTest** fransızca lınkın göruntulendğini test edin
    @Test
    public void test3(){
        WebElement francaisLink = driver.findElement(By.xpath("//*[text()=\"Français\"]"));
        Assert.assertTrue(francaisLink.isDisplayed());
    }
}
