package Day06_RadioButton_checkBOx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;

    // gerekli yapıyı olusturun
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teamDown() {
        driver.quit();
    }

    // https://www.facebook.com sayfasına gidin
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        //cookıesi kabul edin
        //"create account" butonuna basın
        driver.findElement(By.xpath("//a[@ajaxify=\"/reg/spotlight/\"]")).click();

        // radio button elemnetleri locate edin
        WebElement kadinButonu = driver.findElement(By.xpath("//*[text()=\"Kadın\"]"));
        WebElement erkekButonu = driver.findElement(By.xpath("//*[text()=\"Erkek\"]"));
        WebElement ozelButton = driver.findElement(By.xpath("//*[text()=\"Özel\"]"));
        //secili değilse cinsiyet butonundan size uygun olanu seçin

        Thread.sleep(3000);
        if (!kadinButonu.isSelected()) {
            kadinButonu.click();
        }
        Thread.sleep(3000);
    }
}
