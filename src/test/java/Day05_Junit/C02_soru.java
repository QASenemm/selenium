package Day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_soru {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// "http://zero.webappsecurity.com/ sitesine gidin
        driver.get("http://zero.webappsecurity.com/");
//signin butonuna tıklayın
        driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click();
        // login alanına "username" yazdırın
        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("username");
        //password alanına "password yazdırın
        driver.findElement(By.xpath("//input[@id=\"user_password\"]")).sendKeys("password");
        //sign in butonuna tıklayın
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

        driver.navigate().back();
        //onlıne bankıng menusunde pay billss sayfasına gidin "
        driver.findElement(By.xpath("(//*[text()=\"Online Banking\"])[1]")).click();
        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        //amaount kısmına yatırmak istediğiniz miktarı yazın
        driver.findElement(By.xpath("//input[@name=\"amount\"]")).sendKeys("500");
        //tarıh kısmına asagısaki tarıihi yazın
        driver.findElement(By.xpath("//input[@id=\"sp_date\"]")).sendKeys("2020-09-10");
        //paybutonuna tıklayın
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        // yazının cıkıp cıkmadıgını kontol edin
        WebElement sonucyazisielementi = driver.findElement(By.xpath("//div[@id=\"alert_content\"]"));
        if (sonucyazisielementi.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
