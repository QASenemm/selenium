package Day08_handle_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C04_Handle_iframe {
    /*
    https://html.com/tags/iframe/  gidin
    bir method olusturun iframetest
    "An Iframe containing" textinin erişilebilir oldugunu test edin
    ve konsola yazdıırn
    text box a "merhaba dünya "yazdırın
    textboxın altında bulunan"element selenium"linkini textin görunur oldugunu doğrulayın
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void iframe() {
        //http://the-internet.herokuapp.com/iframe gidin
        driver.get("http://the-internet.herokuapp.com/iframe");
        //"An Iframe containing" textinin erişilebilir oldugunu test edin
        //    ve konsola yazdırın
        WebElement baslikelemnti = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikelemnti.isEnabled());
        System.out.println(baslikelemnti.getText());
        // text box a "merhaba dünya "yazdırın
        //textbox u doğru olarak locate etmemenize ragmen drivr bulamadı
        //bunun üzerine  html kodları inceleyınce
        //textboxın aslında bir iframe içerisinde oldugunu gördük bu durumda önce
        //iframe locate edıp,
        //switchto() ile iframe gecmeliyız
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textbox = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dünya");
        //textboxın altında bulunan"element selenium"linkini textin görunur oldugunu doğrulayın
       //textboxi doğru locate etmemize ragmen driver bulamadı
        //bunun üzerine html kodları inceleyince
        //textboxin aslında bir iframe içerisnde oldugunu gördük
        //bu durumda önce iframe i locate edip
        //switchTo() ile o iframe geçmeliyız
        driver.switchTo().defaultContent();
        WebElement linkyazi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkyazi.isDisplayed());
        System.out.println(linkyazi.getText());
    }
}