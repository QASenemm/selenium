package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AssertionsOrnek {
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
        driver.get("https://www.bestbuy.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //- sayfa url nin " https://www.bestbuy.com a esit oldugunu test edin
        String exceptedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(exceptedUrl, actualUrl);
    }

    @Test
    public void test2() {
        // -titleTest** sayfa başlıgının "rest" içermediğini test edin

        String istenmeyenTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenTitle));
    }

    @Test
    public void test3() {
        //-logo test** bestbuy logosunun göruntulendiğni test edin
        WebElement logoElement = driver.findElement(By.xpath("(//img[@class=\"logo\"])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void test4() {
        //francaisLinkTest** fransızca lınkın göruntulendğini test edin
        WebElement fransizcaLink = driver.findElement(By.xpath("//*[text()=\"Français\"]"));
        Assert.assertTrue(fransizcaLink.isDisplayed());


    }

}
